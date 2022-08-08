package modelos;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Grupo {
    private static final AtomicInteger counter = new AtomicInteger(0);
    
    private int posicao;
    private String nome;
    private String localizacao;
    private String distrito;
    private String concelho;
    private String email;
    private String contacto;
    private int nTocadores;
    private int nAcompanhantes;
    private Calendar dataHoraPrevista;
    private boolean tocar;

    public Grupo() {
    }

    public Grupo(String nome, String localizacao, String distrito, String concelho, String email, String contacto, 
            int nTocadores, int nAcompanhantes, Calendar dataHoraPrevista, boolean tocar) {
        posicao = counter.incrementAndGet();
        this.nome = nome;
        this.localizacao = localizacao;
        this.distrito = distrito;
        this.concelho = concelho;
        this.email = email;
        this.contacto = contacto;
        this.nTocadores = nTocadores;
        this.nAcompanhantes = nAcompanhantes;
        this.dataHoraPrevista = dataHoraPrevista;
        this.tocar = tocar;
    }

    public Grupo(String nome, Calendar dataHoraPrevista) {
        posicao = counter.incrementAndGet();
        this.dataHoraPrevista = dataHoraPrevista;
        this.nome = nome;
        
        this.localizacao = "";
        this.distrito = null;
        this.email = "";
        this.contacto = "";
        this.nTocadores = 0;
        this.nAcompanhantes = 0;
    }

    public Grupo(int posicao, String nome, String localizacao, String distrito, String concelho, String email, String contacto,
                 int nTocadores, int nAcompanhantes, Calendar dataHoraPrevista, boolean tocar) {
        this.posicao = posicao;
        this.nome = nome;
        this.localizacao = localizacao;
        this.distrito = distrito;
        this.concelho = concelho;
        this.email = email;
        this.contacto = contacto;
        this.nTocadores = nTocadores;
        this.nAcompanhantes = nAcompanhantes;
        this.dataHoraPrevista = dataHoraPrevista;
        this.tocar = tocar;

    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getnTocadores() {
        return nTocadores;
    }

    public void setnTocadores(int nTocadores) {
        this.nTocadores = nTocadores;
    }

    public int getnAcompanhantes() {
        return nAcompanhantes;
    }

    public void setnAcompanhantes(int nAcompanhantes) {
        this.nAcompanhantes = nAcompanhantes;
    }

    public Calendar getDataHoraPrevista() {
        return dataHoraPrevista;
    }

    public void setDataHoraPrevista(Calendar dataHoraPrevista) {
        this.dataHoraPrevista = dataHoraPrevista;
    }
    
    public void setHoraPrevista(Calendar dataHoraPrevista) {
        this.dataHoraPrevista = dataHoraPrevista;
    }

    public boolean isTocar() {
        return tocar;
    }

    public void setTocar(boolean tocar) {
        this.tocar = tocar;
    }


    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String isTocarString() {
        return tocar ? "sim" : "nao";
    }

    public String getHoraPrevista() {
        return dataHoraPrevista.get(Calendar.HOUR_OF_DAY) + ":" + dataHoraPrevista.get(Calendar.MINUTE);
    }

    public String getDataHoraPrevistaString() {
        return dataHoraPrevista.get(Calendar.YEAR) + "/" + dataHoraPrevista.get(Calendar.MONTH) + "/" + dataHoraPrevista.get(Calendar.DAY_OF_MONTH) + " " +
        dataHoraPrevista.get(Calendar.HOUR_OF_DAY) + ":" + dataHoraPrevista.get(Calendar.MINUTE);
    }

    @Override
    public String toString() {
        return "#" + posicao + "     " + nome + "     " + localizacao + " (" + distrito + ")     Tocadores: " +
                nTocadores + "     Acompanhates: " + nAcompanhantes + "     Data Hora prevista: " + dataHoraPrevista +
                "     Atuacao: " + isTocarString();
    }
}
