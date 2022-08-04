package dialogos;

import javax.swing.JOptionPane;

public class DialogoGrupo {

    private static final DialogoGrupo INSTACIA = new DialogoGrupo();

    public DialogoGrupo() {
    }

    public static DialogoGrupo getINSTACIA() {
        return INSTACIA;
    }

    public void sucessoConfiguracaoGrupo() {
        JOptionPane.showMessageDialog(null, "Sucesso ao configurar Grupo.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void sucessoTrocarGrupo() {
        JOptionPane.showMessageDialog(null, "Sucesso ao Trocar Grupos.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void sucessoImportacaoGrupos() {
        JOptionPane.showMessageDialog(null, "Sucesso ao Importar os Grupos.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void sucessoExportacaoGrupos() {
        JOptionPane.showMessageDialog(null, "Sucesso ao exportar os Grupos.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void sucessoConfirmacaoGrupo() {
        JOptionPane.showMessageDialog(null, "Sucesso ao confirmar Grupo.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void erroConfiguracaoGrupo() {
        JOptionPane.showMessageDialog(null, "Erro ao configurar Grupo.", "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    public void erroExportacaoGrupos() {
        JOptionPane.showMessageDialog(null, "Erro ao exportar grupos.", "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    public void erroImportacaoGrupos() {
        JOptionPane.showMessageDialog(null, "Erro ao importar grupos.", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    
    public void acaoNaoAplicavel() {
        JOptionPane.showMessageDialog(null, "Nao pode aplicar essa acao", "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    public void faltamParametros() {
        JOptionPane.showMessageDialog(null, "Os campos assinalados com * devem estar preenchidos.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }

    public void selecionarGrupo() {
        JOptionPane.showMessageDialog(null, "Selecione um grupo.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }

    public void naoExistemGrupos() {
        JOptionPane.showMessageDialog(null, "Nao existem grupos.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }

    public int apagarGrupo(String nome) {
        return JOptionPane.showConfirmDialog(null,
                "Tem a certeza que quer apagar o grupo '" + nome + "'?", "Eliminar Conta",
                JOptionPane.YES_NO_OPTION);
    }
    
    public int avancarRecuarGrupo(){
        String[] buttons = {"Avancar", "Recuar", "Cancelar"};
        return JOptionPane.showOptionDialog(null, 
                "Avacar ou Recuar Grupo?", "Confirmacao",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);
    }
}
