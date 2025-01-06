package cinesa;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saulg
 */
public class ConsultaVentas extends javax.swing.JFrame {

    /**
     * Creates new form Cine
     */
    Controlador con = new Controlador();
    PreparedStatement ps;
    Hora hr = new Hora();
    Font f = new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18);
    boolean xee = false;
    String s;
    String t;
    String u;
    String v;
    String w;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    String tb[][];
    int ton = 0;

    public ConsultaVentas(String user, String password) throws SQLException {
        setUndecorated(true);
        setSize(1200, 690);
        Shape forma = new RoundRectangle2D.Double(0, -0, getBounds().width, getBounds().height, 30, 30);
        setShape(forma);
        //this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
        initComponents();
        jLabel1.setText("A");
        hr.setTexto(jLabel7);
        hr.start();
        jLabel1.setText("Vendedor: " + user);
        s = user;
        t = password;
        model.addColumn("ID Venta");
        model.addColumn("Cliente");
        model.addColumn("Película");
        model.addColumn("Fecha de Compra");
        model.addColumn("Hora");
        model.addColumn("Número de Boletos");
        model.addColumn("Total");
        model.setRowCount(0);
        try {
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM venta");
            ResultSet sr = ps.executeQuery();
            while (sr.next()) {
                String bol = "";
                String bol2 = "";
                String peli = "";
                int cone = 0;
                String er = sr.getString("ID");
                String se = sr.getString("cliente");
                String ce = sr.getString("fechaCompra");
                String ue = sr.getString("total");
                String te = sr.getString("hora");
                System.out.println(er + se + ce + ue + te);

                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM boletos WHERE IDVenta='" + er + "'");
                ResultSet sre = ps.executeQuery();
                while (sre.next()) {
                    cone++;
                    bol = sre.getString("IDFuncion");
                }

                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM funcion WHERE IDFuncion='" + bol + "'");
                ResultSet sree = ps.executeQuery();
                while (sree.next()) {
                    bol2 = sree.getString("IDPelicula");
                    System.out.println(bol2);
                    break;
                }

                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM pelicula WHERE IDPelicula = '" + bol2 + "'");
                ResultSet sreee = ps.executeQuery();
                while (sreee.next()) {

                    peli = sreee.getString("nombre");
                    System.out.println(peli);
                    break;
                }
                String timeStamp = new SimpleDateFormat("YYYY/MM/dd").format(Calendar.getInstance().getTime());
                String fec[] = timeStamp.split("/");
                timeStamp = fec[0] + "-" + fec[1] + "-" + fec[2];
                if (ce.equals(timeStamp)) {
                    model.addRow(new Object[]{er, se, peli, ce, te, cone, "$" + ue});
                }
            }
        } catch (SQLException ex) {

        }
        jTable1.setModel(model);
        jTable1.updateUI();

        model2.addColumn("ID Venta");
        model2.addColumn("Cliente");
        model2.addColumn("Película");
        model2.addColumn("Fecha de Compra");
        model2.addColumn("Hora");
        model2.addColumn("Número de Boletos");
        model2.addColumn("Total");
        model2.setRowCount(0);
        try {
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM venta");
            ResultSet sr = ps.executeQuery();
            while (sr.next()) {
                String bol = "";
                String bol2 = "";
                String peli = "";
                int cone = 0;
                String er = sr.getString("ID");
                String se = sr.getString("cliente");
                String ce = sr.getString("fechaCompra");
                String ue = sr.getString("total");
                String te = sr.getString("hora");
                System.out.println(er + se + ce + ue + te);

                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM boletos WHERE IDVenta='" + er + "'");
                ResultSet sre = ps.executeQuery();
                while (sre.next()) {
                    cone++;
                    bol = sre.getString("IDFuncion");
                }

                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM funcion WHERE IDFuncion='" + bol + "'");
                ResultSet sree = ps.executeQuery();
                while (sree.next()) {
                    bol2 = sree.getString("IDPelicula");
                    System.out.println(bol2);
                    break;
                }

                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM pelicula WHERE IDPelicula = '" + bol2 + "'");
                ResultSet sreee = ps.executeQuery();
                while (sreee.next()) {

                    peli = sreee.getString("nombre");
                    System.out.println(peli);
                    break;
                }

                model2.addRow(new Object[]{er, se, peli, ce, te, cone, "$" + ue});

            }
        } catch (SQLException ex) {

        }
        jTable2.setModel(model2);
        jTable2.updateUI();
        ton = jTable2.getRowCount();
        tb = new String[jTable2.getRowCount()][jTable2.getColumnCount()];
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            for (int j = 0; j < jTable2.getColumnCount(); j++) {
                tb[i][j] = jTable2.getValueAt(i, j).toString();
                System.out.println("Valor bueno " + tb[i][j]);
            }
        }
    }

    private ConsultaVentas() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Menú de operaciones");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1037, 495));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 690));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 690));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 690));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(null);

        jTextField4.setBackground(new java.awt.Color(242, 242, 242));
        jTextField4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(51, 51, 51));
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(690, 390, 250, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CerrarP.png"))); // NOI18N
        jButton2.setToolTipText("Cerrar Aplicación");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1100, 10, 80, 70);

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(340, 0, 310, 40);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(660, 0, 240, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoSup.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, -530, 680, 580);

        jTable1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 22)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setGridColor(new java.awt.Color(153, 153, 255));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(90, 220, 1030, 150);

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ventas");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(90, 100, 1010, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boletos.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 90, 1090, 70);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Buscar:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(580, 390, 100, 40);

        jTable2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 22)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setGridColor(new java.awt.Color(153, 153, 255));
        jTable2.setOpaque(false);
        jTable2.setRowHeight(28);
        jTable2.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(90, 450, 1030, 200);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(670, 380, 290, 60);

        jComboBox2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Película", "Fecha de Compra", "Hora", "Número de Boletos" }));
        jComboBox2.setBorder(null);
        jComboBox2.setLightWeightPopupEnabled(false);
        jComboBox2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBox2InputMethodTextChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(980, 390, 140, 40);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Ventas de hoy ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(90, 170, 1030, 40);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Ventas generales ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(90, 390, 240, 40);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegresarB.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(58, 10, 90, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_jPanel1MouseMoved

    private void jComboBox2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBox2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2InputMethodTextChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        VendedorMain ad;
        try {
            ad = new VendedorMain(s, t);
            ad.show();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        model2.setRowCount(0);
        if (jComboBox2.getSelectedItem() == "Cliente") {

            for (int i = 0; i < ton; i++) {
                String com = "";
                try {
                    for (int j = 0; j < jTextField4.getText().length(); j++) {
                        com += tb[i][1].charAt(j);
                        System.out.println(com);
                    }
                    if (jTextField4.getText().equals(com)) {
                        model2.addRow(new Object[]{tb[i][0], tb[i][1], tb[i][2], tb[i][3], tb[i][4], tb[i][5], tb[i][6]});
                    }
                } catch (Exception e) {

                }

                System.out.println(tb[i][1]);
            }

            jTable2.setModel(model2);
            jTable2.updateUI();
        } else {
            if (jComboBox2.getSelectedItem() == "Película") {
                for (int i = 0; i < ton; i++) {
                    String com = "";
                    try {
                        for (int j = 0; j < jTextField4.getText().length(); j++) {
                            com += tb[i][2].charAt(j);
                            System.out.println(com);
                        }
                        if (jTextField4.getText().equals(com)) {
                            model2.addRow(new Object[]{tb[i][0], tb[i][1], tb[i][2], tb[i][3], tb[i][4], tb[i][5], tb[i][6]});
                        }
                    } catch (Exception e) {

                    }

                    System.out.println(tb[i][1]);
                }

                jTable2.setModel(model2);
                jTable2.updateUI();
            } else {
                if (jComboBox2.getSelectedItem() == "Fecha de Compra") {
                    for (int i = 0; i < ton; i++) {
                        String com = "";
                        try {
                            for (int j = 0; j < jTextField4.getText().length(); j++) {
                                com += tb[i][3].charAt(j);
                                System.out.println(com);
                            }
                            if (jTextField4.getText().equals(com)) {
                                model2.addRow(new Object[]{tb[i][0], tb[i][1], tb[i][2], tb[i][3], tb[i][4], tb[i][5], tb[i][6]});
                            }
                        } catch (Exception e) {

                        }

                        System.out.println(tb[i][1]);
                    }

                    jTable2.setModel(model2);
                    jTable2.updateUI();
                } else {
                    if (jComboBox2.getSelectedItem() == "Hora") {
                        for (int i = 0; i < ton; i++) {
                            String com = "";
                            try {
                                for (int j = 0; j < jTextField4.getText().length(); j++) {
                                    com += tb[i][4].charAt(j);
                                    System.out.println(com);
                                }
                                if (jTextField4.getText().equals(com)) {
                                    model2.addRow(new Object[]{tb[i][0], tb[i][1], tb[i][2], tb[i][3], tb[i][4], tb[i][5], tb[i][6]});
                                }
                            } catch (Exception e) {

                            }

                            System.out.println(tb[i][1]);
                        }

                        jTable2.setModel(model2);
                        jTable2.updateUI();
                    } else {
                        if (jComboBox2.getSelectedItem() == "Número de Boletos") {
                            for (int i = 0; i < ton; i++) {
                                String com = "";
                                try {
                                    for (int j = 0; j < jTextField4.getText().length(); j++) {
                                        com += tb[i][5].charAt(j);
                                        System.out.println(com);
                                    }
                                    if (jTextField4.getText().equals(com)) {
                                        model2.addRow(new Object[]{tb[i][0], tb[i][1], tb[i][2], tb[i][3], tb[i][4], tb[i][5], tb[i][6]});
                                    }
                                } catch (Exception e) {

                                }

                                System.out.println(tb[i][1]);
                            }

                            jTable2.setModel(model2);
                            jTable2.updateUI();
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped

    }//GEN-LAST:event_jTextField4KeyTyped

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
            java.util.logging.Logger.getLogger(ConsultaVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
