package graphique;

import gabriel_solitaire.Case;
import gabriel_solitaire.Plateau;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class PlateauGraphique extends JFrame {

	private Plateau plateau;
	private CaseGraphique[][] cases;

	public PlateauGraphique(Plateau plateau) {
		super();
		this.plateau = plateau;

		setTitle("Solitaire de Gabriel");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// On utilise un GridLayout pour creer une grille de plateau
		getContentPane().setLayout(new GridLayout(7, 7));
		cases = new CaseGraphique[7][7];

		for (int x = 0; x < plateau.getPlateau().length; ++x) {
			for (int y = 0; y < plateau.getPlateau()[x].length; ++y) {

				// On recupere chaque case de notre plateau et on les creer en
				// graphique avec des boutons qu'on marque differement si la
				// case est libre ou pas.
				// Si c'est une case interdite, on ne marque pas la case.

				Case cellule = plateau.getCase(x, y);
				if (cellule != null) {
					cases[x][y] = new CaseGraphique(plateau, x, y);
					if (cellule.libre()) {
						cases[x][y].setText("0");
					} else {
						cases[x][y].setText("X");
					}
					getContentPane().add(cases[x][y]);
				} else {
					getContentPane().add(new CaseGraphique(plateau, x, y));
				}
			}
		}
	}
}
