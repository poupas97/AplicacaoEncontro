package vistas;

import dialogos.DialogoGrupo;
import dialogos.DialogoParse;
import gestores.GestaoGrupo;
import gestores.GestaoLocal;
import modelos.Grupo;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ConfigurarGrupo extends javax.swing.JDialog {
    
    private final DialogoGrupo DIALOGO_GRUPO = DialogoGrupo.getINSTACIA();
    private final DialogoParse DIALOGO_PARSE = DialogoParse.getINSTACIA();
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    private final GestaoLocal GESTAO_LOCAL = GestaoLocal.getINSTACIA();

    private Grupo grupo;

    public ConfigurarGrupo(java.awt.Frame parent) {
        super(parent, true);
        this.grupo = null;
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnAceitar);
        setTitle("Criar Grupo");

        DefaultComboBoxModel modelo = new DefaultComboBoxModel(GESTAO_LOCAL.getDistritos().toArray());
        jComboBoxDistritos.setModel(modelo);
        jComboBoxConcelhos.setEnabled(false);

        Calendar ultimaDataDisponivel = GESTAO_GRUPO.getUltimaDataDisponivel();

        jTextFieldHora.setText(ultimaDataDisponivel.get(Calendar.HOUR_OF_DAY) + ":" + ultimaDataDisponivel.get(Calendar.MINUTE));
    }

    public ConfigurarGrupo(java.awt.Frame parent, String nome) {
        super(parent, true);
        this.grupo = GESTAO_GRUPO.getGrupoByNome(nome);
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnAceitar);
        setTitle("Editar Grupo");

        jTextFieldNome.setText(grupo.getNome());
        jTextFieldLocalizacao.setText(grupo.getLocalizacao());

        DefaultComboBoxModel modelo = new DefaultComboBoxModel(GESTAO_LOCAL.getDistritos().toArray());
        jComboBoxDistritos.setModel(modelo);
        jComboBoxDistritos.setSelectedItem(grupo.getDistrito());

        modelo = new DefaultComboBoxModel(GESTAO_LOCAL.getConcelhos(grupo.getDistrito()).toArray());
        jComboBoxConcelhos.setModel(modelo);

        String concelho = grupo.getConcelho();

        if(concelho != null) jComboBoxConcelhos.setSelectedItem(concelho);
        else jComboBoxConcelhos.setSelectedIndex(0);

        jTextFieldEmail.setText(grupo.getEmail());
        jTextFieldContacto.setText(grupo.getContacto());
        jFormattedTextFieldNTocadores.setText(String.valueOf(grupo.getnTocadores()));
        jFormattedTextFieldNAcompanhantes.setText(String.valueOf(grupo.getnAcompanhantes()));

        jTextFieldHora.setText(grupo.getDataHoraPrevista().get(Calendar.HOUR_OF_DAY) + ":" + grupo.getDataHoraPrevista().get(Calendar.MINUTE));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeGrupo = new javax.swing.JLabel();
        jLabelNTocadores = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        btnAceitar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jFormattedTextFieldNTocadores = new javax.swing.JFormattedTextField();
        jLabelNAcompanhantes = new javax.swing.JLabel();
        jFormattedTextFieldNAcompanhantes = new javax.swing.JFormattedTextField();
        jLabelLocalizacao = new javax.swing.JLabel();
        jTextFieldLocalizacao = new javax.swing.JTextField();
        jLabelNTocadores1 = new javax.swing.JLabel();
        jComboBoxDistritos = new javax.swing.JComboBox<String>();
        jLabelEmail = new javax.swing.JLabel();
        jLabelContacto = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldContacto = new javax.swing.JTextField();
        jTextFieldHora = new javax.swing.JTextField();
        jLabelNTocadores2 = new javax.swing.JLabel();
        jComboBoxConcelhos = new javax.swing.JComboBox<String>();
        jLabelHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelNomeGrupo.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelNomeGrupo.setText("Nome do Grupo *");

        jLabelNTocadores.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelNTocadores.setText("N Tocadores *");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        btnAceitar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnAceitar.setText("Aceitar");
        btnAceitar.addActionListener(this::btnAceitarActionPerformed);

        btnCancelar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        jFormattedTextFieldNTocadores.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldNTocadores.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jLabelNAcompanhantes.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelNAcompanhantes.setText("N Acompanhantes");

        jFormattedTextFieldNAcompanhantes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldNAcompanhantes.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jLabelLocalizacao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelLocalizacao.setText("Localizacao *");

        jTextFieldLocalizacao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jLabelNTocadores1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelNTocadores1.setText("Distrito *");

        jComboBoxDistritos.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jComboBoxDistritos.addItemListener(this::jComboBoxDistritosItemStateChanged);

        jLabelEmail.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelEmail.setText("Email");

        jLabelContacto.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelContacto.setText("Contacto * ");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jTextFieldContacto.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jTextFieldHora.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jLabelNTocadores2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelNTocadores2.setText("Concelho");

        jComboBoxConcelhos.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N

        jLabelHora.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelHora.setText("Hora");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLocalizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNomeGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldLocalizacao, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNome)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNTocadores1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNTocadores2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelContacto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNTocadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNAcompanhantes, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxDistritos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxConcelhos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldEmail)
                                            .addComponent(jTextFieldContacto)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnAceitar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jFormattedTextFieldNTocadores)
                                            .addComponent(jFormattedTextFieldNAcompanhantes)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(129, 129, 129)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeGrupo)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLocalizacao)
                    .addComponent(jTextFieldLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNTocadores1)
                    .addComponent(jComboBoxDistritos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNTocadores2)
                    .addComponent(jComboBoxConcelhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContacto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNTocadores)
                    .addComponent(jFormattedTextFieldNTocadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNAcompanhantes)
                    .addComponent(jFormattedTextFieldNAcompanhantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHora)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceitar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceitarActionPerformed
        String nome = jTextFieldNome.getText().trim();
        String localizacao = jTextFieldLocalizacao.getText().trim();
        String email = jTextFieldEmail.getText().trim();
        String contacto = jTextFieldContacto.getText().trim();
        String nTocadores = jFormattedTextFieldNTocadores.getText().trim();
        String nAcompanhantes = jFormattedTextFieldNAcompanhantes.getText().trim();
        String distrito = (String) jComboBoxDistritos.getSelectedItem();
        String concelho = (String) jComboBoxConcelhos.getSelectedItem();

        if(nome.isEmpty() || localizacao.isEmpty() || nTocadores.isEmpty()){
            DIALOGO_GRUPO.faltamParametros();

            return;
        }

        int nToc = 0, nAcom = 0;

        try{
            nToc = Integer.parseInt(nTocadores);
            nAcom = nAcompanhantes.isEmpty() ? 0 : Integer.parseInt(nAcompanhantes);
        }catch(NumberFormatException exception){
            DIALOGO_PARSE.erroParseNumero();
            return;
        }

        if(grupo == null){
            grupo = GESTAO_GRUPO.adicionarGrupo(nome, localizacao, distrito, concelho, nToc, nAcom, contacto, email, jTextFieldHora.getText());
        }else{
            grupo = GESTAO_GRUPO.editarGrupo(nome, localizacao, distrito, concelho,  nToc, nAcom, contacto, email, jTextFieldHora.getText());
        }

        if(grupo == null){
            DIALOGO_GRUPO.erroConfiguracaoGrupo();
        }else{
            //dialogoGrupo.sucessoConfiguracaoGrupo();
            setVisible(false);
        }
    }//GEN-LAST:event_btnAceitarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jComboBoxDistritosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDistritosItemStateChanged
        jComboBoxConcelhos.setEnabled(true);
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(GESTAO_LOCAL.getConcelhos((String) jComboBoxDistritos.getSelectedItem()).toArray());
        jComboBoxConcelhos.setModel(modelo);
    }//GEN-LAST:event_jComboBoxDistritosItemStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceitar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jComboBoxConcelhos;
    private javax.swing.JComboBox<String> jComboBoxDistritos;
    private javax.swing.JFormattedTextField jFormattedTextFieldNAcompanhantes;
    private javax.swing.JFormattedTextField jFormattedTextFieldNTocadores;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelLocalizacao;
    private javax.swing.JLabel jLabelNAcompanhantes;
    private javax.swing.JLabel jLabelNTocadores;
    private javax.swing.JLabel jLabelNTocadores1;
    private javax.swing.JLabel jLabelNTocadores2;
    private javax.swing.JLabel jLabelNomeGrupo;
    private javax.swing.JTextField jTextFieldContacto;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldLocalizacao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
