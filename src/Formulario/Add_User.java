/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

import java.awt.Color;
import java.time.Clock;

/**
 *
 * @author Fabian Andres
 */
public class Add_User extends javax.swing.JFrame {

    public String nombre = "";
    public String cargo = "";
    public String telefono = "";
    public String correo = "";
    CapturahuellaDigital captu = new CapturahuellaDigital();

    public Add_User() {
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaGuardar = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPMinimizar = new javax.swing.JPanel();
        jlbMinimizar = new javax.swing.JLabel();
        jPCerrar = new javax.swing.JPanel();
        jlbCerrar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTxCorreo = new javax.swing.JTextField();
        jTxTelefono = new javax.swing.JTextField();
        jTxCargo = new javax.swing.JTextField();
        jTxNombre = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLImagenHuellaGuardar = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(1, 55, 99));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextAreaGuardar.setColumns(20);
        jTextAreaGuardar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jTextAreaGuardar.setRows(5);
        jScrollPane2.setViewportView(jTextAreaGuardar);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 760, 110));

        jButton1.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("scaner");
        jButton1.setActionCommand("iniciar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 360, 50));

        jPanel1.setBackground(new java.awt.Color(46, 134, 193));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPMinimizar.setBackground(new java.awt.Color(46, 134, 193));
        jPMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPMinimizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPMinimizarMouseMoved(evt);
            }
        });
        jPMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPMinimizarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPMinimizarMouseExited(evt);
            }
        });
        jPMinimizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbMinimizar.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jlbMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        jlbMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbMinimizar.setText("-");
        jlbMinimizar.setToolTipText("");
        jlbMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbMinimizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlbMinimizarMouseMoved(evt);
            }
        });
        jlbMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbMinimizarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbMinimizarMouseExited(evt);
            }
        });
        jPMinimizar.add(jlbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, 30, 30));

        jPanel1.add(jPMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 70, 60));

        jPCerrar.setBackground(new java.awt.Color(46, 134, 193));
        jPCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPCerrarMouseMoved(evt);
            }
        });
        jPCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPCerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPCerrarMouseExited(evt);
            }
        });
        jPCerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbCerrar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jlbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jlbCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCerrar.setText("X");
        jlbCerrar.setToolTipText("");
        jlbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseMoved(evt);
            }
        });
        jlbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseExited(evt);
            }
        });
        jPCerrar.add(jlbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, 30, 30));

        jPanel1.add(jPCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 70, 60));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("footprint");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 70));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 228, 228)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxCorreo.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jTxCorreo.setForeground(new java.awt.Color(0, 51, 255));
        jTxCorreo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 280, 30));

        jTxTelefono.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jTxTelefono.setForeground(new java.awt.Color(0, 51, 255));
        jTxTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 280, 30));

        jTxCargo.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jTxCargo.setForeground(new java.awt.Color(0, 51, 255));
        jTxCargo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 280, 30));

        jTxNombre.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jTxNombre.setForeground(new java.awt.Color(0, 51, 255));
        jTxNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 280, 30));

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Nombre  y apellido :");
        jPanel12.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jLabel27.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Cargo : ");
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Telefono :");
        jPanel12.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        jLabel22.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Correo :");
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 30));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 360, 300));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(jLImagenHuellaGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 300));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 360, 300));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel15MouseMoved(evt);
            }
        });
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-el-archivo.png"))); // NOI18N
        jPanel15.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 40, 40));

        jLabel13.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Save");
        jPanel15.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 15, 90, 30));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 360, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 860, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbMinimizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMinimizarMouseMoved
        jPMinimizar.setBackground(new Color(32, 129, 169));
    }//GEN-LAST:event_jlbMinimizarMouseMoved

    private void jlbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jlbMinimizarMouseClicked

    private void jlbMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMinimizarMouseExited
        jPMinimizar.setBackground(new Color(1, 55, 99));
    }//GEN-LAST:event_jlbMinimizarMouseExited

    private void jPMinimizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPMinimizarMouseMoved
        jPMinimizar.setBackground(new Color(32, 129, 169));
    }//GEN-LAST:event_jPMinimizarMouseMoved

    private void jPMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jPMinimizarMouseClicked

    private void jPMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPMinimizarMouseExited
        jPMinimizar.setBackground(new Color(46, 134, 193));
    }//GEN-LAST:event_jPMinimizarMouseExited

    private void jlbCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseMoved
        jPCerrar.setBackground(Color.red);
    }//GEN-LAST:event_jlbCerrarMouseMoved

    private void jlbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseClicked
         System.exit(0);
    }//GEN-LAST:event_jlbCerrarMouseClicked

    private void jlbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseExited
        jPCerrar.setBackground(new Color(46, 134, 193));
    }//GEN-LAST:event_jlbCerrarMouseExited

    private void jPCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseMoved
        jPCerrar.setBackground(Color.red);
    }//GEN-LAST:event_jPCerrarMouseMoved

    private void jPCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseClicked
      System.exit(0);
    }//GEN-LAST:event_jPCerrarMouseClicked

    private void jPCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseExited
        jPCerrar.setBackground(new Color(46, 134, 193));
    }//GEN-LAST:event_jPCerrarMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            captu.IniciarG(jTextAreaGuardar, jLImagenHuellaGuardar);

            captu.start(jTextAreaGuardar);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        jPanel15.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked

        captu.guardarHuellas(nombre, cargo, telefono, correo, jTxNombre, jTxCargo, jTxTelefono, jTxCorreo, jTextAreaGuardar);
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseMoved
        jPanel15.setBackground(new Color(23, 156, 211));
    }//GEN-LAST:event_jPanel15MouseMoved

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
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLImagenHuellaGuardar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPCerrar;
    private javax.swing.JPanel jPMinimizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaGuardar;
    private javax.swing.JTextField jTxCargo;
    private javax.swing.JTextField jTxCorreo;
    private javax.swing.JTextField jTxNombre;
    private javax.swing.JTextField jTxTelefono;
    private javax.swing.JLabel jlbCerrar;
    private javax.swing.JLabel jlbMinimizar;
    // End of variables declaration//GEN-END:variables
}
