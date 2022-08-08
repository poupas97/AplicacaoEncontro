package modelos;

import java.util.Calendar;

public class Evento {
    private static final int minAdicionais = 2;
    
    private String nome;
    private Calendar date;
    private int minutosGrupo;

    public Evento() {
    }

    public Evento(String nome, Calendar data, int minutosGrupo) {
        this.nome = nome;
        this.date = data;
        this.minutosGrupo = minutosGrupo + minAdicionais;
    }

    public String getNome() {
        return nome;
    }

    public Calendar getData() { return (Calendar) date.clone(); }

    public void setData(Calendar data) {
        this.date = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getMinutosGrupo() {
        return minutosGrupo;
    }

    public void setMinutosGrupo(int minutosGrupo) {
        this.minutosGrupo = minutosGrupo;
    }

    @Override
    public String toString() {
        return "nome: " + nome + "     data: " + date;
    }
}
