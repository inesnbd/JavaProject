import javax.swing.*;
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
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.*;

public class legume extends JFrame {
	
	private JPanel contentPane;

	/* Launch the application.*/
	public static void main(String[] args) {
		JFrame legume = new legume();
	}

	/* Create the frame. */	
	public legume() {
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

		JLabel lblNewLabel = new JLabel("Rayon Legumes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 158, 14);
		getContentPane().add(lblNewLabel);
		
		String[] titre = {"id","legumes","descrptions","prix ","quantites"}; // on creer nos colonnes du tableau
		
		// tableau a deux dimensions
			Object[][] data = {		
		// on ajoute les infos du tableau en suivant le titre des colonnes
				{1, "courgettes","bio", "2,39", "60"}, 
				{2, "carottes", "d'Espagne", "1,67", "35"},
				{3, "oignons", "du jardin", "1,15", "50"},
			};
		JTable table = new JTable(data,titre);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(54, 58, 325, 87);
		//table.getRootPane().add(table.getTableHeader(), BorderLayout.NORTH); // permet dajouter le titre en haut
		
		getContentPane().add(table);
		
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