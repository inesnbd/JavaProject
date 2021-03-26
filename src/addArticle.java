import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

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
		getContentPane().add(lblNewLabel);
		
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
				Random random = new Random();
				int nb;
				nb = random.nextInt(999);
				String Description= "";
				Float prix2 = random.nextFloat();
				int prix = random.nextInt(100);	
				Float Prix = prix + prix2 ;
				int prixHT = 15;
				String intitule = libelleProduit.getText();
				int quantiteEnstock = (Integer) spinner.getValue();
				String reference = comboBox.getSelectedItem().toString();
				new Article(reference, intitule, prixHT, quantiteEnstock);
				
				System.out.println(spinner.getValue());
				
				String url ="jdbc:mysql://localhost:3306/super_march�";
				String login = "root";
				String passwd = "root";
				Connection cn = null;
				Statement st =null;
				ResultSet rs =null;
				try {
					//Etape 1 : Chargement du driver 
					Class.forName("org.gjt.mm.mysql.Driver");
					//Etape 2 : récupération de la connection
					cn = DriverManager.getConnection(url,login,passwd);
					//Etape 3 : Création d'un statement 
					st = cn.createStatement();
					// Etape 4 éxécution requête
					if (comboBox.getSelectedIndex()==0){  					
						String sql = "INSERT INTO fruits VALUES ('"+nb+"','"+libelleProduit.getText()+"','"+Description+"','"+Prix+"','"+spinner.getValue()+"')";
						st.executeUpdate(sql);
					}else if (comboBox.getSelectedIndex()==1) {
						String sql = "INSERT INTO legumes VALUES ('"+nb+"','"+libelleProduit.getText()+"','"+Description+"','"+Prix+"','"+spinner.getValue()+"')";
						st.executeUpdate(sql);
					}else if (comboBox.getSelectedIndex()==2) {
						String sql = "INSERT INTO produitlaitiers VALUES ('"+nb+"','"+libelleProduit.getText()+"','"+Description+"','"+Prix+"','"+spinner.getValue()+"')";
						st.executeUpdate(sql);
					}else {
						String sql = "INSERT INTO viandes VALUES ('"+nb+"','"+libelleProduit.getText()+"','"+Description+"','"+Prix+"','"+spinner.getValue()+"')";
						st.executeUpdate(sql);
					}
					
				}catch (SQLException exc1) {
					exc1.printStackTrace();					
				}catch (ClassNotFoundException exc1) {
					exc1.printStackTrace();
				}finally {
					try {
						//Etape 5 : libérer ressources de la mémoire.
						cn.close();
						st.close();
					}catch(SQLException exc1) {
						exc1.printStackTrace();
					}
				
				}
			}
		});
		
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
