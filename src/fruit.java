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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.ResultSet;

public class fruit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame fruit = new fruit();
	}

	/**
	 * Create the frame.
	 */
	public fruit() {
		
		String url ="jdbc:mysql://localhost:3306/formation";
		String login = "aldrick";
		String passwd = "1234";
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
			String sql = "SELECT * FROM users";
			
			// Etape 4 éxécution requête
			rs=(ResultSet) st.executeQuery(sql);
			
			String columns[] = { "ID", "Nom", "Age" };
		      String data[][] = new String[15][3];
		        
		      int i = 0;
		      while (rs.next()) {
		        int id = rs.getInt("id");
		        String nom = rs.getString("nom");
		        String age = rs.getString("age");
		        data[i][0] = id + "";
		        data[i][1] = nom;
		        data[i][2] = age;
		        i++;
		      }
		    
		      setTitle("application java supermarch�");

				WindowListener l = new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				};

				addWindowListener(l);
				setSize(500, 300);
				setLocationRelativeTo(null);
				getContentPane().setLayout(null);

				JLabel lblNewLabel = new JLabel("Rayon Fruit");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(121, 11, 158, 14);
				getContentPane().add(lblNewLabel);
				
				//DefaultListModel listProduit = new DefaultListModel();
				//JList list = new JList(listProduit);
				//listProduit.addElement("melon");
				//listProduit.addElement("fraise");
				//listProduit.addElement("orange");
				//listProduit.addElement("...");
				//DefaultListModel listProduit = new DefaultListModel();	
				//JList list = new JList(data);
				//list.setBounds(68, 45, 278, 141);
				DefaultTableModel model = new DefaultTableModel(data, columns);
			      JTable table = new JTable(model);
			      table.setShowGrid(true);
			      table.setShowVerticalLines(true);
			      JScrollPane pane = new JScrollPane(table);
				getContentPane().add(pane);
				
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
	}
}
