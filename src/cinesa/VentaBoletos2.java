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
public class VentaBoletos2 extends javax.swing.JFrame {

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

    public VentaBoletos2(String user, String password, String ID) throws SQLException {
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

        jPanel2.setLayout(new FlowLayout(10, 20, 5));

        try {
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM pelicula WHERE IDPelicula='" + u + "'");
            ResultSet sr = ps.executeQuery();
            while (sr.next()) {
                String c = sr.getString("nombre");
                String w = sr.getString("descripcion");
                String q = sr.getString("duracion");
                String h = sr.getString("fechaLanzamiento");
                String j = sr.getString("clasificacion");
                String se = sr.getString("ruta");
                se = se.replace('´', '\\');
                String e = sr.getString("genero");
                jLabel9.setText(c);
                jLabel15.setText(h);
                jLabel16.setText(q);
                jLabel17.setText(j);
                jLabel10.setText(e);
                jLabel11.setText("<html>" + w + "<html>");
                Image im = new ImageIcon(se).getImage();
                ImageIcon ic = new ImageIcon(im.getScaledInstance(180, 250, Image.SCALE_SMOOTH));
                jLabel2.setIcon(ic);
                break;
            }
        } catch (SQLException e) {

        }

        try {
            //ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM funcion INNER JOIN pelicula ON funcion.IDPelicula = pelicula.IDPelicula AND pelicula.IDPelicula='" + u + "' ORDER BY funcion.fecha");
            ps = (PreparedStatement) con.getConect().prepareStatement("SELECT * FROM funcion INNER JOIN pelicula ON funcion.IDPelicula = pelicula.IDPelicula WHERE pelicula.IDPelicula = '" + u + "' AND CONCAT(funcion.fecha, ' ', funcion.hora) >= NOW() ORDER BY funcion.fecha, funcion.hora");

            ResultSet sr = ps.executeQuery();
            String fec = "";
            while (sr.next()) {
                String c = sr.getString("sala");
                String w = sr.getString("fecha");
                String q = sr.getString("hora");
                String h = sr.getString("IDFuncion");
                String fecha[] = w.split("-");
                String w2 = fecha[2] + "-" + fecha[1] + "-" + fecha[0];
                JLabel label = new JLabel();
                label.setText(w2);
                label.setFont(f);
                label.setForeground(new Color(252, 252, 252));
                jPanel2.add(label);
                JButton boton = new JButton();

                boton.setSize(180, 40);
                boton.setVisible(true);
                boton.setOpaque(false);
                boton.setBorderPainted(false);
                boton.setBackground(new Color(252, 252, 252));
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                boton.setMinimumSize(new Dimension(180, 40));
                boton.setMaximumSize(new Dimension(180, 40));
                boton.setPreferredSize(new Dimension(180, 40));
                boton.setHorizontalTextPosition(2);

                boton.setVerticalTextPosition(1);
                boton.setVerticalAlignment(1);
                boton.setText(q);
                boton.setFont(f);
                boton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        VentaBoletos3 ad;
                        try {
                            ad = new VentaBoletos3(s, t, h, u);
                            ad.show();
                            dispose();
                        } catch (Exception ex) {
                            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                jPanel2.add(boton);
            }

            jPanel2.updateUI();

        } catch (SQLException ex) {

        }
    }

    private VentaBoletos2() {

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
        jPanel1 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Menú de operaciones");

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

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(935, 210, 140, 40);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 184, 180, 250);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 255, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(320, 300, 790, 140);

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Duración");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(560, 170, 110, 40);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Clasificación");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(730, 170, 150, 40);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Género");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(960, 170, 90, 40);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 204));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(347, 210, 140, 40);

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 255, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(545, 210, 140, 40);

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 255, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(735, 210, 140, 40);

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Fecha de estreno");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(330, 170, 170, 40);

        jLabel19.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Sinópsis");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(320, 260, 790, 40);

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Funciones");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(90, 470, 1010, 40);

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(90, 107, 1010, 40);

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/InfoPeli.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 80, 1080, 460);

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 540, 1050, 90);

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

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        VentaBoletos ad;
        try {
            ad = new VentaBoletos(s, t);
            ad.show();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(VentaBoletos2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaBoletos2.class
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaBoletos2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
