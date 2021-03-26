import javax.swing.*;
import java.awt.event.*;
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
import java.util.Random;
import com.mysql.jdbc.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class viande extends JFrame {

	private JPanel contentPane;

	/* Launch the application.*/
	public static void main(String[] args) {
		JFrame viande = new viande();
	}

	/* Create the frame. */
	
	public viande() {
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

		JLabel lblNewLabel = new JLabel("Rayon Viande");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 158, 14);
		getContentPane().add(lblNewLabel);
		
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
			
			String[] titre = {"id","viande","descrptions","prix ","quantites"}; // on creer nos colonnes du tableau
		      String data[][] = new String[10][5];
		    
		      int i = 0;
		      while (rs.next()) {
		        int id = rs.getInt("id");
		        String nom = rs.getString("viande");
		        String age = rs.getString("description");
		        float prix = rs.getFloat("prix");
		        int quantites = rs.getInt("quantites");
		        data[i][0] = id + "";
		        data[i][1] = nom;
		        data[i][2] = age;
		        data[i][3] = prix+"";
		        data[i][4] = quantites+"";
		        i++;
		      }

		JTable table = new JTable(data,titre);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(54, 58, 325, 87);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		table.getColumnModel().getColumn(3).setMaxWidth(45);
		table.getColumnModel().getColumn(4).setMaxWidth(40);
		
		getContentPane().add(table);
	
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

}
