package cinesa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Hora extends Thread {

    public JLabel getTexto() {
        return texto;
    }

    public void setTexto(JLabel texto) {
        this.texto = texto;
    }
    private JLabel texto;

    public void run() {
        while (true) {
            String timeStamp = new SimpleDateFormat("dd/MM/YYYY                HH:mm:ss").format(Calendar.getInstance().getTime());
            texto.setText(timeStamp);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
