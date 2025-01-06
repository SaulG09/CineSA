package cinesa;

import com.mysql.jdbc.PreparedStatement;
import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/**
 *
 * @author saulg
 */
public class VentaBoletos4 extends javax.swing.JFrame {

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
    int cap = 0;
    ArrayList arr = new ArrayList();
    ArrayList coun = new ArrayList();

    public VentaBoletos4(String user, String password, String ID, String IDPe, ArrayList arre) throws SQLException {
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
        u = ID;
        v = IDPe;
        arr = arre;

        jButton7.setVisible(false);
        jLabel14.setVisible(false);
        jComboBox2.setVisible(false);
        jButton4.setVisible(false);
        jLabel15.setVisible(false);
        jComboBox3.setVisible(false);
        jButton5.setVisible(false);
        jLabel16.setVisible(false);
        jComboBox4.setVisible(false);
        jButton6.setVisible(false);
        jLabel12.setVisible(false);
        jComboBox5.setVisible(false);
        if (arr.size() == 1) {
            jLabel13.setText("Asiento " + arr.get(0) + " - " + "$100");
            coun.add("100");

        } else {
            if (arr.size() == 2) {
                jLabel13.setText("Asiento " + arr.get(0) + " - " + "$100");
                jLabel14.setText("Asiento " + arr.get(1) + " - " + "$100");
                coun.add("100");
                coun.add("100");
                jButton7.setVisible(true);
                jLabel14.setVisible(true);
                jComboBox2.setVisible(true);
            } else {
                if (arr.size() == 3) {
                    jLabel13.setText("Asiento " + arr.get(0) + " - " + "$100");
                    jLabel14.setText("Asiento " + arr.get(1) + " - " + "$100");
                    jLabel15.setText("Asiento " + arr.get(2) + " - " + "$100");
                    coun.add("100");
                    coun.add("100");
                    coun.add("100");
                    jButton7.setVisible(true);
                    jLabel14.setVisible(true);
                    jComboBox2.setVisible(true);
                    jButton4.setVisible(true);
                    jLabel15.setVisible(true);
                    jComboBox3.setVisible(true);
                } else {
                    if (arr.size() == 4) {
                        jLabel13.setText("Asiento " + arr.get(0) + " - " + "$100");
                        jLabel14.setText("Asiento " + arr.get(1) + " - " + "$100");
                        jLabel15.setText("Asiento " + arr.get(2) + " - " + "$100");
                        jLabel16.setText("Asiento " + arr.get(3) + " - " + "$100");
                        coun.add("100");
                        coun.add("100");
                        coun.add("100");
                        coun.add("100");
                        jButton7.setVisible(true);
                        jLabel14.setVisible(true);
                        jComboBox2.setVisible(true);
                        jButton4.setVisible(true);
                        jLabel15.setVisible(true);
                        jComboBox3.setVisible(true);
                        jButton5.setVisible(true);
                        jLabel16.setVisible(true);
                        jComboBox4.setVisible(true);
                    } else {
                        if (arr.size() == 5) {
                            jLabel13.setText("Asiento " + arr.get(0) + " - " + "$100");
                            jLabel14.setText("Asiento " + arr.get(1) + " - " + "$100");
                            jLabel15.setText("Asiento " + arr.get(2) + " - " + "$100");
                            jLabel16.setText("Asiento " + arr.get(3) + " - " + "$100");
                            jLabel12.setText("Asiento " + arr.get(4) + " - " + "$100");
                            coun.add("100");
                            coun.add("100");
                            coun.add("100");
                            coun.add("100");
                            coun.add("100");
                            jButton7.setVisible(true);
                            jLabel14.setVisible(true);
                            jComboBox2.setVisible(true);
                            jButton4.setVisible(true);
                            jLabel15.setVisible(true);
                            jComboBox3.setVisible(true);
                            jButton5.setVisible(true);
                            jLabel16.setVisible(true);
                            jComboBox4.setVisible(true);
                            jButton6.setVisible(true);
                            jLabel12.setVisible(true);
                            jComboBox5.setVisible(true);
                        }
                    }
                }
            }
        }
        float to = 0;
        float xs = 0;
        for (int c = 0; c < coun.size(); c++) {
            xs += Float.parseFloat((String) coun.get(c));

        }
        jLabel28.setText("$" + String.valueOf(xs));
        jLabel19.setText("$" + String.valueOf(xs));
    }

    private VentaBoletos4() {

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
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();

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

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Información de la compra");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(90, 100, 1010, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boletos.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 90, 1090, 70);

        jComboBox1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adulto", "Niño" }));
        jComboBox1.setBorder(null);
        jComboBox1.setLightWeightPopupEnabled(false);
        jComboBox1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBox1InputMethodTextChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(370, 230, 110, 30);

        jComboBox2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adulto", "Niño" }));
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
        jComboBox2.setBounds(370, 290, 110, 30);

        jComboBox3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adulto", "Niño" }));
        jComboBox3.setBorder(null);
        jComboBox3.setLightWeightPopupEnabled(false);
        jComboBox3.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBox3InputMethodTextChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox3KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(370, 350, 110, 30);

        jComboBox4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adulto", "Niño" }));
        jComboBox4.setBorder(null);
        jComboBox4.setLightWeightPopupEnabled(false);
        jComboBox4.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBox4InputMethodTextChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox4KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(370, 410, 110, 30);

        jComboBox5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adulto", "Niño" }));
        jComboBox5.setBorder(null);
        jComboBox5.setLightWeightPopupEnabled(false);
        jComboBox5.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jComboBox5InputMethodTextChanged(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jComboBox5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox5KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox5);
        jComboBox5.setBounds(370, 470, 110, 30);

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel12);
        jLabel12.setBounds(80, 455, 250, 50);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel13);
        jLabel13.setBounds(80, 210, 250, 60);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(60, 460, 290, 50);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(60, 220, 290, 50);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel14);
        jLabel14.setBounds(80, 270, 250, 60);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel15);
        jLabel15.setBounds(80, 335, 250, 50);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(60, 340, 290, 50);

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel16);
        jLabel16.setBounds(80, 395, 250, 50);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(60, 400, 290, 50);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(60, 280, 290, 50);

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Cliente:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(570, 220, 80, 40);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel19);
        jLabel19.setBounds(670, 550, 150, 40);

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Contraseña:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(530, 340, 120, 40);

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 255, 204));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Compra");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(870, 170, 80, 40);

        jLabel24.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Correo:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(550, 280, 120, 40);

        jLabel25.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 255, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Total:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(595, 550, 70, 40);

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Generar factura");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel8);
        jLabel8.setBounds(970, 425, 160, 40);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton2.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton9MouseMoved(evt);
            }
        });
        jButton9.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jButton9MouseWheelMoved(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(970, 400, 160, 95);

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Aplicar descuento");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(690, 425, 160, 40);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boton2.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton10MouseMoved(evt);
            }
        });
        jButton10.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jButton10MouseWheelMoved(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(690, 400, 160, 95);

        jLabel26.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 255, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Boletos");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(170, 170, 80, 40);

        jLabel27.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 255, 204));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Subtotal:");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(560, 510, 100, 40);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel28);
        jLabel28.setBounds(670, 510, 140, 40);

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
        jTextField4.setBounds(680, 220, 460, 40);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGris.png"))); // NOI18N
        jPanel1.add(jLabel22);
        jLabel22.setBounds(660, 210, 496, 60);

        jTextField5.setBackground(new java.awt.Color(242, 242, 242));
        jTextField5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(51, 51, 51));
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(680, 280, 460, 40);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGris.png"))); // NOI18N
        jPanel1.add(jLabel23);
        jLabel23.setBounds(660, 270, 496, 60);

        jPasswordField1.setBackground(new java.awt.Color(242, 242, 242));
        jPasswordField1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordField1.setBorder(null);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(680, 340, 460, 40);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGris.png"))); // NOI18N
        jPanel1.add(jLabel17);
        jLabel17.setBounds(660, 330, 496, 60);

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
        jButton9.setIcon(new ImageIcon(getClass().getResource("/Images/Boton2.png")));
        jButton10.setIcon(new ImageIcon(getClass().getResource("/Images/Boton2.png")));

    }//GEN-LAST:event_jPanel1MouseMoved

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        VentaBoletos3 ad;
        try {
            ad = new VentaBoletos3(s, t, u, v);
            ad.show();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBox1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1InputMethodTextChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem() == "Adulto") {
            jLabel13.setText("Asiento " + arr.get(0) + " - " + "$100");
            coun.set(0, "100");
        } else {
            jLabel13.setText("Asiento " + arr.get(0) + " - " + "$80");
            coun.set(0, "80");
        }

        float xs = 0;
        for (int c = 0; c < coun.size(); c++) {
            xs += Float.parseFloat((String) coun.get(c));

        }

        jLabel28.setText("$" + String.valueOf(xs));
        if (xee == true) {
            xs = (float) (xs - (xs * 0.1));
        }
        jLabel19.setText("$" + String.valueOf(xs));
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1KeyReleased

    private void jComboBox2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBox2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2InputMethodTextChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if (jComboBox2.getSelectedItem() == "Adulto") {
            jLabel14.setText("Asiento " + arr.get(1) + " - " + "$100");
            coun.set(1, "100");
        } else {
            jLabel14.setText("Asiento " + arr.get(1) + " - " + "$80");
            coun.set(1, "80");
        }

        float xs = 0;
        for (int c = 0; c < coun.size(); c++) {
            xs += Float.parseFloat((String) coun.get(c));

        }

        jLabel28.setText("$" + String.valueOf(xs));
        if (xee == true) {
            xs = (float) (xs - (xs * 0.1));
        }
        jLabel19.setText("$" + String.valueOf(xs));
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox3InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBox3InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3InputMethodTextChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        if (jComboBox3.getSelectedItem() == "Adulto") {
            jLabel15.setText("Asiento " + arr.get(2) + " - " + "$100");
            coun.set(2, "100");
        } else {
            jLabel15.setText("Asiento " + arr.get(2) + " - " + "$80");
            coun.set(2, "80");
        }

        float xs = 0;
        for (int c = 0; c < coun.size(); c++) {
            xs += Float.parseFloat((String) coun.get(c));

        }

        jLabel28.setText("$" + String.valueOf(xs));
        if (xee == true) {
            xs = (float) (xs - (xs * 0.1));
        }
        jLabel19.setText("$" + String.valueOf(xs));
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3KeyReleased

    private void jComboBox4InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBox4InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4InputMethodTextChanged

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        if (jComboBox4.getSelectedItem() == "Adulto") {
            jLabel16.setText("Asiento " + arr.get(3) + " - " + "$100");
            coun.set(3, "100");
        } else {
            jLabel16.setText("Asiento " + arr.get(3) + " - " + "$80");
            coun.set(3, "80");
        }

        float xs = 0;
        for (int c = 0; c < coun.size(); c++) {
            xs += Float.parseFloat((String) coun.get(c));

        }

        jLabel28.setText("$" + String.valueOf(xs));
        if (xee == true) {
            xs = (float) (xs - (xs * 0.1));
        }
        jLabel19.setText("$" + String.valueOf(xs));
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jComboBox4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox5InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jComboBox5InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5InputMethodTextChanged

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        if (jComboBox5.getSelectedItem() == "Adulto") {
            jLabel12.setText("Asiento " + arr.get(4) + " - " + "$100");
            coun.set(4, "100");
        } else {
            jLabel12.setText("Asiento " + arr.get(4) + " - " + "$80");
            coun.set(4, "80");
        }

        float xs = 0;
        for (int c = 0; c < coun.size(); c++) {
            xs += Float.parseFloat((String) coun.get(c));

        }

        jLabel28.setText("$" + String.valueOf(xs));
        if (xee == true) {
            xs = (float) (xs - (xs * 0.1));
        }
        jLabel19.setText("$" + String.valueOf(xs));
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5KeyPressed

    private void jComboBox5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseMoved
        // TODO add your handling code here:
        jButton9.setIcon(new ImageIcon(getClass().getResource("/Images/Boton1.png")));
    }//GEN-LAST:event_jButton9MouseMoved

    private void jButton9MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jButton9MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseWheelMoved

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if ("".equals(jTextField4.getText())) {
            UIManager.put("control", new Color(51, 51, 51));
            UIManager.put("OptionPane.messageFont", f);
            UIManager.put("OptionPane.messageForeground", Color.white);
            UIManager.put("OptionPane.messageIconImage", null);
            JOptionPane.showMessageDialog(null, "Ingresa el nombre del cliente.");
        } else {
            try {
                float xs = 0;
                for (int c = 0; c < coun.size(); c++) {
                    xs += Float.parseFloat((String) coun.get(c));

                }
                if (xee == true) {
                    xs = (float) (xs - (xs * 0.1));
                }
                String timeStamp = new SimpleDateFormat("YYYY/MM/dd").format(Calendar.getInstance().getTime());
                String timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                System.out.println(timeStamp);
                String g = "insert into venta (cliente, total, fechaCompra, hora, vendedor) values('" + jTextField4.getText() + "', '" + xs + "', '" + timeStamp + "', '" + timeStamp2 + "', '" + s + "')";
                ps = (PreparedStatement) con.getConect().prepareStatement(g);
                ps.execute();
                String see = "";
                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM venta where fechaCompra='" + timeStamp + "' AND hora='" + timeStamp2 + "'");
                ResultSet sr = ps.executeQuery();
                while (sr.next()) {
                    see = sr.getString("ID");
                    System.out.println(see);

                }

                if (arr.size() == 1) {
                    String de[] = jLabel13.getText().split(" - ");
                    String as[] = de[0].split(" ");
                    String ge = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as[1] + "', '" + jComboBox1.getSelectedItem() + "', '" + coun.get(0) + "', '" + u + "', '" + see + "')";
                    ps = (PreparedStatement) con.getConect().prepareStatement(ge);
                    ps.execute();
                } else {
                    if (arr.size() == 2) {
                        String de[] = jLabel13.getText().split(" - ");
                        String as[] = de[0].split(" ");
                        String ge = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as[1] + "', '" + jComboBox1.getSelectedItem() + "', '" + coun.get(0) + "', '" + u + "', '" + see + "')";
                        ps = (PreparedStatement) con.getConect().prepareStatement(ge);
                        ps.execute();

                        String de2[] = jLabel14.getText().split(" - ");
                        String as2[] = de2[0].split(" ");
                        String ge2 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as2[1] + "', '" + jComboBox2.getSelectedItem() + "', '" + coun.get(1) + "', '" + u + "', '" + see + "')";
                        ps = (PreparedStatement) con.getConect().prepareStatement(ge2);
                        ps.execute();
                    } else {
                        if (arr.size() == 3) {
                            String de[] = jLabel13.getText().split(" - ");
                            String as[] = de[0].split(" ");
                            String ge = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as[1] + "', '" + jComboBox1.getSelectedItem() + "', '" + coun.get(0) + "', '" + u + "', '" + see + "')";
                            ps = (PreparedStatement) con.getConect().prepareStatement(ge);
                            ps.execute();

                            String de2[] = jLabel14.getText().split(" - ");
                            String as2[] = de2[0].split(" ");
                            String ge2 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as2[1] + "', '" + jComboBox2.getSelectedItem() + "', '" + coun.get(1) + "', '" + u + "', '" + see + "')";
                            ps = (PreparedStatement) con.getConect().prepareStatement(ge2);
                            ps.execute();

                            String de3[] = jLabel15.getText().split(" - ");
                            String as3[] = de3[0].split(" ");
                            String ge3 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as3[1] + "', '" + jComboBox3.getSelectedItem() + "', '" + coun.get(2) + "', '" + u + "', '" + see + "')";
                            ps = (PreparedStatement) con.getConect().prepareStatement(ge3);
                            ps.execute();
                        } else {
                            if (arr.size() == 4) {
                                String de[] = jLabel13.getText().split(" - ");
                                String as[] = de[0].split(" ");
                                String ge = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as[1] + "', '" + jComboBox1.getSelectedItem() + "', '" + coun.get(0) + "', '" + u + "', '" + see + "')";
                                ps = (PreparedStatement) con.getConect().prepareStatement(ge);
                                ps.execute();

                                String de2[] = jLabel14.getText().split(" - ");
                                String as2[] = de2[0].split(" ");
                                String ge2 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as2[1] + "', '" + jComboBox2.getSelectedItem() + "', '" + coun.get(1) + "', '" + u + "', '" + see + "')";
                                ps = (PreparedStatement) con.getConect().prepareStatement(ge2);
                                ps.execute();

                                String de3[] = jLabel15.getText().split(" - ");
                                String as3[] = de3[0].split(" ");
                                String ge3 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as3[1] + "', '" + jComboBox3.getSelectedItem() + "', '" + coun.get(2) + "', '" + u + "', '" + see + "')";
                                ps = (PreparedStatement) con.getConect().prepareStatement(ge3);
                                ps.execute();

                                String de4[] = jLabel16.getText().split(" - ");
                                String as4[] = de4[0].split(" ");
                                String ge4 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as4[1] + "', '" + jComboBox4.getSelectedItem() + "', '" + coun.get(3) + "', '" + u + "', '" + see + "')";
                                ps = (PreparedStatement) con.getConect().prepareStatement(ge4);
                                ps.execute();
                            } else {
                                if (arr.size() == 5) {
                                    String de[] = jLabel13.getText().split(" - ");
                                    String as[] = de[0].split(" ");
                                    String ge = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as[1] + "', '" + jComboBox1.getSelectedItem() + "', '" + coun.get(0) + "', '" + u + "', '" + see + "')";
                                    ps = (PreparedStatement) con.getConect().prepareStatement(ge);
                                    ps.execute();

                                    String de2[] = jLabel14.getText().split(" - ");
                                    String as2[] = de2[0].split(" ");
                                    String ge2 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as2[1] + "', '" + jComboBox2.getSelectedItem() + "', '" + coun.get(1) + "', '" + u + "', '" + see + "')";
                                    ps = (PreparedStatement) con.getConect().prepareStatement(ge2);
                                    ps.execute();

                                    String de3[] = jLabel15.getText().split(" - ");
                                    String as3[] = de3[0].split(" ");
                                    String ge3 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as3[1] + "', '" + jComboBox3.getSelectedItem() + "', '" + coun.get(2) + "', '" + u + "', '" + see + "')";
                                    ps = (PreparedStatement) con.getConect().prepareStatement(ge3);
                                    ps.execute();

                                    String de4[] = jLabel16.getText().split(" - ");
                                    String as4[] = de4[0].split(" ");
                                    String ge4 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as4[1] + "', '" + jComboBox4.getSelectedItem() + "', '" + coun.get(3) + "', '" + u + "', '" + see + "')";
                                    ps = (PreparedStatement) con.getConect().prepareStatement(ge4);
                                    ps.execute();

                                    String de5[] = jLabel12.getText().split(" - ");
                                    String as5[] = de5[0].split(" ");
                                    String ge5 = "insert into boletos (fechaCompra, asiento, clasificacion, precio, IDFuncion, IDVenta) values('" + timeStamp + "', '" + as5[1] + "', '" + jComboBox5.getSelectedItem() + "', '" + coun.get(4) + "', '" + u + "', '" + see + "')";
                                    ps = (PreparedStatement) con.getConect().prepareStatement(ge5);
                                    ps.execute();
                                }
                            }
                        }
                    }
                }
                ps.close();
                VentaBoletos5 ad;
                try {
                    ad = new VentaBoletos5(s, t, see, u, v);
                    ad.show();
                    dispose();
                } catch (Exception ex) {
                    Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException er) {
                System.out.println(er);
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseMoved
        // TODO add your handling code here:

        jButton10.setIcon(new ImageIcon(getClass().getResource("/Images/Boton1.png")));


    }//GEN-LAST:event_jButton10MouseMoved

    private void jButton10MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jButton10MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseWheelMoved

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if ("".equals(jTextField5.getText()) || "".equals(jTextField4.getText()) || "".equals(jPasswordField1.getText())) {
            UIManager.put("control", new Color(51, 51, 51));
            UIManager.put("OptionPane.messageFont", f);
            UIManager.put("OptionPane.messageForeground", Color.white);
            UIManager.put("OptionPane.messageIconImage", null);
            JOptionPane.showMessageDialog(null, "Faltan campos por llenar.\nIntente nuevamente.");
        } else {
            try {
                ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM cuentas WHERE email='" + jTextField5.getText() + "'");
                ResultSet sr = ps.executeQuery();
                while (sr.next()) {
                    String se = sr.getString("email");
                    String ue = sr.getString("contraseña");
                    String r = sr.getString("VIP");
                    System.out.println(se + ue);
                    if (se.equals(jTextField5.getText()) || ue.equals(jPasswordField1.getText())) {
                        if ("Si".equals(r)) {
                            xee = true;
                            jLabel24.setVisible(false);
                            jLabel20.setVisible(false);
                            jTextField5.setVisible(false);
                            jLabel23.setVisible(false);
                            jPasswordField1.setVisible(false);
                            jLabel17.setVisible(false);
                            jLabel9.setVisible(false);
                            jButton10.setVisible(false);
                            jLabel8.setLocation(jLabel8.getX() - 180, jLabel8.getY() - 120);
                            jButton9.setLocation(jButton9.getX() - 180, jButton9.getY() - 120);
                            jLabel27.setLocation(jLabel27.getX(), jLabel27.getY() - 120);
                            jLabel28.setLocation(jLabel28.getX(), jLabel28.getY() - 120);
                            jLabel25.setLocation(jLabel25.getX(), jLabel25.getY() - 120);
                            jLabel19.setLocation(jLabel19.getX(), jLabel19.getY() - 120);
                            float xs = 0;
                            for (int c = 0; c < coun.size(); c++) {
                                xs += Float.parseFloat((String) coun.get(c));

                            }

                            jLabel28.setText("$" + String.valueOf(xs));
                            xee = true;
                            if (xee == true) {
                                xs = (float) (xs - (xs * 0.1));
                            }
                            jLabel19.setText("$" + String.valueOf(xs));

                        } else {
                            UIManager.put("control", new Color(51, 51, 51));
                            UIManager.put("OptionPane.messageFont", f);
                            UIManager.put("OptionPane.messageForeground", Color.white);
                            UIManager.put("OptionPane.messageIconImage", null);
                            JOptionPane.showMessageDialog(null, "La cuenta no cuenta con suscripción VIP.");
                            break;
                        }
                    } 
                    break;
                }
                ps.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped

    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped

    }//GEN-LAST:event_jTextField5KeyTyped

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
            java.util.logging.Logger.getLogger(VentaBoletos4.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos4.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos4.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos4.class
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaBoletos4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
