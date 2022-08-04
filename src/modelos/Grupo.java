package modelos;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import util.Data;

public class Grupo {
    private static final AtomicInteger counter = new AtomicInteger(0);
    
    private int posicao;
    private String nome;
    private String localizacao;
    private String distrito;
    private String concelho;
    private String email;
    private String contacto;
    private int nTocadoresIncricao;
    private int nAcompanhantesInscricao;
    private Data horaPrevista;
    private boolean especial;
    private boolean tocar;
    private int nTocadoresReal;

    public Grupo() {
    }

    public Grupo(String nome, String localizacao, String distrito, String concelho, String email, String contacto, 
            int nTocadores, int nAcompanhantes, Data horaPrevista) {
        posicao = counter.incrementAndGet();
        this.nome = nome;
        this.localizacao = localizacao;
        this.distrito = distrito;
        this.concelho = concelho;
        this.email = email;
        this.contacto = contacto;
        this.nTocadoresIncricao = nTocadores;
        this.nAcompanhantesInscricao = nAcompanhantes;
        this.horaPrevista = horaPrevista;
        this.especial = false;
    }    

    public Grupo(String nome, Data horaPrevista) {
        posicao = counter.incrementAndGet();
        this.horaPrevista = horaPrevista;
        this.especial = true;
        this.nome = nome;
        
        this.localizacao = "";
        this.distrito = null;
        this.email = "";
        this.contacto = "";
        this.nTocadoresIncricao = 0;
        this.nAcompanhantesInscricao = 0;
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

    public int getnTocadoresIncricao() {
        return nTocadoresIncricao;
    }

    public void setnTocadoresIncricao(int nTocadoresIncricao) {
        this.nTocadoresIncricao = nTocadoresIncricao;
    }

    public int getnAcompanhantesInscricao() {
        return nAcompanhantesInscricao;
    }

    public void setnAcompanhantesInscricao(int nAcompanhantesInscricao) {
        this.nAcompanhantesInscricao = nAcompanhantesInscricao;
    }

    public Data getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(Date horaPrevista) {
        this.horaPrevista = new Data(horaPrevista);
    }
    
    public void setHoraPrevista(Data horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public boolean isTocar() {
        return tocar;
    }

    public void setTocar(boolean tocar) {
        this.tocar = tocar;
    }

    public int getnTocadoresReal() {
        return nTocadoresReal;
    }

    public void setnTocadoresReal(int nTocadoresReal) {
        this.nTocadoresReal = nTocadoresReal;
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

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    
    @Override
    public String toString() {
        return "#" + posicao + "     " + nome + "     " + localizacao + " (" + distrito + ")     Tocadores: " + 
                nTocadoresIncricao + "     Acompanhates: " + nAcompanhantesInscricao + "     Hora prevista: " + horaPrevista + 
                "     Atuacao: " + (tocar ? "sim" : "nao");
    }
}
