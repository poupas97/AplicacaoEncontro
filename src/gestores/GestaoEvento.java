package gestores;

import dtos.EventoDTO;
import util.Data;
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

    public EventoDTO getEvento() {
        return eventoToDTO(evento);
    }

    public void setEvento(Evento evento, String acesso) {
        this.evento = evento;
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("SET EVENTO");
    }
    
    public void setEvento(EventoDTO eventoDTO, String acesso){
        evento.setData(new Data(eventoDTO.getStringToDate()));
        evento.setMinutosGrupo(eventoDTO.getMinutosGrupo().isEmpty() ? 0 : 
                Integer.parseInt(eventoDTO.getMinutosGrupo()) + constantes.Constantes.MINUTOS_DELAY_ENTRE_GRUPOS);
        evento.setMorada(eventoDTO.getMorada());
        evento.setNome(eventoDTO.getNome());
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("SET EVENTO DTO");
    }
       
    public EventoDTO eventoToDTO(Evento evento){
        return new EventoDTO(
                evento == null ? "" : evento.getNome(), 
                evento == null ? "" : evento.getMorada(), 
                evento != null && evento.getData() == null ? "dd-mm-aaaa hh:mm" : evento.getData().dataToString(), 
                String.valueOf(evento.getMinutosGrupo()));
    }
}

