/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinkfastwithjava;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/**
 *
 * @author Bayan
 */
public class ExitFrame extends javax.swing.JFrame {
    /**
     * Creates new form ExitFrame
     */
    public ExitFrame() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExitPanel = new javax.swing.JPanel();
        ExitCard = new javax.swing.JPanel();
        Yes = new javax.swing.JButton();
        No = new javax.swing.JButton();
        loseProgress = new javax.swing.JLabel();
        ExitText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Are You Sure ?");
        setResizable(false);
        setSize(new java.awt.Dimension(407, 368));

        ExitPanel.setLayout(new java.awt.CardLayout());

        Yes.setBackground(new java.awt.Color(236, 236, 236));
        Yes.setFont(new java.awt.Font("Timotheos", 0, 36)); // NOI18N
        Yes.setForeground(new java.awt.Color(153, 0, 0));
        Yes.setText("Yes");
        Yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesActionPerformed(evt);
            }
        });

        No.setBackground(new java.awt.Color(236, 236, 236));
        No.setFont(new java.awt.Font("Timotheos", 0, 36)); // NOI18N
        No.setForeground(new java.awt.Color(153, 0, 0));
        No.setText("No");
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });

        loseProgress.setFont(new java.awt.Font("Timotheos", 0, 20)); // NOI18N
        loseProgress.setForeground(new java.awt.Color(172, 122, 105));
        loseProgress.setText("Unsaved progress will be lost");

        ExitText.setFont(new java.awt.Font("Timotheos", 0, 48)); // NOI18N
        ExitText.setForeground(new java.awt.Color(102, 91, 84));
        ExitText.setText("Are you sure ?");

        javax.swing.GroupLayout ExitCardLayout = new javax.swing.GroupLayout(ExitCard);
        ExitCard.setLayout(ExitCardLayout);
        ExitCardLayout.setHorizontalGroup(
            ExitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitCardLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(ExitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExitText, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ExitCardLayout.createSequentialGroup()
                        .addComponent(Yes, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loseProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ExitCardLayout.setVerticalGroup(
            ExitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitCardLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(ExitText)
                .addGap(6, 6, 6)
                .addComponent(loseProgress)
                .addGap(32, 32, 32)
                .addGroup(ExitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Yes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        ExitPanel.add(ExitCard, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    /**
     * game close operation
     */
    public void close(){
           WindowEvent winClosingEvent =  new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
           Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
       }
    /**
     * 
     * @param this frame close 
     */
    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        dispose();
    }//GEN-LAST:event_NoActionPerformed

    /**
     * 
     * @param close whole game 
     */
    private void YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesActionPerformed
        close();
    }//GEN-LAST:event_YesActionPerformed

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
            java.util.logging.Logger.getLogger(ExitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExitFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExitCard;
    private javax.swing.JPanel ExitPanel;
    private javax.swing.JLabel ExitText;
    private javax.swing.JButton No;
    private javax.swing.JButton Yes;
    private javax.swing.JLabel loseProgress;
    // End of variables declaration//GEN-END:variables
}