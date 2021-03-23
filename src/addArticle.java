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

public class addArticle extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	long reference ;
	String intitule;
	float prixHT;
	int quantiteEnstock;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame addArticle = new addArticle();
	}

	/**
	 * Create the frame.
	 */
	public addArticle() {
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
		
		JLabel lblNewLabel = new JLabel("Ajouter un produit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 158, 14);
		
		JLabel LabelProduit = new JLabel("Nom Produit :");
		LabelProduit.setBounds(56, 64, 90, 14);
		
		JTextField libelleProduit = new JTextField();
		libelleProduit.setBounds(184, 61, 118, 20);
		libelleProduit.setColumns(10);
		String intitule = libelleProduit.getText();
		
		JLabel LabelCategorie = new JLabel("Cat\u00E9gorie Produit :");
		LabelCategorie.setBounds(56, 106, 118, 14);
		
		String[] listCategorie = { "fruit", "legume", "produit laitier", "viande" };
		JComboBox comboBox = new JComboBox(listCategorie);
		comboBox.setBounds(184, 102, 118, 22);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = comboBox.getSelectedItem().toString();
			}
		});
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Quantit\u00E9 :");
		lblNewLabel_1.setBounds(56, 146, 90, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 143, 118, 20);
		textField_1.setColumns(10);
		int quantiteEnstock = Integer.parseInt(textField_1.getText());
		
		JButton Ajouter = new JButton("AJOUTER");
		Ajouter.setBounds(153, 189, 89, 23);
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prixHT = 15;
				new Article(reference, intitule, prixHT, quantiteEnstock);
				setVisible(false);
		        new Acceuil().setVisible(true);
			}
		});
		
		getContentPane().add(lblNewLabel);
		getContentPane().add(LabelProduit);
		getContentPane().add(libelleProduit);
		getContentPane().add(LabelCategorie);
		getContentPane().add(comboBox);
		getContentPane().add(Ajouter);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(textField_1);
		
		

		setVisible(true);
	}

}
