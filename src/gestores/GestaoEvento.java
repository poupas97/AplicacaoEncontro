package gestores;

import modelos.Evento;
import util.Ficheiro;


public class GestaoEvento {
    private Evento evento;
    
    private static final GestaoEvento INSTACIA = new GestaoEvento();
    private final Ficheiro FICHEIRO_INS = Ficheiro.getINSTACIA();
    
    public static GestaoEvento getINSTACIA() {
        return INSTACIA;
    }
    
    private GestaoEvento() {
        evento = new Evento();
    }

    public Evento getEvento() {
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("GET EVENTO");

        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("SET EVENTO");
    }
       

}

