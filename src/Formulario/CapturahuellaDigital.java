package Formulario;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import Funtions.ConexionBD;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Funtions.Metho;
import com.sun.source.tree.BreakTree;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Fabian Andres
 */
public class CapturahuellaDigital extends javax.swing.JFrame {

    Metho metho = new Metho();

    public String hora = metho.MostrarHora();

    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    public DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    private DPFPTemplate template;
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();
    public static String TEMPLATE_PROPERTY = "template";

    ConexionBD con = new ConexionBD();

    protected void Iniciar(JTextArea tex, JLabel img, JLabel label, JLabel hrc) {
        Lector.addDataListener(new DPFPDataAdapter() {

            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        try {
                            EnviarTexto("La Huella Digital ha sido Capturada", tex);
                            ProcesarCapturaId(e.getSample(), tex, img);
                            identificarHuella(label);
                            capHora(hrc);

                        } catch (IOException ex) {
                            java.util.logging.Logger.getLogger(CapturahuellaDigital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                }
                );

            }

        });

        Lector.addReaderStatusListener(
                new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado", tex);
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conecatado", tex);
                    }
                });
            }
        }
        );
        Lector.addSensorListener(
                new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella", tex);

                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido quitado del Lector de Huella", tex);
                    }
                });
            }
        }
        );
        Lector.addErrorListener(new DPFPErrorAdapter() {

            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("Error: " + e.getError(), tex);
                    }
                });
            }
        });
    }

    protected void IniciarG(JTextArea tex, JLabel img) {
        Lector.addDataListener(new DPFPDataAdapter() {

            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        EnviarTexto("La Huella Digital ha sido Capturada", tex);
                        ProcesarCaptura(e.getSample(), tex, img);
                    }
                }
                );

            }

        });

        Lector.addReaderStatusListener(
                new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado", tex);
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conecatado", tex);
                    }
                });
            }
        }
        );
        Lector.addSensorListener(
                new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella", tex);

                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido quitado del Lector de Huella", tex);
                    }
                });
            }
        }
        );
        Lector.addErrorListener(new DPFPErrorAdapter() {

            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("Error: " + e.getError(), tex);
                    }
                });
            }
        });
    }

    public String capHora(JLabel hrc) {
        String horass = "";
        horass = hrc.getText();
        System.out.println(horass);
        return horass;

    }

    /* public void dataIm(JLabel fec, JLabel day, JLabel hour) {
        // borrar(fec, day, hour);
        fec.setText(fecha);
        day.setText(dia);
        hour.setText(hora);
        
        System.out.println(hora);
    } 

     public void borrar(JLabel fec, JLabel day, JLabel hour){
        fec.setText("");
        day.setText("");
        hour.setText("");
    }*/
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor
                = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image, JLabel img) {
        img.setIcon(new ImageIcon(
                image.getScaledInstance(img.getWidth(), img.getHeight(),
                        Image.SCALE_DEFAULT)));
        repaint();
    }

    public void EstadoHuellas(JTextArea tex) {
        EnviarTexto("Muestra de Huellas Necesarias para Guardar Template "
                + Reclutador.getFeaturesNeeded(), tex);
    }

    ;
    
   

    public void EnviarTexto(String string, JTextArea tex) {
        tex.append(string + "\n");
    }

    ;

    public void start(JTextArea tex) {
        Lector.startCapture();

        EnviarTexto("Utilizando el Lector de Huella Dactilar ", tex);

    }

    ;

    public void stop(JTextArea tex) {
        Lector.stopCapture();
        EnviarTexto("No se está usando el Lector de Huella Dactilar ", tex);
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);

    }

    public void ProcesarCapturaId(DPFPSample sample, JTextArea tex, JLabel img) {

        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        if (featuresinscripcion != null) {
            try {
                System.out.println("Las caracteristicas de la huella han sido creadas");
                //Reclutador.addFeatures(featuresinscripcion);

                Image image = CrearImagenHuella(sample);
                DibujarHuella(image, img);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }

        }

    }

    public void ProcesarCaptura(DPFPSample sample, JTextArea tex, JLabel img) {

        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        if (featuresinscripcion != null) {
            try {
                System.out.println("Las caracteristicas de la huella han sido creadas");
                Reclutador.addFeatures(featuresinscripcion);

                Image image = CrearImagenHuella(sample);
                DibujarHuella(image, img);

            } catch (DPFPImageQualityException e) {  
                System.out.println("Error: " + e.getMessage());

            } finally {
                EstadoHuellas(tex);
                switch (Reclutador.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY:
                        stop(tex);
                        setTemplate(Reclutador.getTemplate());
                        EnviarTexto("La plantilla de la huella ha sido creada", tex);
                        // btnIdentificar.setEnabled(true);
                        //btnVerificar.setEnabled(true);
                        // guardar.setEnabled(true);
                        //btnGuardar.grabFocus();
                        break;

                    case TEMPLATE_STATUS_FAILED:
                        Reclutador.clear();
                        stop(tex);
                        EstadoHuellas(tex);
                        setTemplate(null);
                        JOptionPane.showMessageDialog(CapturahuellaDigital.this, "La plantilla de la huella no pudo ser creada");
                        start(tex);
                        break;

                }

            }

        }

    }

    /*public void guardarHuella() {
        //Obtiene los datos del template de la huella actual

        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        Integer tamañoHuella = template.serialize().length;
        
        
        //Pregunta el nombre de la persona a la cual corresponde dicha huella
        String nombre = JOptionPane.showInputDialog("Nombre:");
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();
            PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO somhue values (?,?,?)");

            guardarStmt.setInt(1, 0);
            guardarStmt.setString(2, nombre);
            guardarStmt.setBinaryStream(3, datosHuella, tamañoHuella);
            //Ejecuta la sentencia
            guardarStmt.executeUpdate();
            guardarStmt.close();
            JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");

            con.desconectar();
            btnGuardar.setEnabled(false);
            btnVerificar.grabFocus();
        } catch (SQLException ex) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al guardar los datos de la huella.");
            System.err.println("error " + ex);
        } finally {
            con.desconectar();
            System.out.println(nombre);
            System.out.println(datosHuella);
            System.out.println(tamañoHuella);
        }
    }*/
    public void guardarHuellas(
    
            
    String nombre,
    String cargo, 
    String telefono,
    String correo,
    JTextField jnombre,
    JTextField jcargo,
    JTextField jtelefono,
    JTextField jcorreo      
    ) {
        //Obtiene los datos del template de la huella actual
        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        Integer tamañoHuella = template.serialize().length;
        
        //Pregunta el nombre de la persona a la cual corresponde dicha huella
        nombre = jnombre.getText();
        cargo = jcargo.getText();
        telefono = jtelefono.getText();
        correo = jcorreo.getText();
        
        
        
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();
            PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO somhue values (?,?,?,?,?,?)");

            guardarStmt.setInt(1, 0);
            guardarStmt.setString(2, nombre);
            guardarStmt.setString(3, cargo);
            guardarStmt.setString(4, telefono);
            guardarStmt.setString(5, correo);
            guardarStmt.setBinaryStream(6, datosHuella, tamañoHuella);
            //Ejecuta la sentencia
            guardarStmt.executeUpdate();
            guardarStmt.close();
            JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");

            con.desconectar();
            
        } catch (SQLException ex) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al guardar los datos de la huella.");
            System.err.println("error " + ex);
        } finally {
            con.desconectar();
            System.out.println(nombre);
            System.out.println(datosHuella);
            System.out.println(tamañoHuella);
        }
    }

    public void verificarHuella(String nom) {
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();
            //Obtiene la plantilla correspondiente a la persona indicada
            PreparedStatement verificarStmt = c.prepareStatement(
                    "SELECT huehuella FROM somhue WHERE huenombre =  ?");
            verificarStmt.setString(1, nom);
            ResultSet rs = verificarStmt.executeQuery();
            //Si se encuentra el nombre en la base de datos
            if (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huehuella");
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate
                        = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // plantilla guardada al usuario especifico en la base de datos
                DPFPVerificationResult result = Verificador.verify(featuresverificacion,
                        getTemplate());
                //compara las plantilas (actual vs bd)
                if (result.isVerified()) {
                    JOptionPane.showMessageDialog(null, "Las huella capturada coinciden con la de " + nom, "Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "No corresponde la huella con " + nom, "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al verificar los datos de la huella.");
        } finally {
            con.desconectar();
        }
    }

    public void identificarHuella(JLabel label) throws IOException {

        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();

            //Obtiene todas las huellas de la bd
            PreparedStatement identificarStmt = c.prepareStatement(
                    "SELECT  `: huenombre`, `: huehuella` FROM `somhue`");
            ResultSet rs = identificarStmt.executeQuery();
            //Si se encuentra el nombre en la base de datos
            while (rs.next()) {

                //Lee la plantilla de la base de datos
                String nombre = rs.getString(": huenombre");
                byte templateBuffer[] = rs.getBytes(": huehuella");
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);

                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // alguna plantilla guardada en la base de datos que coincide con ese tipo
                DPFPVerificationResult result = Verificador.verify(featuresverificacion,
                        getTemplate());
                //compara las plantilas (actual vs bd)
                //Si encuentra correspondencia dibuja el mapa
                //e indica el nombre de la persona que coincidió.
                if (result.isVerified()) {
                    //crea la imagen de los datos guardado de las huellas guardadas en la base de               
                    //JOptionPane.showMessageDialog(null, "Las huella capturada es de " + nombre, "Verificacion de Huella ", JOptionPane.INFORMATION_MESSAGE);
                    label.setText(nombre);

                    return;

                }
            }
            //Si no encuentra alguna huella correspondiente al nombre lo indica con un
            JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
            setTemplate(null);
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al identificar huella dactilar.  " + e.getMessage());
        } finally {
            con.desconectar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombre = new javax.swing.JLabel();
        panellImagenHuella = new javax.swing.JPanel();
        lblImagenHuella = new javax.swing.JLabel();
        panBtns = new javax.swing.JPanel();
        btnVerificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lblFecha = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        lbNombre.setText("gdgggd");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panellImagenHuella.setBackground(new java.awt.Color(204, 204, 204));
        panellImagenHuella.setForeground(new java.awt.Color(204, 204, 204));
        panellImagenHuella.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellImagenHuella.add(lblImagenHuella, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 610, 290));

        getContentPane().add(panellImagenHuella, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 620, 290));

        panBtns.setBackground(new java.awt.Color(204, 204, 204));
        panBtns.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        panBtns.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 190, 40));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panBtns.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 190, 40));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panBtns.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 190, 40));

        getContentPane().add(panBtns, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 760, 240));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 760, 150));

        lblFecha.setText("jLabel1");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 140, -1));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre a verificar:");
        verificarHuella(nombre);
        Reclutador.clear();
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //guardarHuellas(hora, hora, hora, hora, lbNombre, lbNombre, lblFecha, lbNombre);
        Reclutador.clear();
        lblImagenHuella.setIcon(null);
        start(txtArea);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Iniciar(txtArea, lblImagenHuella);
        start(txtArea);
        EstadoHuellas(txtArea);
        btnGuardar.setEnabled(false);
        // btnIdentificar.setEnabled(true);
        btnVerificar.setEnabled(false);
        btnSalir.grabFocus();

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        stop(txtArea);

    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(CapturahuellaDigital.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturahuellaDigital.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturahuellaDigital.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturahuellaDigital.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JpfPrincipal principal = new JpfPrincipal();
                principal.setVisible(true);

                //new CapturahuellaDigital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImagenHuella;
    private javax.swing.JPanel panBtns;
    private javax.swing.JPanel panellImagenHuella;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
