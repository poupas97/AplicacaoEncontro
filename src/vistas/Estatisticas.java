package vistas;

import gestores.GestaoGrupo;


public class Estatisticas extends javax.swing.JDialog { 
    
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();

    public Estatisticas(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Estatisticas");
        getRootPane().setDefaultButton(jButtonVoltar);
        
        jLabelQtdGrupos.setText(GESTAO_GRUPO.getQtdGrupos() + "");
        jLabelQtdTocadoresIns.setText(GESTAO_GRUPO.getQtdTocadores()+ "");
        jLabelAcompanhantes.setText(GESTAO_GRUPO.getQtdAcompanhantes()+ "");
        //jLabelQtdTocadoresReais.setText(GESTAO_GRUPO.getQtdTocadoresReal()+ "");
        
        atualizarListaGrupos();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jLabelLocalizacao = new javax.swing.JLabel();
        jLabelQtdTocadoresIns = new javax.swing.JLabel();
        jLabelAcompanhantes = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jLabelPosicao = new javax.swing.JLabel();
        jLabelQtdGrupos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListGruposDistrito = new javax.swing.JList<String>();
        jLabelNAcompanhantes1 = new javax.swing.JLabel();
        jLabelNAcompanhantes2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListGruposConcelho = new javax.swing.JList<String>();
        jLabelPosicao1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conta");
        setResizable(false);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNome.setText("Tocadores Inscritos");

        jLabelLocalizacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLocalizacao.setText("Acompanhantes");

        jLabelQtdTocadoresIns.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelQtdTocadoresIns.setText("jLabel5");

        jLabelAcompanhantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAcompanhantes.setText("jLabel5");

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabelPosicao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPosicao.setText("Grupos");

        jLabelQtdGrupos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelQtdGrupos.setText("Nome");

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);

        jScrollPane1.setViewportView(jListGruposDistrito);

        jLabelNAcompanhantes1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNAcompanhantes1.setText("Grupos por Distrito");

        jLabelNAcompanhantes2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNAcompanhantes2.setText("Grupos por Concelho");

        jScrollPane2.setMaximumSize(null);
        jScrollPane2.setMinimumSize(null);

        jScrollPane2.setViewportView(jListGruposConcelho);

        jLabelPosicao1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPosicao1.setText("Grupos Especiais");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelNAcompanhantes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(331, 331, 331))
                    .addComponent(jLabelNAcompanhantes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelPosicao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jLabelPosicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLocalizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelQtdGrupos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelAcompanhantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQtdTocadoresIns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPosicao)
                    .addComponent(jLabelQtdGrupos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPosicao1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelQtdTocadoresIns)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAcompanhantes)
                    .addComponent(jLabelLocalizacao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(53, 53, 53)
                .addComponent(jLabelNAcompanhantes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNAcompanhantes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void atualizarListaGrupos() {
        atualizarListaGruposDistrito();
        atualizarListaGruposConcelho();
    }
    
    private void atualizarListaGruposDistrito() {
        jListGruposDistrito.setModel(GESTAO_GRUPO.getListaGruposDistrito());
    }
    
    private void atualizarListaGruposConcelho() {
        jListGruposConcelho.setModel(GESTAO_GRUPO.getListaGruposConcelho());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelAcompanhantes;
    private javax.swing.JLabel jLabelLocalizacao;
    private javax.swing.JLabel jLabelNAcompanhantes1;
    private javax.swing.JLabel jLabelNAcompanhantes2;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPosicao;
    private javax.swing.JLabel jLabelPosicao1;
    private javax.swing.JLabel jLabelQtdGrupos;
    private javax.swing.JLabel jLabelQtdTocadoresIns;
    private javax.swing.JList<String> jListGruposConcelho;
    private javax.swing.JList<String> jListGruposDistrito;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
