import javax.swing.*;
import java.awt.event.*;

public class legume extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public legume() {
		setTitle("application java supermarché");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		addWindowListener(l);
		setSize(427, 285);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Rayon Legume");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 158, 14);
		getContentPane().add(lblNewLabel);
		
		DefaultListModel listProduit = new DefaultListModel();
		JList list = new JList(listProduit);
		listProduit.addElement("courgette");
		listProduit.addElement("salade");
		listProduit.addElement("epinard");
		listProduit.addElement("pomme de terre");
		list.setBounds(68, 45, 278, 141);
		getContentPane().add(list);
		
		JButton ButtonRetour = new JButton("Retour");
		ButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new Acceuil().setVisible(true);
			}
		});
		ButtonRetour.setBounds(155, 197, 89, 23);
		getContentPane().add(ButtonRetour);
		
		

		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame frame = new legume();
	}
}