package vistas;

import dtos.GrupoDTO;
import dialogos.DialogoGrupo;
import dialogos.DialogoParse;
import gestores.GestaoGrupo;
import gestores.GestaoLocal;
import java.text.ParseException;
import javax.swing.DefaultComboBoxModel;
import util.Data;

public class ConfigurarGrupo extends javax.swing.JDialog {
    
    private final DialogoGrupo DIALOGO_GRUPO = DialogoGrupo.getINSTACIA();
    private final DialogoParse DIALOGO_PARSE = DialogoParse.getINSTACIA();
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    private final GestaoLocal GESTAO_LOCAL = GestaoLocal.getINSTACIA();
    
    private GrupoDTO grupoDTO;

    public ConfigurarGrupo(java.awt.Frame parent) {
        super(parent, true);
        this.grupoDTO = null;
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnAceitar);
        setTitle("Criar Grupo");
        
        DefaultComboBoxModel modelo =  new DefaultComboBoxModel(GESTAO_LOCAL.getDistritos().toArray());
        jComboBoxDistritos.setModel(modelo);
        
        jTextFieldHora.setEnabled(false);
        jTextFieldDia.setEnabled(false);
        jLabelDia.setEnabled(false);
        jLabelHora.setEnabled(false);
        
        jComboBoxConcelhos.setEnabled(false);
    }     
    
    public ConfigurarGrupo(java.awt.Frame parent, String nome) {
        super(parent, true);
        this.grupoDTO = GESTAO_GRUPO.getGrupoDTOByName(nome);
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnAceitar);
        setTitle("Editar Grupo");
        atualizarVista();
    }
    
    public void atualizarVista(){
        jTextFieldNome.setText(grupoDTO.getNome());
        jTextFieldLocalizacao.setText(grupoDTO.getLocalizacao());
        jFormattedTextFieldNTocadores.setText(String.valueOf(grupoDTO.getnTocadores()));
        jFormattedTextFieldNAcompanhantes.setText(String.valueOf(grupoDTO.getnAcompanhantes()));
        jTextFieldEmail.setText(grupoDTO.getEmail());
        jTextFieldContacto.setText(grupoDTO.getContacto());
        
        if(grupoDTO.isEspecial()){
            jCheckBoxEspecial.setSelected(true);
            jLabelDia.setEnabled(true);
            jLabelHora.setEnabled(true);
            jTextFieldHora.setEnabled(true);
            jTextFieldHora.setText(grupoDTO.getHoraPrevista()); 
            jTextFieldDia.setEnabled(true);
            jTextFieldDia.setText(grupoDTO.getDataPrevista());
        }else{
            jComboBoxDistritos.setSelectedItem(grupoDTO.getDistrito());
            jComboBoxConcelhos.setSelectedItem(grupoDTO.getConcelho());
            jCheckBoxEspecial.setSelected(false);
            jLabelDia.setEnabled(false);
            jLabelHora.setEnabled(false);
            jTextFieldHora.setText(""); 
            jTextFieldHora.setEnabled(false);
            jTextFieldDia.setText(""); 
            jTextFieldDia.setEnabled(false);
            DefaultComboBoxModel modelo =  new DefaultComboBoxModel(GESTAO_LOCAL.getDistritos().toArray());
            jComboBoxDistritos.setModel(modelo);
            jComboBoxDistritos.setSelectedItem(grupoDTO.getDistrito());
            modelo =  new DefaultComboBoxModel(GESTAO_LOCAL.getConcelhos(grupoDTO.getDistrito()).toArray());
            jComboBoxConcelhos.setModel(modelo);
            jComboBoxConcelhos.setSelectedItem(grupoDTO.getConcelho());
        }
    }
    
    @SuppressWarnings("unchecked")
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
        jCheckBoxEspecial = new javax.swing.JCheckBox();
        jTextFieldHora = new javax.swing.JTextField();
        jLabelNTocadores2 = new javax.swing.JLabel();
        jComboBoxConcelhos = new javax.swing.JComboBox<String>();
        jLabelHora = new javax.swing.JLabel();
        jLabelDia = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelNomeGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeGrupo.setText("Nome do Grupo *");

        jLabelNTocadores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores.setText("Numero de Tocadores *");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAceitar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceitar.setText("Aceitar");
        btnAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceitarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jFormattedTextFieldNTocadores.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldNTocadores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelNAcompanhantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAcompanhantes.setText("Numero de Acompanhantes");

        jFormattedTextFieldNAcompanhantes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldNAcompanhantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelLocalizacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalizacao.setText("Localizacao *");

        jTextFieldLocalizacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelNTocadores1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores1.setText("Distrito *");

        jComboBoxDistritos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxDistritos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDistritosItemStateChanged(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail.setText("Email");

        jLabelContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelContacto.setText("Contacto * ");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBoxEspecial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxEspecial.setText("Grupo Especial");
        jCheckBoxEspecial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxEspecialItemStateChanged(evt);
            }
        });

        jTextFieldHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelNTocadores2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores2.setText("Concelho");

        jComboBoxConcelhos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHora.setText("Hora");

        jLabelDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDia.setText("Dia");

        jTextFieldDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                                                .addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(129, 129, 129)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jCheckBoxEspecial)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelDia))
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
        boolean especial = jCheckBoxEspecial.isSelected();
        String nome = jTextFieldNome.getText().trim();
        String localizacao = jTextFieldLocalizacao.getText().trim();
        String email = jTextFieldEmail.getText().trim();
        String contacto = jTextFieldContacto.getText().trim();
        String nTocadores = jFormattedTextFieldNTocadores.getText().trim();
        String nAcompanhantes = jFormattedTextFieldNAcompanhantes.getText().trim();
        String distrito = (String) jComboBoxDistritos.getSelectedItem();
        String concelho = (String) jComboBoxConcelhos.getSelectedItem();
        
        if(especial && grupoDTO == null){
            Data data = new Data(jTextFieldDia.getText().concat(" ").concat(jTextFieldHora.getText()));
            GESTAO_GRUPO.adicionarGrupoEspecial(nome, data);
            setVisible(false);
            return;
        }else if(especial && grupoDTO != null){
            grupoDTO = new GrupoDTO(grupoDTO.getPosicao(), nome, localizacao, distrito, concelho, email, contacto, 
                    Integer.parseInt(nTocadores), Integer.parseInt(nAcompanhantes), jTextFieldHora.getText(), true, 
                    grupoDTO.isTocar());
            GESTAO_GRUPO.editarGrupo(grupoDTO);
            setVisible(false);
            return;
        }

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

        try{
            if(grupoDTO == null){
                grupoDTO = GESTAO_GRUPO.adicionarGrupo(new GrupoDTO(0, nome, localizacao, distrito, concelho, email, 
                        contacto, nToc, nAcom, "", false, false));
            }else{
                grupoDTO = GESTAO_GRUPO.editarGrupo(new GrupoDTO(grupoDTO.getPosicao(), nome, localizacao, distrito,
                        concelho, email, contacto, nToc, nAcom, grupoDTO.getFullDataPrevista(), especial, 
                        grupoDTO.isTocar()));
            }

            if(grupoDTO == null){
                DIALOGO_GRUPO.erroConfiguracaoGrupo();
            }else{
                //dialogoGrupo.sucessoConfiguracaoGrupo();
                setVisible(false);
            }
        }catch (ParseException ex) {
            DIALOGO_PARSE.erroParseGrupoDTO();
        }
    }//GEN-LAST:event_btnAceitarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jComboBoxDistritosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDistritosItemStateChanged
        jComboBoxConcelhos.setEnabled(true);
        DefaultComboBoxModel modelo =  new DefaultComboBoxModel(
                GESTAO_LOCAL.getConcelhos((String) jComboBoxDistritos.getSelectedItem()).toArray());
        jComboBoxConcelhos.setModel(modelo);
    }//GEN-LAST:event_jComboBoxDistritosItemStateChanged

    private void jCheckBoxEspecialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxEspecialItemStateChanged
        if(jCheckBoxEspecial.isSelected()){
            jLabelDia.setEnabled(true);
            jLabelHora.setEnabled(true);
            jTextFieldHora.setEnabled(true);
            jTextFieldDia.setEnabled(true);
            jTextFieldDia.setText(GESTAO_GRUPO.getUltimoGrupoNaoEspecial().getHoraPrevista().dataToString().split(" ")[0]);
            return;
        }
        jLabelDia.setEnabled(false);
        jLabelHora.setEnabled(false);
        jTextFieldHora.setEnabled(false);
        jTextFieldDia.setEnabled(false);
    }//GEN-LAST:event_jCheckBoxEspecialItemStateChanged


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceitar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox jCheckBoxEspecial;
    private javax.swing.JComboBox<String> jComboBoxConcelhos;
    private javax.swing.JComboBox<String> jComboBoxDistritos;
    private javax.swing.JFormattedTextField jFormattedTextFieldNAcompanhantes;
    private javax.swing.JFormattedTextField jFormattedTextFieldNTocadores;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelLocalizacao;
    private javax.swing.JLabel jLabelNAcompanhantes;
    private javax.swing.JLabel jLabelNTocadores;
    private javax.swing.JLabel jLabelNTocadores1;
    private javax.swing.JLabel jLabelNTocadores2;
    private javax.swing.JLabel jLabelNomeGrupo;
    private javax.swing.JTextField jTextFieldContacto;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldLocalizacao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
