package cinesa;

import com.mysql.jdbc.PreparedStatement;
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
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class VentaBoletos3 extends javax.swing.JFrame {

    /**
     * Creates new form Cine
     */
    Controlador con = new Controlador();
    PreparedStatement ps;
    Hora hr = new Hora();
    Font f = new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18);
    boolean x = true;
    String s;
    String t;
    String u;
    String v;
    int cap = 0;
    ArrayList arr = new ArrayList();
    ArrayList<String> coun = new ArrayList();

    public VentaBoletos3(String user, String password, String ID, String IDPe) throws SQLException {
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
        System.out.println(s + t + u + v);
        jPanel2.setLayout(new GridLayout(6, 10));
        jLabel12.setVisible(false);
        jButton1.setVisible(false);

        try {

            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM boletos INNER JOIN funcion ON funcion.IDFuncion = boletos.IDFuncion AND funcion.IDFuncion='" + u + "'");
            ResultSet srm = ps.executeQuery();
            while (srm.next()) {
                String c = srm.getString("asiento");
                coun.add(c);
            }
        } catch (SQLException ex) {

        }

        try {
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM funcion INNER JOIN pelicula ON funcion.IDPelicula = pelicula.IDPelicula AND funcion.IDFuncion='" + u + "'");
            ResultSet sr = ps.executeQuery();
            String fec = "";
            while (sr.next()) {
                String c = sr.getString("sala");
                String w = sr.getString("fecha");
                String q = sr.getString("hora");
                String h = sr.getString("IDFuncion");
                String fecha[] = w.split("-");
                String w2 = fecha[2] + "-" + fecha[1] + "-" + fecha[0];
                jLabel19.setText("");
                jLabel20.setText(c);
                jLabel17.setText(q);
                jLabel9.setText(w2);
                break;
            }
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM pelicula INNER JOIN funcion ON funcion.IDPelicula = pelicula.IDPelicula AND funcion.IDFuncion='" + u + "'");
            ResultSet sre = ps.executeQuery();
            while (sre.next()) {
                String ce = sr.getString("nombre");
                jLabel19.setText(ce);
            }

        } catch (SQLException s) {

        }

        for (int i = 0; i < 60; i++) {
            JButton boton = new JButton();
            boton.setSize(50, 60);
            boton.setVisible(true);
            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            boton.setBackground(new Color(54, 54, 54));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setMinimumSize(new Dimension(45, 60));
            boton.setMaximumSize(new Dimension(45, 60));

            if (i < 10) {
                boton.setToolTipText("A" + (i + 1));
            } else {
                if (i > 9 && i < 20) {
                    boton.setToolTipText("B" + ((i - 10) + 1));
                } else {
                    if (i > 19 && i < 30) {
                        boton.setToolTipText("C" + ((i - 20) + 1));
                    } else {
                        if (i > 29 && i < 40) {
                            boton.setToolTipText("D" + ((i - 30) + 1));
                        } else {
                            if (i > 39 && i < 50) {
                                boton.setToolTipText("E" + ((i - 40) + 1));
                            } else {
                                if (i > 49 && i < 60) {
                                    boton.setToolTipText("F" + ((i - 50) + 1));
                                }
                            }
                        }
                    }
                }
            }

            boton.setPreferredSize(new Dimension(45, 60));
            boton.setIcon(new ImageIcon(getClass().getResource("/Images/Disponible.png")));

            for (int iff = 0; iff < coun.size(); iff++) {
                if (coun.get(iff).equals(boton.getToolTipText())) {
                    boton.setCursor(new Cursor(DEFAULT_CURSOR));
                    boton.setDisabledIcon(new ImageIcon(getClass().getResource("/Images/Ocupado.png")));
                    boton.setEnabled(false);
                }
            }
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (boton.isContentAreaFilled() == false) {
                        if (arr.size() <= 4) {
                            boton.setContentAreaFilled(true);
                            boton.setIcon(new ImageIcon(getClass().getResource("/Images/Seleccion.png")));
                            arr.add(boton.getToolTipText());
                            if (!arr.isEmpty()) {
                                jLabel12.setVisible(true);
                                jButton1.setVisible(true);
                            } else {
                                jLabel12.setVisible(false);
                                jButton1.setVisible(false);
                            }
                        } else {
                            UIManager.put("control", new Color(51, 51, 51));
                            UIManager.put("OptionPane.messageFont", f);
                            UIManager.put("OptionPane.messageForeground", Color.white);
                            UIManager.put("OptionPane.messageIconImage", null);
                            JOptionPane.showMessageDialog(null, "La selección de boletos esta limitada  máximo 5 por compra.");
                        }
                    } else {
                        boton.setContentAreaFilled(false);
                        boton.setIcon(new ImageIcon(getClass().getResource("/Images/Disponible.png")));
                        arr.remove(boton.getToolTipText());
                        if (!arr.isEmpty()) {
                            jLabel12.setVisible(true);
                            jButton1.setVisible(true);
                        } else {
                            jLabel12.setVisible(false);
                            jButton1.setVisible(false);
                        }

                    }

                    System.out.println(arr);

                }

            });
            jPanel2.add(boton);

        }
        jPanel2.updateUI();
    }

    private VentaBoletos3() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(540, 170, 600, 360);

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(319, 370, 140, 40);

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(90, 107, 1010, 40);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Compra de boletos");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(90, 102, 1010, 40);

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Proceder compra");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel12);
        jLabel12.setBounds(160, 475, 150, 30);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sala");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(310, 250, 80, 40);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fecha");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(310, 330, 80, 40);

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ocupado");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(980, 560, 80, 40);

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 255, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(60, 370, 130, 40);

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Película");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(60, 250, 80, 40);

        jLabel19.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 255, 204));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel19);
        jLabel19.setBounds(60, 290, 230, 40);

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 255, 204));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel20);
        jLabel20.setBounds(310, 290, 80, 40);

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Disponible");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(660, 560, 80, 40);

        jLabel22.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Selección");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(820, 560, 80, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Disponible.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(750, 550, 50, 60);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ocupado.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1070, 550, 50, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Seleccion.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(910, 550, 50, 60);

        jLabel23.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Detalles");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(100, 184, 260, 40);

        jLabel24.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Hora");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(40, 330, 80, 40);

        jLabel25.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("A");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(500, 180, 40, 40);

        jLabel26.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("B");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(500, 235, 40, 40);

        jLabel27.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("C");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(500, 300, 40, 40);

        jLabel28.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("D");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(500, 355, 40, 40);

        jLabel29.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("E");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(500, 415, 40, 40);

        jLabel30.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("F");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(500, 475, 40, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarraGrisS.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 468, 290, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boletos.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 80, 1090, 550);

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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        VentaBoletos2 ad;
        try {
            ad = new VentaBoletos2(s, t, v);
            ad.show();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VentaBoletos4 ad;
        try {
            ad = new VentaBoletos4(s, t, u, v, arr);
            ad.show();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(VentaBoletos3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos3.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos3.class
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaBoletos3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
