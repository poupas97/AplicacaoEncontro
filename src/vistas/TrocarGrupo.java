package vistas;

import dtos.GrupoDTO;
import javax.swing.DefaultComboBoxModel;
import gestores.GestaoGrupo;

public class TrocarGrupo extends javax.swing.JDialog {

    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    
    private Object[] model;
    
    public TrocarGrupo(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(jButtonAceitar);
        setTitle("Trocar Grupo");
        
        model = GESTAO_GRUPO.getGruposDTOsNaoAtuaram().toArray();
        
        DefaultComboBoxModel modeloOrigem =  new DefaultComboBoxModel(model);
        jComboBoxOrigem.setModel(modeloOrigem);
        DefaultComboBoxModel modeloDestino =  new DefaultComboBoxModel(model);
        jComboBoxDestino.setModel(modeloDestino);
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeGrupo = new javax.swing.JLabel();
        jButtonAceitar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelLocalizacao = new javax.swing.JLabel();
        jComboBoxOrigem = new javax.swing.JComboBox<>();
        jComboBoxDestino = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trocar Grupos");
        setResizable(false);

        jLabelNomeGrupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNomeGrupo.setText("Nome do Grupo Origem");

        jButtonAceitar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAceitar.setText("Aceitar");
        jButtonAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceitarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelLocalizacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLocalizacao.setText("Nome do grupo Destino");

        jComboBoxOrigem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(jLabelNomeGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLocalizacao, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(jButtonAceitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeGrupo)
                    .addComponent(jLabelLocalizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceitar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceitarActionPerformed
        GrupoDTO grupoDTOOrigem = (GrupoDTO) jComboBoxOrigem.getSelectedItem();
        GrupoDTO grupoDTODestino = (GrupoDTO) jComboBoxDestino.getSelectedItem();

        GESTAO_GRUPO.trocarGrupos(grupoDTOOrigem, grupoDTODestino);
        //dialogoGrupo.sucessoTrocarGrupo();
        setVisible(false);
    }//GEN-LAST:event_jButtonAceitarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceitar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JComboBox<String> jComboBoxOrigem;
    private javax.swing.JLabel jLabelLocalizacao;
    private javax.swing.JLabel jLabelNomeGrupo;
    // End of variables declaration//GEN-END:variables
}
