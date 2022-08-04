package modelos;

import java.util.Date;
import util.Data;

public class Evento {
    private static final int minAdicionais = 2;
    
    private String nome;
    private String morada;
    private Data data;
    private int minutosGrupo;

    public Evento() {
    }

    public Evento(String nome, String morada, Data data, int minutosGrupo) {
        this.nome = nome;
        this.morada = morada;
        this.data = data;
        this.minutosGrupo = minutosGrupo + minAdicionais;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getMinutosGrupo() {
        return minutosGrupo;
    }

    public void setMinutosGrupo(int minutosGrupo) {
        this.minutosGrupo = minutosGrupo;
    }
    
}
