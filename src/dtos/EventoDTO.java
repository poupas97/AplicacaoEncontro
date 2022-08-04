package dtos;

import java.text.ParseException;
import java.util.Date;

public class EventoDTO {
    
    private String nome;
    private String morada;
    private String data;
    private String minutosGrupo;

    public EventoDTO(String nome, String morada, String data, String minutosGrupo) {
        this.nome = nome;
        this.morada = morada;
        this.data = data;
        this.minutosGrupo = minutosGrupo;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }
    
    public String getFullData() {
        return data;
    }

    public String getData() {
        return data.split(" ")[0];
    }
    
    public String getHora() {
        return data.split(" ")[1];
    }
    
    public Date getStringToDate(){
        try {
            return (constantes.Constantes.FORMATER).parse(data);
        } catch (ParseException ex) {
        }
        return null;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getMinutosGrupo() {
        return minutosGrupo;
    }

    public void setMinutosGrupo(String minutosGrupo) {
        this.minutosGrupo = minutosGrupo;
    }
    
    @Override
    public String toString() {
        return "DTO#" + nome + "   " + morada + "   " + data + "   " + minutosGrupo;
    }
}
