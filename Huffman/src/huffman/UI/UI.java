/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.UI;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author leoro
 */
public class UI extends javax.swing.JFrame {

    JFileChooser sel;

    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        sel = new JFileChooser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        rbCompactar = new javax.swing.JRadioButton();
        rbDescompactar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtArquivoOrigem = new javax.swing.JTextField();
        btSelecionarArquivoOrigem = new javax.swing.JButton();
        txtArquivoDestino = new javax.swing.JTextField();
        btSelecionarArquivoDestino = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        rbCompactar.setText("Compactar");
        rbCompactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCompactarActionPerformed(evt);
            }
        });

        rbDescompactar.setText("Descompactar");
        rbDescompactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescompactarActionPerformed(evt);
            }
        });

        jLabel1.setText("Arquivo Origem");

        btSelecionarArquivoOrigem.setText("Selecionar");
        btSelecionarArquivoOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarArquivoOrigemActionPerformed(evt);
            }
        });

        btSelecionarArquivoDestino.setText("Selecionar");
        btSelecionarArquivoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarArquivoDestinoActionPerformed(evt);
            }
        });

        jLabel2.setText("Arquivo Destino");

        jButton1.setText("Processar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDescompactar)
                            .addComponent(rbCompactar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtArquivoOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btSelecionarArquivoOrigem))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtArquivoDestino))
                                    .addGap(32, 32, 32)
                                    .addComponent(btSelecionarArquivoDestino))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(rbCompactar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbDescompactar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArquivoOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecionarArquivoOrigem))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArquivoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecionarArquivoDestino))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbCompactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCompactarActionPerformed
        rbDescompactar.setSelected(false);
    }//GEN-LAST:event_rbCompactarActionPerformed

    private void rbDescompactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescompactarActionPerformed
        rbCompactar.setSelected(false);
    }//GEN-LAST:event_rbDescompactarActionPerformed

    private void btSelecionarArquivoOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarArquivoOrigemActionPerformed
        int status = sel.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            txtArquivoOrigem.setText(sel.getSelectedFile().getPath());

        }
    }//GEN-LAST:event_btSelecionarArquivoOrigemActionPerformed

    private void btSelecionarArquivoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarArquivoDestinoActionPerformed
        int status = sel.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            txtArquivoDestino.setText(sel.getSelectedFile().getPath());

        }
    }//GEN-LAST:event_btSelecionarArquivoDestinoActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!rbCompactar.isSelected() && !rbDescompactar.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar compactar ou descompactar");
        } else {
            if (rbCompactar.isSelected()) {
                //do spiess metodo
            } else {
                //do spiess metodo
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSelecionarArquivoDestino;
    private javax.swing.JButton btSelecionarArquivoOrigem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rbCompactar;
    private javax.swing.JRadioButton rbDescompactar;
    private javax.swing.JTextField txtArquivoDestino;
    private javax.swing.JTextField txtArquivoOrigem;
    // End of variables declaration//GEN-END:variables
}