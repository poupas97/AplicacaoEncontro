package vistas;

import dialogos.DialogoGrupo;
import dialogos.DialogoParse;
import gestores.GestaoGrupo;
import modelos.Grupo;

import java.util.Calendar;


public class ConfirmarAtuacao extends javax.swing.JDialog { 
    
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    private final DialogoParse DIALOGO_PARSE = DialogoParse.getINSTACIA();
    private final DialogoGrupo DIALOGO_GRUPO = DialogoGrupo.getINSTACIA();
    
    private Grupo grupo;
    
    public ConfirmarAtuacao(java.awt.Frame parent, Grupo grupo) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(jButtonConfirmar);
        setTitle("Confirmacao da Atuacao");
        
        this.grupo = grupo;
        
        jLabelPosicao2.setText(String.valueOf(grupo.getPosicao()));
        jLabelNome2.setText(grupo.getNome());
        jLabelLocalizacao2.setText(grupo.getLocalizacao());
        jLabelNTocadores2.setText(String.valueOf(grupo.getnTocadores()));
        jLabelNAcompanhantes2.setText(String.valueOf(grupo.getnAcompanhantes()));
        jLabelHoraPrevista2.setText(grupo.getHoraPrevista());
        jFormattedTextFieldNTocadoresReal.setText(String.valueOf(grupo.getnTocadores()));
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jLabelLocalizacao = new javax.swing.JLabel();
        jLabelNTocadores = new javax.swing.JLabel();
        jLabelNAcompanhantes = new javax.swing.JLabel();
        jLabelNome2 = new javax.swing.JLabel();
        jLabelLocalizacao2 = new javax.swing.JLabel();
        jLabelNTocadores2 = new javax.swing.JLabel();
        jLabelNAcompanhantes2 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jLabelPosicao = new javax.swing.JLabel();
        jLabelPosicao2 = new javax.swing.JLabel();
        jLabelHoraPrevista = new javax.swing.JLabel();
        jLabelHoraPrevista2 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jFormattedTextFieldNTocadoresReal = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conta");
        setResizable(false);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome.setText("Nome");

        jLabelLocalizacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalizacao.setText("Localizacao");

        jLabelNTocadores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores.setText("Numero de Tocadores");

        jLabelNAcompanhantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAcompanhantes.setText("Numero de Acompanhantes");

        jLabelNome2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome2.setText("jLabel5");

        jLabelLocalizacao2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalizacao2.setText("jLabel5");

        jLabelNTocadores2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNTocadores2.setText("jLabel5");

        jLabelNAcompanhantes2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAcompanhantes2.setText("jLabel5");

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabelPosicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPosicao.setText("Posicao");

        jLabelPosicao2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPosicao2.setText("Nome");

        jLabelHoraPrevista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraPrevista.setText("Hora Prevista");

        jLabelHoraPrevista2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraPrevista2.setText("jLabel5");

        jButtonConfirmar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jFormattedTextFieldNTocadoresReal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextFieldNTocadoresReal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNAcompanhantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(388, 388, 388))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPosicao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(63, 63, 63))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelNTocadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHoraPrevista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHoraPrevista2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPosicao2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelNome2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(jLabelLocalizacao2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNTocadores2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNAcompanhantes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldNTocadoresReal)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPosicao)
                    .addComponent(jLabelPosicao2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelNome2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLocalizacao2)
                    .addComponent(jLabelLocalizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNTocadores2)
                        .addComponent(jFormattedTextFieldNTocadoresReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNTocadores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNAcompanhantes)
                    .addComponent(jLabelNAcompanhantes2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoraPrevista)
                    .addComponent(jLabelHoraPrevista2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        try{
            /*grupoDTO.setTocar(true);
            int nTocReal = Integer.parseInt(jFormattedTextFieldNTocadoresReal.getText());
            grupoDTO.setnTocadoresReal(nTocReal);
            gestaoGrupo.setEstadoAtucao(grupoDTO);
            setVisible(false);
            dialogoGrupo.sucessoConfirmacaoGrupo();*/
        }catch(NumberFormatException exception){
            DIALOGO_PARSE.erroParseNumero();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JFormattedTextField jFormattedTextFieldNTocadoresReal;
    private javax.swing.JLabel jLabelHoraPrevista;
    private javax.swing.JLabel jLabelHoraPrevista2;
    private javax.swing.JLabel jLabelLocalizacao;
    private javax.swing.JLabel jLabelLocalizacao2;
    private javax.swing.JLabel jLabelNAcompanhantes;
    private javax.swing.JLabel jLabelNAcompanhantes2;
    private javax.swing.JLabel jLabelNTocadores;
    private javax.swing.JLabel jLabelNTocadores2;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNome2;
    private javax.swing.JLabel jLabelPosicao;
    private javax.swing.JLabel jLabelPosicao2;
    // End of variables declaration//GEN-END:variables
}
