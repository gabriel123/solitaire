package graphique;

import gabriel_solitaire.Case;
import gabriel_solitaire.Direction;
import gabriel_solitaire.Plateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class CaseGraphique extends JButton {

	private Plateau plateau;

	// Lorsqu'on appuie sur X, on enregistre les touches du
	// clavier et si c'est une fleche, on agit, sinon on fait
	// rien.
	// Ensuite, on arrete d'enregistrer.
	private KeyListener enregistreurClavier = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent key) {
		}

		@Override
		public void keyReleased(KeyEvent key) {
			int keyPressed = key.getKeyCode();

			// On recupere la direction

			Direction direction;
			switch (keyPressed) {
			case KeyEvent.VK_LEFT:
				direction = Direction.Gauche;
				break;
			case KeyEvent.VK_RIGHT:
				direction = Direction.Droite;
				break;
			case KeyEvent.VK_UP:
				direction = Direction.Haut;
				break;
			case KeyEvent.VK_DOWN:
				direction = Direction.Bas;
				break;
			default:
				System.out.println(key.getKeyCode() + ": mauvaise touche !");
				// On arrete l'enregistrement.
				removeKeyListener(this);
				return;
			}

			Case actuelle = plateau.getCase(x, y);
			System.out.println(actuelle.getPion().peutBouger(direction));
			if (actuelle.getPion().peutBouger(direction)) {

			} else {
				System.out.println("Déplacement impossible !");
			}

			// On arrete l'enregistrement
			removeKeyListener(this);
		}

		@Override
		public void keyPressed(KeyEvent key) {
		}
	};

	private final int x, y;

	public CaseGraphique(Plateau plateau, final int x, final int y) {
		this.plateau = plateau;
		this.x = x;
		this.y = y;

		setSize(20, 20);

		// On ajoute une action qui sera realise lorsqu'on clique sur une case
		// L'action depend du type de la case ("0", "X" ou "")
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String typeDeCase = getText();
				System.out.println(x + " " + y);
				if (typeDeCase == "0") {

				} else if (typeDeCase == "X") {
					System.out
							.println("Selectionner la direction via le clavier");

					// Lorsqu'on appuie sur X, on enregistre les touches du
					// clavier et si c'est une fleche, on agit, sinon on fait
					// rien.
					// Ensuite, on arrete d'enregistrer.

					addKeyListener(enregistreurClavier);
				} else {
					System.out.println("Mauvaise case !");
				}
			}
		});
	}
}
