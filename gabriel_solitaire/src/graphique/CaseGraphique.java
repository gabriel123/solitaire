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

			Case actuelle = plateau.getCase(y, x);

			if (actuelle.getPion().peutBouger(direction)) {
				// recupere la case avec le pion a supprimé
				Case aenlever = plateau.getCaseAvecDirection(y, x, direction);
				// on enleve le pion
				aenlever.setPion(null);
				// la case est vide
				aenlever.setLibre(true);
				// on enleve le pion graphiquement
				cases[aenlever.getY()][aenlever.getX()].setText("0");

				// +1 de la case que tu a mangé
				Case nouvelleCase = plateau.getCaseAvecDirection(
						aenlever.getY(), aenlever.getX(), direction);
				// je mets le pion sur sa nouvelle case
				nouvelleCase.setPion(actuelle.getPion());
				// la case est occupée
				nouvelleCase.setLibre(false);
				nouvelleCase.getPion().setX(nouvelleCase.getX());
				nouvelleCase.getPion().setY(nouvelleCase.getY());
				cases[nouvelleCase.getY()][nouvelleCase.getX()].setText("X");

				// on dit que la case est libre a présent
				actuelle.setPion(null);
				actuelle.setLibre(true);
				cases[actuelle.getY()][actuelle.getX()].setText("0");

				System.out.println("Pion mangé à la case (" + aenlever.getX()
						+ "," + aenlever.getY() + ")");

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

	private int x, y;
	private CaseGraphique cases[][];

	public CaseGraphique(Plateau plateau, int y, int x, CaseGraphique cases[][]) {
		this.plateau = plateau;
		this.x = x;
		this.y = y;
		this.cases = cases;

		setSize(20, 20);

		// On ajoute une action qui sera realise lorsqu'on clique sur une case
		// L'action depend du type de la case ("0", "X" ou "")
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String typeDeCase = getText();

				if (typeDeCase == "0") {

				} else if (typeDeCase == "X") {
					System.out
							.println("Selectionner la direction via le clavier");

					// Lorsqu'on appuie sur X, on enregistre les touches du
					// clavier et si c'est une fleche, on agit, sinon on fait
					// rien.
					// Ensuite, on arrete d'enregistrer.
					if (getKeyListeners().length == 0) {
						addKeyListener(enregistreurClavier); // permet d'écouter
																// le clavier
					}
				} else {
					System.out.println("Mauvaise case !");
				}
			}
		});
	}
}
