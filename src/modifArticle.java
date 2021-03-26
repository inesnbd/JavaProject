import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;

public class modifArticle extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	String reference ;
	String intitule;
	float prixHT;
	int quantiteEnstock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame addArticle = new modifArticle();
	}

	/**
	 * Create the frame.
	 */
	public modifArticle() {
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
		
		JLabel lblNewLabel = new JLabel("Modifier un produit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 158, 14);
		getContentPane().add(lblNewLabel);
		
		String[] listProduit = { "produit 1", "produit 2", "produit 3", "produit 4" };
		JList list = new JList(listProduit);
		list.setBounds(62, 48, 274, 128);
		
		JButton Modifier = new JButton("MODIFIER");
		Modifier.setBounds(105, 189, 89, 23);
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String) list.getSelectedValue();
				//System.out.print(selectedValue);
			}
		});
		
		JButton Supprimer = new JButton("SUPPRIMER");
		Supprimer.setBounds(205, 189, 89, 23);
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String) list.getSelectedValue();
			}
		});
		
		getContentPane().add(Modifier);
		getContentPane().add(Supprimer);
		getContentPane().add(list);
		
		JButton ButtonRetour = new JButton("Retour");
		ButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new Acceuil().setVisible(true);
			}
		});
		ButtonRetour.setBounds(153, 212, 89, 23);
		getContentPane().add(ButtonRetour);
		
		
		

		setVisible(true);
	}
}
