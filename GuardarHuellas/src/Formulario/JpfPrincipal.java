package Formulario;

import Funtions.ConexionBD;
import Funtions.Metho;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JpfPrincipal extends javax.swing.JFrame {

    ConexionBD con = new ConexionBD();
    DefaultTableModel model = new DefaultTableModel();
    Metho metho = new Metho();

    public String nombre = "";
    public String cargo = "";
    public String telefono = "";
    public String correo = "";
    public String dia = "";
    public String fecha = "";
    public int indice;
    private Thread time = null;

    public String hora = metho.MostrarHora();
    CapturahuellaDigital inicio = new CapturahuellaDigital();
    Add_User agregar = new Add_User();

    public JpfPrincipal() {
        this.setUndecorated(true);
        initComponents();
        jTabbedPane1.setSelectedIndex(2);
        tabla();

        System.out.println("ultimo index " + getIndexx());

        this.setLocationRelativeTo(null);
        metho.reloj(jLHora, jLDia, jLFecha);
        //inicio.start(jTextArea1)inicio.start(jTextAreaGuardar);;

        

    }

    public void tabla() {
        model.setRowCount(0);
        model.setColumnCount(0);
        try {
            System.out.print("CONECCION EXITOSA!!");
            Connection cn = con.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " select * from datos_resgistros order by fecha desc");

            ResultSet rs = pst.executeQuery();

            jTableRegistros = new JTable(model);
            jScrollRegistros.setViewportView(jTableRegistros);

            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Hora");
            model.addColumn("Fecha");
            model.addColumn("Dia");

            // ciclo para llenar la tabla
            /* cuando hay una solicitud  para generar 
            la lista, se crea un ciclo con un objeto...
             se crea un nuevo ciclo para iterar cada una
             de las posiciones e insertar cada uno de los datos en las 
            posiciones de las filas*/
            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);

            }
            cn.close();

        } catch (SQLException e) {
            System.err.print("Error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
        }
    }

    public int getIndexx() {

        int valorIndex = 5;

        try {
            System.out.print("CONECCION EXITOSA!!");
            Connection cn = con.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    " SELECT indexxx FROM indice WHERE id = ( SELECT MAX(id) FROM indice)");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                valorIndex = rs.getInt("indexxx");

            }

            cn.close();

        } catch (SQLException e) {
            System.err.print("Error Sql" + e);

        }
        return valorIndex;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPMinimizar = new javax.swing.JPanel();
        jlbMinimizar = new javax.swing.JLabel();
        jPCerrar = new javax.swing.JPanel();
        jlbCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaGuardar = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollRegistros = new javax.swing.JScrollPane();
        jTableRegistros = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLImagenHuella = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLNombre = new javax.swing.JLabel();
        jLDia = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLguardado = new javax.swing.JLabel();
        jLimagen = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("footprint");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 150, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 90, 70));

        jPMinimizar.setBackground(new java.awt.Color(1, 55, 99));
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

        getContentPane().add(jPMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 70, 60));

        jPCerrar.setBackground(new java.awt.Color(1, 55, 99));
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

        getContentPane().add(jPCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 70, 60));

        jPanel1.setBackground(new java.awt.Color(221, 245, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CTC");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 150, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/escaneo-de-huellas-digitales.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backBlue Step.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentMoved(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Records");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 300, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel4MouseMoved(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next-week.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Capture date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 300, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 620));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Step.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 780, 110));

        jPanel5.setBackground(new java.awt.Color(221, 245, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 228, 228)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 280, 30));

        jTxTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 280, 30));

        jTxCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.add(jTxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 280, 30));

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

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 330, 300));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(jLImagenHuellaGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 300));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 300));

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

        jPanel11.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 180, 50));

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 710, 390));

        jTextAreaGuardar.setColumns(20);
        jTextAreaGuardar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jTextAreaGuardar.setRows(5);
        jScrollPane2.setViewportView(jTextAreaGuardar);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 760, 90));

        jTabbedPane1.addTab("tab1", jPanel5);

        jPanel6.setBackground(new java.awt.Color(221, 245, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollRegistros.setViewportView(jTableRegistros);

        jPanel6.add(jScrollRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 720, 380));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Corbel", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Registros");
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 50));

        jPanel6.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 720, 80));

        jTabbedPane1.addTab("tab2", jPanel6);

        jPanel7.setBackground(new java.awt.Color(221, 245, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLImagenHuella.setBackground(new java.awt.Color(255, 255, 255));
        jLImagenHuella.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.add(jLImagenHuella, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 300));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 350, 300));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 140));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 660, 140));

        jLNombre.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(102, 102, 102));
        jLNombre.setText("--");
        jPanel7.add(jLNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        jLDia.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLDia.setForeground(new java.awt.Color(102, 102, 102));
        jLDia.setText("--");
        jPanel7.add(jLDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel20.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Nombre :");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel23.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Dia :");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLFecha.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLFecha.setForeground(new java.awt.Color(0, 102, 204));
        jLFecha.setText("--/--/--");
        jPanel7.add(jLFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jLabel19.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Fecha :");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLguardado.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLguardado.setForeground(new java.awt.Color(51, 204, 0));
        jPanel7.add(jLguardado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 170, -1));

        jLimagen.setBackground(new java.awt.Color(255, 255, 255));
        jLimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngegg.png"))); // NOI18N
        jLimagen.setText("jLabel13");
        jPanel7.add(jLimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 90, 350, 300));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Hora :");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLHora.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLHora.setForeground(new java.awt.Color(51, 102, 255));
        jLHora.setText("--:--:--");
        jPanel10.add(jLHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 300));

        jTextField1.setText("jTextField1");
        jPanel7.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-button (3).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 80));

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 70, 80));

        jTabbedPane1.addTab("tab3", jPanel7);
        jTabbedPane1.addTab("tab4", jTabbedPane2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 780, 550));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("footprint");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 150, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

         
        new Add_User().setVisible(true);
        dispose();
        

        //jTabbedPane1.setSelectedIndex(0);
        //inicio.IniciarG(jTextAreaGuardar, jLImagenHuellaGuardar);
// inicio.HiloGuardar(jTabbedPane1, nombre, cargo, telefono, correo, jTxNombre, jTxCargo, jTxTelefono, jTxCorreo, jTextAreaGuardar);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        jPanel2.setBackground(new Color(23, 156, 211));
    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel3ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentMoved

    }//GEN-LAST:event_jPanel3ComponentMoved

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(255, 255, 255));
                      }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        try {
            jTabbedPane1.setSelectedIndex(2);

            inicio.start(jTextAreaGuardar);
            inicio.Iniciar(jTextArea1, jLImagenHuella, jLNombre, jLHora, nombre, hora, fecha, dia, jLNombre, jLHora, jLFecha, jLguardado, jLDia);

        } catch (Exception e) {
            System.out.println(e);
        }

        //this.dispose();

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved
        jPanel4.setBackground(new Color(23, 156, 211));
    }//GEN-LAST:event_jPanel4MouseMoved

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        jPanel3.setBackground(new Color(23, 156, 211));
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPCerrarMouseClicked

    private void jlbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jlbCerrarMouseClicked

    private void jPCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseMoved
        jPCerrar.setBackground(Color.red);
    }//GEN-LAST:event_jPCerrarMouseMoved

    private void jPCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseExited
        jPCerrar.setBackground(new Color(1, 55, 99));
    }//GEN-LAST:event_jPCerrarMouseExited

    private void jlbCerrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseMoved
        jPCerrar.setBackground(Color.red);
    }//GEN-LAST:event_jlbCerrarMouseMoved

    private void jlbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseExited
        jPCerrar.setBackground(new Color(1, 55, 99));
    }//GEN-LAST:event_jlbCerrarMouseExited

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
        jPMinimizar.setBackground(new Color(1, 55, 99));
    }//GEN-LAST:event_jPMinimizarMouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        jTabbedPane1.setSelectedIndex(1);
        tabla();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseMoved
        jPanel15.setBackground(new Color(23, 156, 211));
    }//GEN-LAST:event_jPanel15MouseMoved

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        jTabbedPane1.setSelectedIndex(0);
        inicio.guardarHuellas(nombre, cargo, telefono, correo, jTxNombre, jTxCargo, jTxTelefono, jTxCorreo, jTextAreaGuardar);
        try {
            JpfPrincipal principal = new JpfPrincipal();
            principal.setVisible(true);

            dispose();
        } catch (Exception e) {
            System.err.println("error" + e);

        }


    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        jPanel15.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel15MouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
          
        new Add_User().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(JpfPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JpfPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JpfPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JpfPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JpfPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDia;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLImagenHuella;
    private javax.swing.JLabel jLImagenHuellaGuardar;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLguardado;
    private javax.swing.JLabel jLimagen;
    private javax.swing.JPanel jPCerrar;
    private javax.swing.JPanel jPMinimizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollRegistros;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableRegistros;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaGuardar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTxCargo;
    private javax.swing.JTextField jTxCorreo;
    private javax.swing.JTextField jTxNombre;
    private javax.swing.JTextField jTxTelefono;
    private javax.swing.JLabel jlbCerrar;
    private javax.swing.JLabel jlbMinimizar;
    // End of variables declaration//GEN-END:variables
}
