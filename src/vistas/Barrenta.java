package vistas;

import dialogos.DialogoGrupo;
import gestores.GestaoEvento;
import javax.swing.JOptionPane;
import gestores.GestaoGrupo;

import java.awt.*;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import modelos.Evento;
import util.Tabela;


public class Barrenta extends javax.swing.JFrame {
    
    private final GestaoGrupo GESTAO_GRUPO = GestaoGrupo.getINSTACIA();
    private final GestaoEvento GESTAO_EVENTO = GestaoEvento.getINSTACIA();
    private final Tabela GESTAO_TABELA = Tabela.getINSTACIA();
    private final DialogoGrupo DIALOGO_GRUPO = DialogoGrupo.getINSTACIA();

    private MostrarAtuacaoPalco mostrarAtuacao;
    private LancarNotas lancarNotas;
    
    private DefaultTableModel tableModel;
    
    public Barrenta() throws ParseException {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Barrenta");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 9, 24, 14, 0, 0);

        GESTAO_EVENTO.setEvento(new Evento("21 Encontro de Concertinas da Barrenta",  calendar, 8));
        
        atualizarVista();
    }
    
    public void atualizarVista() {
        if(!atualizarEvento()) return;

        atualizarTabelaGrupos();
        atualizarContagemGrupos();
        
        if(mostrarAtuacao == null) return;

        mostrarAtuacao.atulizarTabelaGrupos();
    }
    
    private void atualizarTabelaGrupos() {
        tableModel = GESTAO_TABELA.getTableModel(constantes.Constantes.VISTA_BARRENTA, jTable1);
        GESTAO_TABELA.corLinhaTabela(constantes.Constantes.VISTA_BARRENTA, jTable1);
    }
    
    private void atualizarContagemGrupos() {
        jLabelQtdGrupos.setText(String.valueOf(GESTAO_GRUPO.getQtdGrupos()));
        jLabelQtdTocadores.setText(String.valueOf(GESTAO_GRUPO.getQtdTocadores()));
        jLabelQtdAcompanhantes.setText(String.valueOf(GESTAO_GRUPO.getQtdAcompanhantes()));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {
        lblNome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblMinutos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelQtdGrupos = new javax.swing.JLabel();
        jLabelQtdTocadores = new javax.swing.JLabel();
        jLabelQtdAcompanhantes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEstatisticas = new javax.swing.JButton();
        btnAdicionarGrupo = new javax.swing.JButton();
        btnEditarGrupo = new javax.swing.JButton();
        btnEliminarGrupo = new javax.swing.JButton();
        btnDetalharGrupo = new javax.swing.JButton();
        btnIniciarAtuacao = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnConfirmarAtucao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicacao Encontro");

        lblNome.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        lblNome.setText("[Nome]");

        jLabel4.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel4.setText("Grupos:");

        btnSair.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(this::btnSairActionPerformed);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel1.setText("Tocadores:");

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel3.setText("Acompanhantes:");

        lblData.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        lblData.setText("[Data de Inicio]");

        lblMinutos.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        lblMinutos.setText("[Minutos por Grupo]");

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Nome");


        jLabel7.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        jLabel7.setText("Data/Hora inicio");

        jLabel8.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        jLabel8.setText("Minutos por Grupo");

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        jLabel6.setText("Inscritos");

        jLabelQtdGrupos.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelQtdGrupos.setText("[Qtd Grupos]");

        jLabelQtdTocadores.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelQtdTocadores.setText("[Qtd Tocadores]");

        jLabelQtdAcompanhantes.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabelQtdAcompanhantes.setText("[Qtd Acompanhantes]");

        btnEstatisticas.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnEstatisticas.setText("Estatisticas");
        btnEstatisticas.addActionListener(this::btnEstatisticasActionPerformed);

        btnAdicionarGrupo.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnAdicionarGrupo.setText("Adicionar Grupo");
        btnAdicionarGrupo.setMaximumSize(null);
        btnAdicionarGrupo.setMinimumSize(null);
        btnAdicionarGrupo.setPreferredSize(null);
        btnAdicionarGrupo.addActionListener(this::btnAdicionarGrupoActionPerformed);

        btnEditarGrupo.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnEditarGrupo.setText("Editar Grupo");
        btnEditarGrupo.setMaximumSize(null);
        btnEditarGrupo.setMinimumSize(null);
        btnEditarGrupo.setPreferredSize(null);
        btnEditarGrupo.addActionListener(this::btnEditarGrupoActionPerformed);

        btnEliminarGrupo.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnEliminarGrupo.setText("Eliminar Grupo");
        btnEliminarGrupo.setMaximumSize(null);
        btnEliminarGrupo.setMinimumSize(null);
        btnEliminarGrupo.setPreferredSize(null);
        btnEliminarGrupo.addActionListener(this::btnEliminarGrupoActionPerformed);

        btnDetalharGrupo.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnDetalharGrupo.setText("Detalhar Grupo");
        btnDetalharGrupo.setMaximumSize(null);
        btnDetalharGrupo.setMinimumSize(null);
        btnDetalharGrupo.setPreferredSize(null);
        btnDetalharGrupo.addActionListener(this::btnDetalharGrupoActionPerformed);


        btnIniciarAtuacao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnIniciarAtuacao.setText("Abrir Atuacoes");
        btnIniciarAtuacao.setMaximumSize(null);
        btnIniciarAtuacao.setMinimumSize(null);
        btnIniciarAtuacao.setOpaque(false);
        btnIniciarAtuacao.setPreferredSize(null);
        btnIniciarAtuacao.addActionListener(this::btnIniciarAtuacaoActionPerformed);

        btnImportar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnImportar.setText("Importar Grupos");
        btnImportar.setMaximumSize(null);
        btnImportar.setMinimumSize(null);
        btnImportar.setPreferredSize(null);
        btnImportar.addActionListener(this::btnImportarActionPerformed);

        btnExportar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnExportar.setText("Exportar Grupos");
        btnExportar.setMaximumSize(null);
        btnExportar.setMinimumSize(null);
        btnExportar.setPreferredSize(null);
        btnExportar.addActionListener(this::btnExportarActionPerformed);

        btnConfirmarAtucao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        btnConfirmarAtucao.setText("Confirmar Atuacao");
        btnConfirmarAtucao.addActionListener(this::btnConfirmarAtucaoActionPerformed);


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImportar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstatisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnEditarGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAdicionarGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                            .addComponent(btnConfirmarAtucao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDetalharGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIniciarAtuacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdicionarGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(btnDetalharGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(btnEliminarGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false))
                    .addGap(51, 51, 51)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConfirmarAtucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIniciarAtuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(51, 51, 51)
                    .addComponent(btnEstatisticas)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
        );

        jPanel2.setForeground(new java.awt.Color(0, 100, 0));

        jTable1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nome", "Localizacao", "Tocadores", "Acompanhantes", "Hora Prevista", "Atucao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(22);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelQtdGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelQtdTocadores, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelQtdAcompanhantes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMinutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    ))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(319, 319, 319))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(561, 561, 561)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                ))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           )
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblMinutos)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        ))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabelQtdGrupos)
                            .addComponent(jLabelQtdTocadores)
                            .addComponent(jLabelQtdAcompanhantes))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }

    private void btnAdicionarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarGrupoActionPerformed
        ConfigurarGrupo dadosConta =  new ConfigurarGrupo(this);
        dadosConta.setVisible(true);
        atualizarVista();
    }//GEN-LAST:event_btnAdicionarGrupoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem a certeza que quer sair?", "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            GESTAO_GRUPO.exportarGrupos();
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarGrupoActionPerformed
        int row = jTable1.getSelectedRow();

        if(row < 0){
            DIALOGO_GRUPO.selecionarGrupo();
            return;
        }

        ConfigurarGrupo dadosGrupo =  new ConfigurarGrupo(this, (String) tableModel.getValueAt(row, 1));
        dadosGrupo.setVisible(true);
        atualizarVista();
    }//GEN-LAST:event_btnEditarGrupoActionPerformed

    private void btnEliminarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGrupoActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0){
            DIALOGO_GRUPO.selecionarGrupo();
            return;
        }
        
        if(DIALOGO_GRUPO.apagarGrupo((String) tableModel.getValueAt(row, 1)) == JOptionPane.YES_OPTION){
            GESTAO_GRUPO.removerGrupo(row);
            atualizarVista();
        }
    }//GEN-LAST:event_btnEliminarGrupoActionPerformed


    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        if(!GESTAO_GRUPO.exportarGrupos()){
            DIALOGO_GRUPO.erroExportacaoGrupos();
        }else{
            DIALOGO_GRUPO.sucessoExportacaoGrupos();
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        if(GESTAO_GRUPO.importarGrupos()){
            DIALOGO_GRUPO.sucessoImportacaoGrupos();
        }else{
            DIALOGO_GRUPO.erroImportacaoGrupos();
        }
        
        atualizarVista();
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnIniciarAtuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarAtuacaoActionPerformed
        if(mostrarAtuacao == null){
            mostrarAtuacao = new MostrarAtuacaoPalco(this);
            mostrarAtuacao.setVisible(true);
        }
        if(lancarNotas == null){
            lancarNotas = new LancarNotas(this, mostrarAtuacao);
            lancarNotas.setVisible(true);
        }
    }//GEN-LAST:event_btnIniciarAtuacaoActionPerformed

    private void btnEstatisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatisticasActionPerformed
        Estatisticas estatisticas = new Estatisticas(this);
        estatisticas.setVisible(true);
    }//GEN-LAST:event_btnEstatisticasActionPerformed

    private void btnDetalharGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalharGrupoActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0){
            DIALOGO_GRUPO.selecionarGrupo();
            return;
        }
        DetalheGrupo detalheGrupo = new DetalheGrupo(this, (String) tableModel.getValueAt(row, 1));
        detalheGrupo.setVisible(true);
    }//GEN-LAST:event_btnDetalharGrupoActionPerformed

    private void btnConfirmarAtucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAtucaoActionPerformed
        int row = jTable1.getSelectedRow();

        if(row < 0){
            DIALOGO_GRUPO.selecionarGrupo();
            return;
        }
        
        GESTAO_GRUPO.setEstadoAtucao((String) tableModel.getValueAt(row, 1));
        atualizarVista();
    }//GEN-LAST:event_btnConfirmarAtucaoActionPerformed


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(jTable1.isEditing()){
            return;
        }
        
        int index = jTable1.getSelectedRow();
        if(GESTAO_GRUPO.getGrupo(index).isTocar()){
            btnConfirmarAtucao.setText("Desmarcar Atuacao");
        }else{
            btnConfirmarAtucao.setText("Confirmar Atuacao");
        }
    }//GEN-LAST:event_jTable1MouseClicked


    public void setMostrarAtuacao(MostrarAtuacaoPalco mostrarAtuacao) {
        this.mostrarAtuacao = mostrarAtuacao;
    }

    public void setLancarNotas(LancarNotas lancarNotas) {
        this.lancarNotas = lancarNotas;
    }
    
    private boolean atualizarEvento(){
        Evento evento = GESTAO_EVENTO.getEvento();

        if(evento.getNome() == null || evento.getData() == null || evento.getMinutosGrupo() == 0){
            ativarLayout(false);

            System.out.println("error");

            return false;
        }

        lblNome.setText(evento.getNome());
        lblData.setText(evento.getData().get(Calendar.HOUR_OF_DAY) + ":" + evento.getData().get(Calendar.MINUTE));
        lblMinutos.setText(evento.getMinutosGrupo() + "");
        
        ativarLayout(true);
        
        return true;
    }
    
    public void ativarLayout(boolean estado){
        btnAdicionarGrupo.setEnabled(estado);
        btnDetalharGrupo.setEnabled(estado);
        btnEditarGrupo.setEnabled(estado);
        btnEliminarGrupo.setEnabled(estado);
        btnExportar.setEnabled(estado);
        btnImportar.setEnabled(estado);
        btnConfirmarAtucao.setEnabled(estado);
        btnIniciarAtuacao.setEnabled(estado);
        //jScrollPane1.setEnabled(estado);
        btnEstatisticas.setEnabled(estado);
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barrenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Barrenta().setVisible(true);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarGrupo;
    private javax.swing.JButton btnConfirmarAtucao;
    private javax.swing.JButton btnDetalharGrupo;
    private javax.swing.JButton btnEditarGrupo;
    private javax.swing.JButton btnEliminarGrupo;
    private javax.swing.JButton btnEstatisticas;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnIniciarAtuacao;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelQtdAcompanhantes;
    private javax.swing.JLabel jLabelQtdGrupos;
    private javax.swing.JLabel jLabelQtdTocadores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblMinutos;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables

   
}
