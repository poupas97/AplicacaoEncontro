package vistas;

import dialogos.DialogoEvento;
import dialogos.DialogoParse;
import gestores.GestaoEvento;
import gestores.GestaoGrupo;
import util.Ficheiro;


public class ConfigurarEvento extends javax.swing.JDialog {

    private final DialogoEvento DIALOGO_EVENTO = DialogoEvento.getINSTACIA();
    private final DialogoParse DIALOGO_PARSE = DialogoParse.getINSTACIA();
    private final GestaoEvento GESTAO_EVENTO = GestaoEvento.getINSTACIA();
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    private final Ficheiro FICHEIRO_INS = Ficheiro.getINSTACIA();
    
    private String acesso;
    
    public ConfigurarEvento(java.awt.Frame parent, String acesso) {
        super(parent, true);
       /* eventoDTO = GESTAO_EVENTO.getEvento();
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnGuardar);
        
        jTextFieldData.setText(eventoDTO.getDate().getStringData());
        jFormattedTextFieldMinutos.setText(eventoDTO.getMinutosGrupo());
        jTextFieldMorada.setText(eventoDTO.getMorada());
        jTextFieldNome.setText(eventoDTO.getNome());
        
        this.acesso = acesso;
        
        FICHEIRO_INS.escreverRegistoAcoesFicheiroTXT("CONFIGURACOES EVENTO");
        */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jTextFieldMorada = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JToggleButton();
        jFormattedTextFieldMinutos = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados do Evento");
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Morada *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Data e Hora de inicio *");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Minutos por Grupo *");

        jTextFieldData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldMorada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jFormattedTextFieldMinutos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldMinutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldMorada)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jFormattedTextFieldMinutos)
                    .addComponent(jTextFieldData))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       /* String nome = jTextFieldNome.getText().trim();
        String morada = jTextFieldMorada.getText().trim();
        String minutos = jFormattedTextFieldMinutos.getText().trim();
        String dataString = jTextFieldData.getText();

        if(!nome.isEmpty() && !morada.isEmpty() && !minutos.isEmpty() && Integer.parseInt(minutos) > 0 && 
                !dataString.isEmpty()){
            try{
                eventoDTO.setData(new Data(dataString));
                eventoDTO.setMinutosGrupo(minutos);
                eventoDTO.setMorada(morada);
                eventoDTO.setNome(nome);
                
                GESTAO_EVENTO.setEvento(eventoDTO);
                setVisible(false);
                
                GESTAO_GRUPO.alterarHoraPrevista(eventoDTO.getDate().dataToString(), false);
            }catch(NumberFormatException exception){
                DIALOGO_PARSE.erroParseNumero();
            }
        }else{
            DIALOGO_EVENTO.faltamParametros();
        }*/
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JFormattedTextField jFormattedTextFieldMinutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldMorada;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
