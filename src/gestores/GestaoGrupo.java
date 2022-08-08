package gestores;

import java.time.Duration;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import modelos.Grupo;
import util.Ficheiro;


public class GestaoGrupo {
    private final ArrayList<Grupo> grupos;
    private HashMap<String, Integer> hashMap;
    private DefaultListModel listagem;
    
    private static final GestaoGrupo INSTACIA = new GestaoGrupo();
    private final GestaoEvento GESTAO_EVENTO = GestaoEvento.getINSTACIA();
    private final Ficheiro FICHEIRO_INS = Ficheiro.getINSTACIA();
    
    public static GestaoGrupo getINSTACIA() {
        return INSTACIA;
    }
    
    private GestaoGrupo() {
        grupos = new ArrayList<>();
    }
    
    public Grupo getGrupo(int index){
        return getGrupos().get(index);
    }

    public void adicionarLinhaBranca(String nome, Calendar data){
        Grupo grupo = new Grupo((nome.trim().isEmpty() ? "ESPECIAL" : nome), (Calendar) data.clone());
        grupos.add(grupo);

        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("ADICIONAR GRUPO ESPECIAL" + grupo.getDataHoraPrevista());
        exportarGrupos();
    }
    
    public Grupo adicionarGrupo(String nome, String localizacao, String distrito, String concelho, int nTocadores, int nAcompanhantes, String contacto, String email, String hora)  {
        if(nome.isEmpty() || localizacao.isEmpty() || nTocadores < 0 || nAcompanhantes < 0 || !isValidContacto(contacto) || !isValidEmail(email)){
            return null;
        }

        Calendar data = GestaoEvento.getINSTACIA().getEvento().getData();

        if (hora != null){
            String[] splited = hora.split(":");
            data.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splited[0]));
            data.set(Calendar.MINUTE, Integer.parseInt(splited[1]));
        } else {
            data = getUltimaDataDisponivel();
        }
        
        if(existeNomeGrupo(nome)){
            return null; 
        }

        Grupo grupo = new Grupo(nome, localizacao, distrito, concelho.equals(constantes.Constantes.SELECIONE_UM_CONCELHO) ? null : concelho,
            email, contacto, nTocadores, nAcompanhantes, (Calendar) data.clone(), false);

        grupos.add(grupo);

        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("ADICIONAR GRUPO " + grupo.getNome());

        exportarGrupos();

        checkAdicionarLinhaBranca();

        return grupo;
    }
    
    public Calendar getUltimaDataDisponivel(){
        ArrayList<Grupo> grupos = getGrupos();

        int minutosGrupo = GESTAO_EVENTO.getEvento().getMinutosGrupo();

        Calendar dataEvento = (Calendar) GESTAO_EVENTO.getEvento().getData().clone();

        if(grupos.size() == 0){
            return dataEvento;
        }

        Calendar current;
        Calendar data = Calendar.getInstance();

        if(grupos.size() == 1){
            current = (Calendar) grupos.get(0).getDataHoraPrevista().clone();

            data.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH), current.get(Calendar.HOUR_OF_DAY), current.get(Calendar.MINUTE));
            data.add(Calendar.MINUTE, minutosGrupo);

            Calendar clone = (Calendar) data.clone();
            long diferenca = Duration.between(dataEvento.toInstant(), clone.toInstant()).toMinutes();

            return diferenca > minutosGrupo ? dataEvento : clone;
        }


        for(int i = 0; i < grupos.size() - 1; i++){
            long diferenca = Duration.between(grupos.get(i).getDataHoraPrevista().toInstant(), grupos.get(i + 1).getDataHoraPrevista().toInstant()).toMinutes();

            if(diferenca > minutosGrupo){
                current = (Calendar) grupos.get(i).getDataHoraPrevista().clone();

                data.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH), current.get(Calendar.HOUR_OF_DAY), current.get(Calendar.MINUTE) );
                data.add(Calendar.MINUTE, minutosGrupo);

                return (Calendar) data.clone();
            }
        }

        Calendar ultimoGrupo = (Calendar) grupos.get(grupos.size() - 1).getDataHoraPrevista().clone();
        data.set(ultimoGrupo.get(Calendar.YEAR), ultimoGrupo.get(Calendar.MONTH), ultimoGrupo.get(Calendar.DAY_OF_MONTH), ultimoGrupo.get(Calendar.HOUR_OF_DAY), ultimoGrupo.get(Calendar.MINUTE) );
        data.add(Calendar.MINUTE, minutosGrupo);

        return (Calendar) data.clone();
    }
    
    private void checkAdicionarLinhaBranca(){
        int quantideGrupos = getQtdGrupos();

        if((quantideGrupos % constantes.Constantes.NUMERO_GRUPO_PARA_INSERIR_ESPECIAL) != 0) return;

        Calendar data = (Calendar) getUltimaDataDisponivel().clone();
        adicionarLinhaBranca("", (Calendar) data.clone());
    }
    
    public Grupo editarGrupo(String nome, String localizacao, String distrito, String concelho, int nTocadores, int nAcompanhantes, String contacto, String email, String hora) {
        Grupo nextGrupo = getGrupoByNome(nome);

        if (nextGrupo == null ) return null;

        if(localizacao.isEmpty() || nTocadores < 0 || nAcompanhantes < 0 || !isValidContacto(contacto) || !isValidEmail(email)){
            return null;
        }

        nextGrupo.setNome(nome);
        nextGrupo.setLocalizacao(localizacao);
        nextGrupo.setnTocadores(nTocadores);
        nextGrupo.setnAcompanhantes(nAcompanhantes);
        nextGrupo.setConcelho(concelho.equals(constantes.Constantes.SELECIONE_UM_CONCELHO) ? null : concelho);
        nextGrupo.setDistrito(distrito);
        nextGrupo.setContacto(contacto);
        nextGrupo.setEmail(email);

        Calendar data = nextGrupo.getDataHoraPrevista();
        String[] splited = hora.split(":");
        data.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splited[0]));
        data.set(Calendar.MINUTE, Integer.parseInt(splited[1]));

        nextGrupo.setHoraPrevista(data);
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("EDITAR GRUPO " + nextGrupo.getNome());
        exportarGrupos();
        
        return nextGrupo;
    }
    
    public void removerGrupo(int index) {
        Grupo grupo = getGrupo(index);
        String nome = grupo.getNome();
        
        getGrupos().remove(index);
        
        for(int i = index; i < getQtdGrupos(); i++){
            getGrupo(i).getDataHoraPrevista().add( Calendar.MINUTE, -GESTAO_EVENTO.getEvento().getMinutosGrupo());
        }
                
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("REMOVER GRUPO " + nome);
        exportarGrupos();
    }
    
    public boolean isValidEmail(String email) {
        if (email == null || email.length() == 0) return true;

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);

        return m.matches();
    }
    
    public boolean isValidContacto(String contacto) {
        return contacto.matches("[0-9]+") && contacto.length() == 9;
    }
    
    public ArrayList<Grupo> getGrupos() {
        grupos.sort(Comparator.comparing(Grupo::getDataHoraPrevista));
        return grupos;
    }
    
    public ArrayList<Grupo> getGruposNaoAtuaram() {
        ArrayList<Grupo> gruposNaoAturam = new ArrayList<>();
        for(Grupo g : getGrupos()){
            if(!g.isTocar()){
                gruposNaoAturam.add(g);
            }
        }
        return gruposNaoAturam;
    }
    
    public ArrayList<Grupo> getGruposDTOsNaoAtuaram() {
        return getGruposNaoAtuaram();
    }
    
    public Grupo getUltimoGrupo() {
        return getGrupos().get(grupos.size() - 1);
    }

    public Grupo getGrupoByNome(String nomeGrupo){
        for (Grupo grupo : grupos) {
            if(grupo.getNome().equals(nomeGrupo))
                return grupo;
        }
        return null;
    }
    
    public Grupo getGrupoByHoraPrevista(String horaPrevista){
        /* for (Grupo grupo : grupos) {
            if(grupo.getDataHoraPrevista().getMinutosEntreDatas(horaPrevista) == 0)
                return grupo;
        }
        return null;

         */

        return null;
    }
    
    public Grupo getGrupoByPosicao(int posicao){
        for (Grupo grupo : grupos) {
            if(grupo.getPosicao() == posicao)
                return grupo;
        }
        return null;
    }
    
    public boolean existeNomeGrupo(String nome) {
        for (Grupo g : grupos) {
            if(g.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
    
    public int getQtdGrupos(){
        return grupos.size();
    }
    
    public int getQtdTocadores(){
        int qtd = 0;
        for (Grupo grupo : grupos) {
            qtd += grupo.getnTocadores();
        }
        return qtd;
    }
    
    public int getQtdAcompanhantes(){
        int qtd = 0;
        for (Grupo grupo : grupos) {
            qtd += grupo.getnAcompanhantes();
        }
        return qtd;
    }
    
    public void alterarHoraPrevista(String dataInicial, boolean acerto){
        /* int minAcrescentar = 0;
        for(Grupo g : getGrupos()){
            if((acerto && !g.isTocar()) || !acerto){
                Data data = new Data(dataInicial);
                data.adicionarMinutos(minAcrescentar);
                g.setHoraPrevista(data);
                minAcrescentar += Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo());
            }
        }
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("TROCAR HORA PREVISTA DO GRUPO");
        */
    }

    public void setEstadoAtucao(String nome) {
        Grupo grupo = getGrupoByNome(nome);

        if(grupo == null){
            return;
        }

        grupo.setTocar(!grupo.isTocar());
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("CONFIRMACAO DA ATUACAO " + grupo.getNome());
        exportarGrupos();
    }
    
    public boolean exportarGrupos(){
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("EXPORTAR GRUPOS");

        return FICHEIRO_INS.exportarGrupoFicheiroTXT(getGrupos());
    }
    
    public boolean importarGrupos(){
        ArrayList<Grupo> grupos;

        if((grupos = FICHEIRO_INS.importarGruposFicheiroTXT()) == null) return false;

        for(Grupo g : grupos){
             adicionarGrupo(g.getNome(), g.getLocalizacao(), g.getDistrito(), g.getConcelho(), g.getnTocadores(), g.getnAcompanhantes(),
                    g.getContacto(), g.getEmail(), g.getHoraPrevista());
        }

        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("IMPORTAR GRUPOS");

        return true;
    }


    public ListModel<String> getListaGruposDistrito() {
        hashMap = new HashMap<>();
        for(Grupo g : grupos){
            String distrito = g.getDistrito();

            if(distrito == null || distrito.equals("")){
                continue;
            }

            if (!hashMap.containsKey(distrito)) {
                hashMap.put(distrito, 1);
            } else {
                hashMap.put(distrito, hashMap.get(distrito) + 1);
            }
        }
        
        listagem = new DefaultListModel();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            listagem.addElement(entry);
        }
        
        return listagem;
    }

    public ListModel<String> getListaGruposConcelho() {
        hashMap = new HashMap<>();
        for(Grupo g : grupos){
            String concelho = g.getConcelho();
            if(concelho == null || concelho.equals("")){
                continue;
            }

            if (!hashMap.containsKey(concelho)) {
                hashMap.put(concelho, 1);
            } else {
                hashMap.put(concelho, hashMap.get(concelho) + 1);
            }
        }
        
        listagem = new DefaultListModel();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            listagem.addElement(entry);
        }
        
        return listagem;
    }
    
}

