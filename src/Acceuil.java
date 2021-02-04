import javax.swing.*;
import java.awt.event.*;

public class Acceuil extends JFrame {
	private static final long serialVersionUID = 1L;

	public Acceuil() {
      super("titre de l'application");

      WindowListener l = new WindowAdapter() {
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      };

      addWindowListener(l);
      setSize(200,100);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String [] args){
      JFrame frame = new Acceuil();
   }
}