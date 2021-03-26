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

public class addArticle extends JFrame {
	
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
		JFrame addArticle = new addArticle();
	}

	/**
	 * Create the frame.
	 */
	public addArticle() {
		setTitle("application java supermarch�");

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
		
		JLabel LabelCategorie = new JLabel("Cat\u00E9gorie Produit :");
		LabelCategorie.setBounds(56, 106, 118, 14);
		
		String[] listCategorie = { "fruits", "legumes", "produits laitiers", "viandes" };
		JComboBox comboBox = new JComboBox(listCategorie);
		comboBox.setBounds(184, 102, 118, 22);
		comboBox.setSelectedIndex(0);
		
		JLabel lblNewLabel_1 = new JLabel("Quantit\u00E9 :");
		lblNewLabel_1.setBounds(56, 146, 90, 14);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(184, 143, 118, 20);
		
		JButton Ajouter = new JButton("AJOUTER");
		Ajouter.setBounds(153, 189, 89, 23);
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prixHT = 15;
				String intitule = libelleProduit.getText();
				int quantiteEnstock = (Integer) spinner.getValue();
				String reference = comboBox.getSelectedItem().toString();
				new Article(reference, intitule, prixHT, quantiteEnstock);
				//setVisible(false);
		        //new Acceuil().setVisible(true);
			}
		});
		
		getContentPane().add(lblNewLabel);
		getContentPane().add(LabelProduit);
		getContentPane().add(libelleProduit);
		getContentPane().add(LabelCategorie);
		getContentPane().add(comboBox);
		getContentPane().add(Ajouter);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(spinner);
		
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
