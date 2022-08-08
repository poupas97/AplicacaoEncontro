package vistas;

import gestores.GestaoGrupo;
import modelos.Grupo;

public class DetalheGrupo extends javax.swing.JDialog {
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    private Grupo grupo;
    
    public DetalheGrupo(java.awt.Frame parent, String nome) {
        super(parent, true);
        this.grupo = GESTAO_GRUPO.getGrupoByNome(nome);
        initComponents();
        getRootPane().setDefaultButton(btnVoltar);
        setLocationRelativeTo(null);
        setTitle("Detalhar Grupo");
        atualizarVista();
    }
    
    public void atualizarVista(){
        jLabelNomeGrupo2.setText(grupo.getNome());
        jLabelLocalizacao2.setText(grupo.getLocalizacao());
        jLabelDistrito2.setText(grupo.getDistrito());
        jLabelConcelho2.setText(grupo.getConcelho());
        jLabelEmail2.setText(grupo.getEmail());
        jLabelContacto2.setText(grupo.getContacto());
        jLabelNTocadores2.setText(String.valueOf(grupo.getnTocadores()));
        jLabelNAcompanhantes2.setText(String.valueOf(grupo.getnAcompanhantes()));
        jLabelHora2.setText(grupo.getHoraPrevista());
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
        jLabelConcelho = new javax.swing.JLabel();
        jLabelNAcompanhantes2 = new javax.swing.JLabel();
        jLabelContacto2 = new javax.swing.JLabel();
        jLabelNTocadores2 = new javax.swing.JLabel();
        jLabelLocalizacao2 = new javax.swing.JLabel();
        jLabelDistrito2 = new javax.swing.JLabel();
        jLabelConcelho2 = new javax.swing.JLabel();
        jLabelEmail2 = new javax.swing.JLabel();
        jLabelNomeGrupo2 = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelHora2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelNomeGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeGrupo.setText("Nome do Grupo");

        jLabelNTocadores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores.setText("Numeo de Tocadores");

        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

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

        jLabelConcelho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelConcelho.setText("Concelho");

        jLabelNAcompanhantes2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAcompanhantes2.setText("NAcompanhantes");

        jLabelContacto2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelContacto2.setText("Contacto");

        jLabelNTocadores2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores2.setText("NTocadores");

        jLabelLocalizacao2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalizacao2.setText("Localizacao");

        jLabelDistrito2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDistrito2.setText("Distrito");

        jLabelConcelho2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelEmail2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelNomeGrupo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeGrupo2.setText("Nome do Grupo");

        jLabelHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHora.setText("Hora");

        jLabelHora2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                            .addGap(18, 18, 18)
                            .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelHora2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(jLabelNAcompanhantes2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelHora)
                                .addComponent(jLabelHora2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelConcelho)
                            .addComponent(jLabelConcelho2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
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
    private javax.swing.JLabel jLabelConcelho;
    private javax.swing.JLabel jLabelConcelho2;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelContacto2;
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
    private javax.swing.JLabel jLabelHora2;
    // End of variables declaration//GEN-END:variables
}
