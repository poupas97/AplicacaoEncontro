package vistas;


public class LancarNotas extends javax.swing.JFrame {
  
    private MostrarAtuacaoPalco mostrarAtuacaoPalco;
    private Barrenta barrenta;
    
    public LancarNotas(java.awt.Frame parent, MostrarAtuacaoPalco mostrarAtuacaoPalco) {
        initComponents();
        barrenta = (Barrenta) parent;
        setTitle("Escrever Notas");
        setLocationRelativeTo(null);
        
        this.mostrarAtuacaoPalco = mostrarAtuacaoPalco;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados do Evento");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyPressed
        mostrarAtuacaoPalco.atulizarNotas(jTextArea.getText());
    }//GEN-LAST:event_jTextAreaKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        barrenta.setLancarNotas(null);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
