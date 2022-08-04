package vistas;

import dtos.GrupoDTO;
import gestores.GestaoGrupo;
import gestores.GestaoLocal;

public class DetalheGrupo extends javax.swing.JDialog {
    
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    
    private GrupoDTO grupoDTO;     
    
    public DetalheGrupo(java.awt.Frame parent, String nome) {
        super(parent, true);
        this.grupoDTO = GESTAO_GRUPO.getGrupoDTOByName(nome);
        initComponents();
        getRootPane().setDefaultButton(btnVoltar);
        setLocationRelativeTo(null);
        setTitle("Detalhar Grupo");
        atualizarVista();
    }
    
    public void atualizarVista(){
        jLabelNomeGrupo2.setText(grupoDTO.getNome());
        jLabelLocalizacao2.setText(grupoDTO.getLocalizacao());
        jLabelDistrito2.setText(grupoDTO.getDistrito());
        jLabelConcelho2.setText(grupoDTO.getConcelho());
        jLabelEmail2.setText(grupoDTO.getEmail());
        jLabelContacto2.setText(grupoDTO.getContacto());
        jLabelNTocadores2.setText(String.valueOf(grupoDTO.getnTocadores()));
        jLabelNAcompanhantes2.setText(String.valueOf(grupoDTO.getnAcompanhantes()));
        jLabelHora.setEnabled(false);
        jTextFieldDia.setText(""); 
        jTextFieldDia.setEnabled(false); 
        jLabelDia.setEnabled(false);
        jTextFieldHora.setText(""); 
        jTextFieldHora.setEnabled(false); 
        
        if(grupoDTO.isEspecial()){
            jCheckBoxEspecial.setSelected(true);
            jTextFieldDia.setText(grupoDTO.getDataPrevista()); 
            jLabelHora.setEnabled(true);
            jTextFieldHora.setText(grupoDTO.getHoraPrevista()); 
            jLabelDia.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeGrupo = new javax.swing.JLabel();
        jLabelNTocadores = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabelNAcompanhantes = new javax.swing.JLabel();
        jLabelLocalizacao = new javax.swing.JLabel();
        jLabelDistrito = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelContacto = new javax.swing.JLabel();
        jCheckBoxEspecial = new javax.swing.JCheckBox();
        jLabelConcelho = new javax.swing.JLabel();
        jLabelNAcompanhantes2 = new javax.swing.JLabel();
        jLabelContacto2 = new javax.swing.JLabel();
        jLabelNTocadores2 = new javax.swing.JLabel();
        jLabelLocalizacao2 = new javax.swing.JLabel();
        jLabelDistrito2 = new javax.swing.JLabel();
        jLabelConcelho2 = new javax.swing.JLabel();
        jLabelEmail2 = new javax.swing.JLabel();
        jLabelNomeGrupo2 = new javax.swing.JLabel();
        jLabelDia = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();
        jLabelHora = new javax.swing.JLabel();
        jTextFieldHora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelNomeGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeGrupo.setText("Nome do Grupo");

        jLabelNTocadores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores.setText("Numeo de Tocadores");

        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabelNAcompanhantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAcompanhantes.setText("Numero de Acompanhantes");

        jLabelLocalizacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalizacao.setText("Localizacao");

        jLabelDistrito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDistrito.setText("Distrito");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail.setText("Email");

        jLabelContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelContacto.setText("Contacto");

        jCheckBoxEspecial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxEspecial.setText("Grupo Especial");
        jCheckBoxEspecial.setEnabled(false);

        jLabelConcelho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelConcelho.setText("Concelho");

        jLabelNAcompanhantes2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAcompanhantes2.setText("Nome do Grupo *");

        jLabelContacto2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelContacto2.setText("Nome do Grupo *");

        jLabelNTocadores2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores2.setText("Nome do Grupo *");

        jLabelLocalizacao2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalizacao2.setText("Nome do Grupo *");

        jLabelDistrito2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDistrito2.setText("Nome do Grupo *");

        jLabelConcelho2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelConcelho2.setText("Nome do Grupo *");

        jLabelEmail2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail2.setText("Nome do Grupo *");

        jLabelNomeGrupo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeGrupo2.setText("Nome do Grupo *");

        jLabelDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDia.setText("Dia");

        jTextFieldDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHora.setText("Hora");

        jTextFieldHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelNomeGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jLabelLocalizacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelContacto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDistrito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLocalizacao2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEmail2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelContacto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDistrito2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNomeGrupo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelConcelho, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelConcelho2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNAcompanhantes, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jLabelNTocadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNAcompanhantes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNTocadores2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBoxEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeGrupo)
                    .addComponent(jLabelNomeGrupo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLocalizacao)
                    .addComponent(jLabelLocalizacao2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDistrito)
                    .addComponent(jLabelDistrito2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelEmail2))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelContacto)
                            .addComponent(jLabelContacto2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNTocadores)
                            .addComponent(jLabelNTocadores2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNAcompanhantes)
                            .addComponent(jLabelNAcompanhantes2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelConcelho)
                            .addComponent(jLabelConcelho2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBoxEspecial)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelDia)
                        .addComponent(jLabelHora)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JCheckBox jCheckBoxEspecial;
    private javax.swing.JLabel jLabelConcelho;
    private javax.swing.JLabel jLabelConcelho2;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelContacto2;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelDistrito;
    private javax.swing.JLabel jLabelDistrito2;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEmail2;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelLocalizacao;
    private javax.swing.JLabel jLabelLocalizacao2;
    private javax.swing.JLabel jLabelNAcompanhantes;
    private javax.swing.JLabel jLabelNAcompanhantes2;
    private javax.swing.JLabel jLabelNTocadores;
    private javax.swing.JLabel jLabelNTocadores2;
    private javax.swing.JLabel jLabelNomeGrupo;
    private javax.swing.JLabel jLabelNomeGrupo2;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldHora;
    // End of variables declaration//GEN-END:variables
}
