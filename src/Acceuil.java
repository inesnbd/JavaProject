import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Acceuil extends JFrame {
	private static final long serialVersionUID = 1L;

	public Acceuil() {
		setTitle("application java supermarché");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		addWindowListener(l);
		setSize(427, 285);
		setLocationRelativeTo(null);

		JButton btnNewButton_1_1_1 = new JButton("Produit laitier");
		btnNewButton_1_1_1.setBounds(154, 51, 100, 28);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new produitlaitier().setVisible(true);
			}
		});
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenue chez casino");
		lblNewLabel.setBounds(6, 11, 399, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton_1_1 = new JButton("Fruit");
		btnNewButton_1_1.setBounds(154, 81, 100, 28);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new fruit().setVisible(true);
			}
		});

		JButton btnNewButton = new JButton("Legume");
		btnNewButton.setBounds(154, 110, 100, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new legume().setVisible(true); 
			}
		});
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1_1);
		getContentPane().add(btnNewButton_1_1_1);

		JButton btnNewButton_1 = new JButton("Viande");
		btnNewButton_1.setBounds(154, 141, 100, 28);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new viande().setVisible(true);
			}
		});
		getContentPane().add(btnNewButton_1);

		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JFrame Acceuil = new Acceuil();
	}
}