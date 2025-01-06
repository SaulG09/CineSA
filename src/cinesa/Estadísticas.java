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
public class Estadísticas extends javax.swing.JFrame {

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

    public Estadísticas(String user, String password) throws SQLException {
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
        jLabel1.setText("Administrador: " + user);
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
        try {
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT MAX(pelicula.nombre) FROM pelicula INNER JOIN funcion INNER JOIN boletos ON pelicula.IDPelicula = funcion.IDPelicula and funcion.IDFuncion = boletos.IDFuncion and boletos.fechaCompra = CURRENT_DATE()");
            ResultSet sree = ps.executeQuery();
            while (sree.next()) {
                String ere = sree.getString("MAX(pelicula.nombre)");
                jLabel28.setText(ere);
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT MAX(pelicula.nombre) FROM pelicula INNER JOIN funcion INNER JOIN boletos ON pelicula.IDPelicula = funcion.IDPelicula and funcion.IDFuncion = boletos.IDFuncion and MONTH(boletos.fechaCompra) = MONTH(NOW())");
            ResultSet sreee = ps.executeQuery();
            while (sreee.next()) {
                String ere = sreee.getString("MAX(pelicula.nombre)");
                jLabel27.setText(ere);
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT SUM(venta.total) from venta WHERE DAYNAME(venta.fechaCompra) = DAYNAME(NOW())");
            ResultSet sreeee = ps.executeQuery();
            while (sreeee.next()) {

                String ere = sreeee.getString("SUM(venta.total)");
                if (ere == null) {
                    jLabel29.setText("$0");
                } else {
                    jLabel29.setText("$" + ere);
                }
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT SUM(venta.total) from venta WHERE MONTHNAME(venta.fechaCompra) = MONTHNAME(NOW())");
            ResultSet sreeeee = ps.executeQuery();
            while (sreeeee.next()) {
                String ere = sreeeee.getString("SUM(venta.total)");
                if (ere == null) {
                    jLabel30.setText("$0");
                } else {
                    jLabel30.setText("$" + ere);
                }
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT SUM(venta.total) from venta");
            ResultSet sreeeeee = ps.executeQuery();
            while (sreeeeee.next()) {
                String ere = sreeeeee.getString("SUM(venta.total)");
                jLabel31.setText("$" + ere);
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT COUNT(boletos.asiento) FROM boletos WHERE DAYNAME(boletos.fechaCompra) = DAYNAME(NOW())");
            ResultSet sreeeeeee = ps.executeQuery();
            while (sreeeeeee.next()) {
                String ere = sreeeeeee.getString("COUNT(boletos.asiento)");
                jLabel32.setText(ere);
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT COUNT(boletos.asiento) FROM boletos");
            ResultSet sreeeeeeee = ps.executeQuery();
            while (sreeeeeeee.next()) {
                String ere = sreeeeeeee.getString("COUNT(boletos.asiento)");
                jLabel33.setText(ere);
            }

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT COUNT(venta.cliente) FROM venta");
            ResultSet sreeeeeeeeee = ps.executeQuery();
            while (sreeeeeeeeee.next()) {
                String ere = sreeeeeeeeee.getString("COUNT(venta.cliente)");
                jLabel43.setText(ere);
            }

        } catch (SQLException pe) {

        }

    }

    private Estadísticas() {

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
        jLabel43 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

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

        jLabel43.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("jLabel27");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(960, 500, 230, 40);

        jLabel33.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("jLabel27");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(960, 420, 230, 40);

        jLabel32.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("jLabel27");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(640, 500, 250, 40);

        jLabel31.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("jLabel27");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(330, 500, 250, 40);

        jLabel30.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("jLabel27");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(640, 420, 250, 40);

        jLabel29.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("jLabel27");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(330, 420, 250, 40);

        jLabel28.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel28);
        jLabel28.setBounds(10, 500, 230, 40);

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
        jTextField4.setBounds(900, 170, 250, 40);

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

        jTable1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 16)); // NOI18N
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
        jScrollPane1.setBounds(40, 220, 540, 150);

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Estadísticas");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(90, 100, 1010, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boletos.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 90, 1090, 70);

        jTable2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 16)); // NOI18N
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
        jScrollPane2.setBounds(590, 220, 570, 150);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(880, 160, 290, 60);

        jComboBox2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
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
        jComboBox2.setBounds(780, 170, 90, 30);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Ventas de hoy ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(40, 170, 190, 40);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Ganancias mensuales");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(630, 380, 170, 40);

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

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Ventas generales ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(590, 170, 240, 40);

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Número de ventas totales");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(950, 460, 200, 40);

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Ganancias totales");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(320, 460, 140, 40);

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Ganancias del día");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(320, 380, 140, 40);

        jLabel19.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Película más vista del día");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(20, 460, 200, 40);

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Boletos vendidos del día");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(630, 460, 190, 40);

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Película más vista del mes");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 380, 200, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(-20, 490, 286, 60);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(620, 410, 286, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(310, 410, 286, 60);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel22);
        jLabel22.setBounds(620, 490, 286, 60);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel23);
        jLabel23.setBounds(940, 490, 286, 60);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel24);
        jLabel24.setBounds(310, 490, 286, 60);

        jLabel25.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Boletos vendidos  totales");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(950, 380, 190, 40);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel26);
        jLabel26.setBounds(940, 410, 286, 60);

        jLabel27.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("jLabel27");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(10, 420, 220, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(-20, 410, 286, 60);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Avanzado");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel11);
        jLabel11.setBounds(1010, 590, 160, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton2.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton6MouseMoved(evt);
            }
        });
        jButton6.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jButton6MouseWheelMoved(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(1010, 570, 160, 90);

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
        jButton6.setIcon(new ImageIcon(getClass().getResource("/Images/Boton2.png")));


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
        AdminMain ad;
        try {
            ad = new AdminMain(s, t);
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

    private void jButton6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseMoved
        // TODO add your handling code here:
        jButton6.setIcon(new ImageIcon(getClass().getResource("/Images/Boton1.png")));
    }//GEN-LAST:event_jButton6MouseMoved

    private void jButton6MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jButton6MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseWheelMoved

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Reportes ad;
        try {
            ad = new Reportes(s, t);
            ad.show();
            dispose();

        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Estadísticas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadísticas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadísticas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadísticas.class
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
                new Estadísticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
