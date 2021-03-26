import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
import javax.swing.JTable;

public class modifArticle extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	String reference ;
	String intitule;
	float prixHT;
	int quantiteEnstock;
	DefaultListModel demoList = new DefaultListModel();
	DefaultListModel list2 = new DefaultListModel();

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
		setTitle("application java supermarch�");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		
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
			String sql = "SELECT * FROM viandes";
			
			// Etape 4 éxécution requête
			rs=(ResultSet) st.executeQuery(sql);
		    
		      int i = 0;
		      while (rs.next()) {
		    	  String nom = rs.getString("viande");
		    	  String age = rs.getString("description");
		    	  int id = rs.getInt("id");
		    	  demoList.addElement("id: "+id+" nom: "+nom +" description :"+age);
		      }
		      JList listd = new JList(demoList);
		      listd.setBounds(33, 48, 141, 128);
		      getContentPane().add(listd);
				
	
		}catch (SQLException e) {
			e.printStackTrace();					
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				//Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}
		
		}
		cn = null;
		st =null;
		rs =null;
		try {
			//Etape 1 : Chargement du driver 
			Class.forName("org.gjt.mm.mysql.Driver");
			
			//Etape 2 : récupération de la connection
			cn = DriverManager.getConnection(url,login,passwd);
			
			//Etape 3 : Création d'un statement 
			st = cn.createStatement();
			String sql = "SELECT * FROM fruits";
			
			// Etape 4 éxécution requête
			rs=(ResultSet) st.executeQuery(sql);
		    
		      int i = 0;
		      while (rs.next()) {
		    	  int id = rs.getInt("id");
			        String nom = rs.getString("fruit");
			        String age = rs.getString("description");
		    	  list2.addElement("id: "+id+" nom: "+nom +" description :"+age);
		      }
		      JList list_1 = new JList();
		      list_1.setBounds(224, 48, 118, 128);
			  getContentPane().add(list_1);
	
		}catch (SQLException e) {
			e.printStackTrace();					
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				//Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}
		
		}

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
		//getContentPane().add(list);
		
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
