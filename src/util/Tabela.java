package util;

import gestores.GestaoGrupo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.Grupo;

public class Tabela {
    private static final Tabela INSTACIA = new Tabela();
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    
    public static Tabela getINSTACIA() {
        return INSTACIA;
    }
    
    private Tabela() {
        
    }
    
    public DefaultTableModel getTableModel(String vista, JTable jTable1){
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setNumRows(0);
        ArrayList<Object[]> linhas = new ArrayList<>();
        
        switch(vista){
            case constantes.Constantes.VISTA_BARRENTA: 
                linhas = getLinhasBarrenta();
                break;
                
            case constantes.Constantes.VISTA_MOSTRAR_ATUACAO_PALCO: 
                linhas = getLinhasMostrarAtuacaoPalco(); 
                break;
        }
        
        for(Object[] o : linhas){
            tableModel.addRow(o);
        }
              
        return tableModel;
    }
    
    private ArrayList<Object[]> getLinhasBarrenta(){
        ArrayList<Object[]> linhas = new ArrayList<>();

        for (Grupo grupo : GESTAO_GRUPO.getGrupos()){
            String localizacao = grupo.getLocalizacao();
            String concelho = grupo.getConcelho();
            String distrito = grupo.getDistrito();

            if (concelho != null)
                localizacao = localizacao.concat(" (").concat(concelho).concat(", ").concat(distrito).concat(")");
            else if (distrito != null)
                localizacao = localizacao.concat(" (").concat(distrito).concat(")");

            linhas.add(new Object[]{
                grupo.getPosicao(),
                grupo.getNome(),
                localizacao,
                grupo.getnTocadores(),
                grupo.getnAcompanhantes(),
                grupo.getHoraPrevista(),
                grupo.isTocarString()
            });
        } 
        return linhas;
    } 
    
    private ArrayList<Object[]> getLinhasMostrarAtuacaoPalco(){
        ArrayList<Object[]> linhas = new ArrayList<>();

        for (Grupo grupo : GESTAO_GRUPO.getGrupos()){
            String localizacao = grupo.getLocalizacao();
            String concelho = grupo.getConcelho();
            String distrito = grupo.getDistrito();

            if (concelho != null)
                localizacao = localizacao.concat(" (").concat(concelho).concat(", ").concat(distrito).concat(")");
            else if (distrito != null)
                localizacao = localizacao.concat(" (").concat(distrito).concat(")");

            linhas.add(new Object[]{
                grupo.getPosicao(),
                grupo.getNome(),
                localizacao,
                grupo.getnTocadores(),
                grupo.getHoraPrevista()
            });
        } 
        return linhas;
    } 
    
    public void corLinhaTabela(String vista, JTable jTable1){ 
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                    boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                Color c = Color.BLACK;
                Grupo g = null;

                /*switch(vista){
                        case constantes.Constantes.VISTA_BARRENTA: 
                            g = GESTAO_GRUPO.getGrupoByHoraPrevista(table.getValueAt(row, 5).toString());
                            break;

                        case constantes.Constantes.VISTA_MOSTRAR_ATUACAO_PALCO: 
                            g = GESTAO_GRUPO.getGrupoByHoraPrevista(table.getValueAt(row, 4).toString()); 
                            break;
                    }

                if(g.isTocar()){
                    //c = Color.GREEN;
                    c = new Color(35, 142, 35);
                    switch(vista){
                        case constantes.Constantes.VISTA_BARRENTA: 
                            label.setFont(new Font("Tahoma", Font.BOLD, 14));
                            break;

                        case constantes.Constantes.VISTA_MOSTRAR_ATUACAO_PALCO: 
                            label.setFont(new Font("Tahoma", Font.BOLD, 20)); 
                            break;
                    }
                }*/

                label.setForeground(c);
                
                return label;
            }
        });
    }
}
