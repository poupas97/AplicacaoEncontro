package vistas;

import util.Tabela;

public class MostrarAtuacaoPalco extends javax.swing.JFrame {

    private final Tabela GESTAO_TABELA = Tabela.getINSTACIA();
    
    private Barrenta barrenta;

    public MostrarAtuacaoPalco(java.awt.Frame parent) {
        initComponents();
        barrenta = (Barrenta) parent;
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Mostrar Atuacao");
        atulizarTabelaGrupos();
    }
    
    public void atulizarTabelaGrupos(){
        GESTAO_TABELA.getTableModel(constantes.Constantes.VISTA_MOSTRAR_ATUACAO_PALCO, jTable1);
        GESTAO_TABELA.corLinhaTabela(constantes.Constantes.VISTA_MOSTRAR_ATUACAO_PALCO, jTable1);
    }
    
    public void atulizarNotas(String notas){
        jTextArea.setText(notas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextArea.setEditable(false);
        jTextArea.setColumns(14);
        jTextArea.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(255, 0, 0));
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jScrollPane4.setViewportView(jTextArea);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nome", "Localizacao", "Tocadores", "Hora Prevista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        barrenta.setMostrarAtuacao(null);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
