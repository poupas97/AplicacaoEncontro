package gestores;

import util.Data;
import dtos.GrupoDTO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import modelos.Grupo;
import util.Ficheiro;


public class GestaoGrupo {
    private ArrayList<Grupo> grupos;
    private HashMap<String, Integer> hashMap;
    private DefaultListModel listagem;
    
    private static final GestaoGrupo INSTACIA = new GestaoGrupo();
    private final GestaoEvento GESTAO_EVENTO = GestaoEvento.getINSTACIA();
    private final Ficheiro FICHEIRO_INS = Ficheiro.getINSTACIA();
    
    private int gruposNaoEspecial = 0, gruposEspecial = 0;
    
    public static GestaoGrupo getINSTACIA() {
        return INSTACIA;
    }
    
    private GestaoGrupo() {
        grupos = new ArrayList<>();
    }
    
    public Grupo getGrupo(int index){
        return getGrupos().get(index);
    }
    
    public GrupoDTO getGrupoDTO(int index){
        return grupoToDTO(getGrupo(index));
    }
    
    public GrupoDTO adicionarGrupoEspecial(String nome, Data data){
        Grupo grupo = new Grupo((nome.trim().isEmpty() ? "ESPECIAL" : nome), data);
        grupos.add(grupo);
        addGrupoEspecial();
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("ADICIONAR GRUPO ESPECIAL" + grupo.getHoraPrevista());
        exportarGrupos();
        
        //checkAdicionarEspecial();
        return grupoToDTO(grupo);
    }
    
    public GrupoDTO adicionarGrupo(GrupoDTO grupoDTO) throws ParseException {
        if(grupoDTO.getNome().isEmpty() || grupoDTO.getLocalizacao().isEmpty() || grupoDTO.getnTocadores() < 0 || 
                grupoDTO.getnAcompanhantes() < 0 || !isValidContacto(grupoDTO.getContacto())){
            return null;
        }
        
        Grupo grupo;
        Data data;
        if(grupos.isEmpty()){
            data = new Data(GESTAO_EVENTO.getEvento().getStringToDate());
            System.out.println("vazio");
        }else{
            data = getUltimaDataDisponivel();
            data.adicionarMinutos(Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo()));
        }
        
        if(existeNomeGrupo(grupoDTO.getNome())){
            return null; 
        }

        grupo = new Grupo(grupoDTO.getNome(), grupoDTO.getLocalizacao(), grupoDTO.getDistrito(), 
                    grupoDTO.getConcelho().equals(constantes.Constantes.SELECIONE_UM_CONCELHO) ? null : grupoDTO.getConcelho(),
                    grupoDTO.getEmail(), grupoDTO.getContacto(), grupoDTO.getnTocadores(), grupoDTO.getnAcompanhantes(), 
                    data);
        grupos.add(grupo);
        addGrupoNaoEspecial();
        
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("ADICIONAR GRUPO " + grupo.getNome());
        exportarGrupos();
        
        checkAdicionarEspecial();
        return grupoToDTO(grupo);
    }
    
    public Data getUltimaDataDisponivel(){
        ArrayList<Grupo> grupos = getGrupos();
        if(grupos.size() <= 1){
            return new Data(grupos.get(0).getHoraPrevista().dataToString());
        }
        for(int i = 0; i < grupos.size()-1; i++){
            if(grupos.get(i).getHoraPrevista().getMinutosEntreDatas(grupos.get(i+1).getHoraPrevista()) > 
                    Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo())){
                return new Data(grupos.get(i).getHoraPrevista().dataToString());
            }
        }
        return new Data(grupos.get(grupos.size()-1).getHoraPrevista().dataToString());
    }
    
    private void checkAdicionarEspecial(){
        if((getQtdGrupos() % constantes.Constantes.NUMERO_GRUPO_PARA_INSERIR_ESPECIAL) == 0){
            Data data = new Data(getUltimoGrupo().getHoraPrevista().dataToString());
            data.adicionarMinutos(Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo()));
            adicionarGrupoEspecial("", data);
        }
    }
    
    public GrupoDTO editarGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = getGrupoByPosicao(grupoDTO.getPosicao());
        
        grupo.setNome(grupoDTO.getNome());
        grupo.setLocalizacao(grupoDTO.getLocalizacao());
        grupo.setnTocadoresIncricao(grupoDTO.getnTocadores());
        grupo.setnAcompanhantesInscricao(grupoDTO.getnAcompanhantes());
        grupo.setConcelho(grupoDTO.getConcelho().equals(constantes.Constantes.SELECIONE_UM_CONCELHO) ? null : grupoDTO.getConcelho());
        grupo.setDistrito(grupoDTO.getDistrito());
        grupo.setContacto(grupoDTO.getContacto());
        grupo.setEmail(grupoDTO.getEmail());
        grupo.setTocar(grupoDTO.isTocar());
        grupo.setEspecial(grupoDTO.isEspecial());
        grupo.setHoraPrevista(grupoDTO.getStringToDate());
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("EDITAR GRUPO " + grupo.getNome());
        exportarGrupos();
        
        return grupoToDTO(grupo);
    }
    
    public void removerGrupo(int index) {
        Grupo grupo = getGrupo(index);
        if(grupo.isEspecial()){
            removeGrupoEspecial();
        }else{
            removeGrupoNaoEspecial();
        }
        String nome = grupo.getNome();
        
        getGrupos().remove(index);
        
        for(int i=index;i<getQtdGrupos();i++){
            getGrupo(i).getHoraPrevista().retirarMinutos(
                    Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo()));
        }
                
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("REMOVER GRUPO " + nome);
        exportarGrupos();
    }
    
    public boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
    public boolean isValidContacto(String contacto) {
        return contacto.matches("[0-9]+") && contacto.length() == 9;
    }
    
    private ArrayList<Grupo> getGrupos() {
        grupos.sort((o1, o2) -> o1.getHoraPrevista().getData().compareTo(o2.getHoraPrevista().getData()));
        return grupos;
    }
    
    public ArrayList<GrupoDTO> getGruposDTOs() {
        return (gruposToDTOs(getGrupos()));
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
    
    public ArrayList<GrupoDTO> getGruposDTOsNaoAtuaram() {
        return (gruposToDTOs(getGruposNaoAtuaram()));
    }
    
    public Grupo getUltimoGrupo() {
        return getGrupos().get(grupos.size() - 1);
    }
    
    public Grupo getPenultimoGrupo() {
        if(grupos.size() >= 2){
            return getGrupos().get(grupos.size() - 2);
        }
        return getGrupos().get(grupos.size() - 1);
    }
    
    public Grupo getUltimoGrupoNaoEspecial(){
        for(int i = getQtdGrupos() - 1; i >= 0; i--){
            if(!grupos.get(i).isEspecial()){
                return getGrupo(i);
            }
        }
        return null;
    }
    
    public Grupo getGrupoByName(String nomeGrupo){
        for (Grupo grupo : grupos) {
            if(grupo.getNome().equals(nomeGrupo))
                return grupo;
        }
        return null;
    }
    
    public Grupo getGrupoByHoraPrevista(String horaPrevista){
        for (Grupo grupo : grupos) {
            if(grupo.getHoraPrevista().getMinutosEntreDatas(horaPrevista) == 0)
                return grupo;
        }
        return null;
    }
    
    public GrupoDTO getGrupoDTOByName(String nomeGrupo){
        return grupoToDTO(getGrupoByName(nomeGrupo));
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
    
    public int getQtdGruposNaoEspecial(){
        return gruposNaoEspecial;
    }
    
    public int getQtdGruposEspecial(){
        return gruposEspecial;
    }
    
    public void addGrupoNaoEspecial(){
        gruposNaoEspecial++;
    }
    
    public void addGrupoEspecial(){
        gruposEspecial++;
    }
    
    public void removeGrupoNaoEspecial(){
        gruposNaoEspecial--;
    }
    
    public void removeGrupoEspecial(){
        gruposEspecial--;
    }
    
    public int getQtdTocadores(){
        int qtd = 0;
        for (Grupo grupo : grupos) {
            qtd += grupo.getnTocadoresIncricao();
        }
        return qtd;
    }
    
    public int getQtdTocadoresReal(){
        int qtd = 0;
        for (Grupo grupo : grupos) {
            if(grupo.isTocar()){
                qtd += grupo.getnTocadoresReal();
            }
        }
        return qtd;
    }
    
    public int getQtdAcompanhantes(){
        int qtd = 0;
        for (Grupo grupo : grupos) {
            qtd += grupo.getnAcompanhantesInscricao();
        }
        return qtd;
    }

    public void trocarGrupos(GrupoDTO grupoDTOOrigem, GrupoDTO grupoDTODestino){        
        //int posAux = grupoDTOOrigem.getPosicao();
        
        Grupo gOrigem = getGrupoByPosicao(grupoDTOOrigem.getPosicao());
        Grupo gDestino = getGrupoByPosicao(grupoDTODestino.getPosicao());

        //gOrigem.setPosicao(grupoDTODestino.getPosicao());
        gOrigem.setHoraPrevista(grupoDTODestino.getStringToDate());
        
        //gDestino.setPosicao(posAux);
        gDestino.setHoraPrevista(grupoDTOOrigem.getStringToDate());
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("TROCAR GRUPOS");
        exportarGrupos();
    }
    
    public void alterarHoraPrevista(String dataInicial, boolean acerto){
        int minAcrescentar = 0;
        for(Grupo g : getGrupos()){
            if((acerto && !g.isTocar()) || !acerto){
                Data data = new Data(dataInicial);
                data.adicionarMinutos(minAcrescentar);
                g.setHoraPrevista(data);
                minAcrescentar += Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo());
            }
        }
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("TROCAR HORA PREVISTA DO GRUPO");
    }
    
    public GrupoDTO grupoToDTO(Grupo grupo){
        return new GrupoDTO(grupo.getPosicao() , grupo.getNome(), grupo.getLocalizacao(), 
                grupo.getDistrito() == null ? "" : grupo.getDistrito(), 
                grupo.getConcelho() == null ? "" : grupo.getConcelho(),
                grupo.getEmail(), grupo.getContacto(), 
                grupo.getnTocadoresIncricao(), grupo.getnAcompanhantesInscricao(), 
                grupo.getHoraPrevista().dataToString(), grupo.isEspecial(), grupo.isTocar());
    }
    
    public ArrayList<GrupoDTO> gruposToDTOs(ArrayList<Grupo> grupos){
        ArrayList<GrupoDTO> grupoDTOs = new ArrayList<>();
        for(Grupo g :grupos){
            grupoDTOs.add(grupoToDTO(g));
        }
        return grupoDTOs;
    }

    public void setEstadoAtucao(String data) {
        Grupo grupo = getGrupoByHoraPrevista(data);
        if(grupo == null){
            return;
        }
        
        if(!grupo.isTocar()){
            grupo.setTocar(true);
            grupo.setnTocadoresReal(grupo.getnTocadoresIncricao());
        }else{
            grupo.setTocar(false);
            grupo.setnTocadoresReal(0);
        }
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("CONFIRMACAO DA ATUACAO " + grupo.getNome());
        exportarGrupos();
    }
    
    public boolean exportarGrupos(){
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("EXPORTAR GRUPOS");
        return FICHEIRO_INS.exportarGrupoDTOFicheiroTXT(getGruposDTOs());
    }
    
    public boolean importarGrupos(){
        ArrayList<GrupoDTO> grupos;
        if((grupos = FICHEIRO_INS.importarGrupoDTOFicheiroTXT()) == null){
            return false;
        }
        for(GrupoDTO g : grupos){
            try {
                adicionarGrupo(g);
            } catch (ParseException ex) {
                
            }
        }
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("IMPORTAR GRUPOS");
        return true;
    }

    public boolean avancarGrupo(int index) {   
        int iteracoes = index + constantes.Constantes.NUMERO_GRUPO_PARA_AVANCAR;
        if(iteracoes > (getQtdGrupos() - 1)){
            iteracoes = getQtdGrupos() - 1;
        }
        
        ArrayList<Grupo> array = new ArrayList<>();
        
        Grupo grupoInicial = getGrupo(index);
        Grupo grupo;
        for(int i = index+1; i <= iteracoes; i++){
            grupo = getGrupo(i);
            array.add(grupo);
        }
        
        int minutos = Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo());
        for(Grupo g : array){
            grupos.remove(g);
            g.getHoraPrevista().retirarMinutos(minutos);
            grupos.add(g);
        }
        
        grupos.remove(grupoInicial);
        grupoInicial.getHoraPrevista().adicionarMinutos(minutos * (iteracoes-index));
        grupos.add(grupoInicial);
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("AVANCAR GRUPO " + getGrupo(index).getNome());
        
        return true;
    }
    
    public boolean recuarGrupo(int index) {   
        int iteracoes = index - constantes.Constantes.NUMERO_GRUPO_PARA_AVANCAR;
        int aux = 0;
        if(iteracoes < 0){
            iteracoes = 0;
        }
        
        ArrayList<Grupo> array = new ArrayList<>();
        
        Grupo grupoInicial = getGrupo(index);
        Grupo grupo;
        System.out.println(index-1 + ""+iteracoes);
        for(int i = (index-1); i >= iteracoes; i--){
            grupo = getGrupos().get(i);
            array.add(grupo);
            aux++;
        }
        
        int minutos = Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo());
        for(Grupo g : array){
            grupos.remove(g);
            g.getHoraPrevista().adicionarMinutos(minutos);
            grupos.add(g);
        }
        
        grupos.remove(grupoInicial);
        grupoInicial.getHoraPrevista().retirarMinutos(minutos * aux);
        grupos.add(grupoInicial);
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("RECUAR GRUPO " + getGrupo(index).getNome());
        
        return true;
    }
    
    public Data getUltimaHora(){
        if(getPenultimoGrupo().getHoraPrevista().getMinutosEntreDatas(getUltimoGrupo().getHoraPrevista()) > 
                Integer.parseInt(GESTAO_EVENTO.getEvento().getMinutosGrupo())){
            return getPenultimoGrupo().getHoraPrevista();
        }
        return getUltimoGrupo().getHoraPrevista();
    }

    public ListModel<String> getListaGruposDistrito() {
        hashMap = new HashMap<>();
        for(Grupo g : grupos){
            String distrito = g.getDistrito();
            //System.out.println(distrito);
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

