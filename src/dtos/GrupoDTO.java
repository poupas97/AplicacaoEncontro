package dtos;

import java.text.ParseException;
import java.util.Date;

public class GrupoDTO { 
    
    private int posicao;
    private String nome;
    private String localizacao;
    private String distrito;
    private String concelho;
    private String email;
    private String contacto;
    private int nTocadores;
    private int nAcompanhantes;
    private String horaPrevista;
    private boolean especial;
    private boolean tocar;
    private int nTocadoresReal;

    public GrupoDTO(int posicao, String nome, String localizacao, String distrito, String concelho, String email, 
            String contacto, int nTocadores, int nAcompanhantes, String horaPrevista, boolean especial, boolean tocar) {
        this.posicao = posicao;
        this.nome = nome;
        this.localizacao = localizacao;
        this.distrito = distrito;
        this.concelho = concelho;
        this.email = email;
        this.contacto = contacto;
        this.nTocadores = nTocadores;
        this.nAcompanhantes = nAcompanhantes;
        this.horaPrevista = horaPrevista;
        this.especial = especial;
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

    public String getHoraPrevista() {
        return horaPrevista.split(" ")[1];
    }
    
    public String getDataPrevista() {
        return horaPrevista.split(" ")[0];
    }
    
    public String getFullDataPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(String horaPrevista) {
        this.horaPrevista = horaPrevista;
    }
    
    public Date getStringToDate(){
        try {
            return (constantes.Constantes.FORMATER).parse(horaPrevista);
        } catch (ParseException ex) {
        }
        return null;
    }

    public boolean isTocar() {
        return tocar;
    }
    
    public String isTocarString() {
        return (tocar ? "sim" : "nao");
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
        return "#" + posicao + "     " + nome + "     " + localizacao + " (" + concelho + ", " + distrito + 
                ")     Tocadores: " + nTocadores + "     Acompanhates: " + nAcompanhantes + "     Hora prevista: " + 
                horaPrevista + "     Atuacao: " + (tocar ? "sim" : "nao");
    }
    
    public String toStringPalco() {
        return ("#" + posicao + "     " + nome + "     Localizacao: " + localizacao + " (" + concelho + ", " + distrito + 
                ")     Tocadores: " + nTocadores + "     Atuacao: " + (tocar ? "sim" : "nao")).toUpperCase();
    }
}
