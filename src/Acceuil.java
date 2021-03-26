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
import java.awt.Font;
import java.awt.Color;

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
		
		JLabel Title = new JLabel("Bienvenue chez casino");
		Title.setBounds(6, 11, 399, 16);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Title);

		JButton ButtonLAit = new JButton("Produit laitier");
		ButtonLAit.setBounds(154, 51, 100, 28);
		ButtonLAit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new produitlaitier().setVisible(true);
			}
		});
		getContentPane().setLayout(null);

		JButton ButtonFruit = new JButton("Fruit");
		ButtonFruit.setBounds(154, 81, 100, 28);
		ButtonFruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new fruit().setVisible(true);
			}
		});

		JButton ButtonLegume = new JButton("Legume");
		ButtonLegume.setBounds(154, 110, 100, 28);
		ButtonLegume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new legume().setVisible(true); 
			}
		});
		
		JButton ButtonViande = new JButton("Viande");
		ButtonViande.setBounds(154, 141, 100, 28);
		ButtonViande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new viande().setVisible(true);
			}
		});
		
		JButton BouttonAdd = new JButton("Ajouter Produit");
		BouttonAdd.setForeground(Color.WHITE);
		BouttonAdd.setBackground(Color.BLUE);
		BouttonAdd.setFont(UIManager.getFont("Button.font"));
		BouttonAdd.setBounds(136, 170, 136, 28);
		BouttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new addArticle().setVisible(true);
			}
		});
		
		JButton BouttonModif = new JButton("Modifier Produit");
		BouttonModif.setForeground(Color.WHITE);
		BouttonModif.setBackground(Color.BLUE);
		BouttonModif.setFont(UIManager.getFont("Button.font"));
		BouttonModif.setBounds(136, 200, 136, 28);
		BouttonModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		        new modifArticle().setVisible(true);
			}
		});
		
		getContentPane().add(ButtonLegume);
		getContentPane().add(ButtonFruit);
		getContentPane().add(ButtonLAit);
		getContentPane().add(ButtonViande);
		getContentPane().add(BouttonAdd);
		getContentPane().add(BouttonModif);

		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JFrame Acceuil = new Acceuil();
	}
}