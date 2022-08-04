package dialogos;

import javax.swing.JOptionPane;

public class DialogoParse {
    private static final DialogoParse INSTACIA = new DialogoParse();

    public DialogoParse() {
    }
    
    public static DialogoParse getINSTACIA() {
        return INSTACIA;
    }
    
    public void erroParseGrupoDTO(){
        JOptionPane.showMessageDialog(null, "Erro de conversao de Grupo DTO.", "ERRO" ,JOptionPane.ERROR_MESSAGE);
    }
    
    public void erroParseEventoDTO(){
        JOptionPane.showMessageDialog(null, "Erro de conversao de Evento DTO.\n Atencao parametros introduzidos.", "ERRO" ,JOptionPane.ERROR_MESSAGE);
    }
    
    public void erroParseNumero(){
        JOptionPane.showMessageDialog(null, "Erro de conversao de Numero.", "ERRO" ,JOptionPane.ERROR_MESSAGE);
    }
    
    public void erroParseData(){
        JOptionPane.showMessageDialog(null, "Erro de conversao de Data.", "ERRO" ,JOptionPane.ERROR_MESSAGE);
    }
}
