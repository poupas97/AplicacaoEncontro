package dialogos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class DialogoEvento {
    private static final DialogoEvento INSTACIA = new DialogoEvento();

    public DialogoEvento() {
    }
    
    public static DialogoEvento getINSTACIA() {
        return INSTACIA;
    }
    
    public void faltamParametros(){
        JOptionPane.showMessageDialog(null, "Os campos assinalados com * devem estar preenchidos.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }
    
    public String introduzirAcesso(){
        JLabel label = new JLabel("Introduzir password");
        JPasswordField jpf = new JPasswordField();
        JOptionPane.showConfirmDialog(null, new Object[]{label, jpf}, "Password:", JOptionPane.OK_CANCEL_OPTION);
        String input = "";
        for(char c : jpf.getPassword()){
            input += c;
        }
        return input.equals(constantes.Constantes.ACESSO) ? input : null;
    }
    
    public void acessoErrado(){
        JOptionPane.showMessageDialog(null, "A password esta incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
}