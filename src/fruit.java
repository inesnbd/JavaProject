import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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

		JLabel lblNewLabel = new JLabel("Rayon Fruit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 158, 14);
		getContentPane().add(lblNewLabel);
		
		DefaultListModel listProduit = new DefaultListModel();
		JList list = new JList(listProduit);
		listProduit.addElement("melon");
		listProduit.addElement("fraise");
		listProduit.addElement("orange");
		listProduit.addElement("...");
		list.setBounds(68, 45, 278, 141);
		getContentPane().add(list);
		
		

		setVisible(true);
	}

}
