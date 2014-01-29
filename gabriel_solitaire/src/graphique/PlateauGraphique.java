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

		for (int y = 0; y < plateau.getPlateau().length; ++y) {
			for (int x = 0; x < plateau.getPlateau()[y].length; ++x) {

				// On recupere chaque case de notre plateau et on les creer en
				// graphique avec des boutons qu'on marque differement si la
				// case est libre ou pas.
				// Si c'est une case interdite, on ne marque pas la case.

				Case cellule = plateau.getCase(y, x);
				if (cellule != null) {

					cases[y][x] = new CaseGraphique(plateau, y, x, cases);
					if (cellule.libre()) {
						cases[y][x].setText("0");
					} else {
						cases[y][x].setText("X");
					}
					getContentPane().add(cases[y][x]);
				} else {
					getContentPane().add(
							new CaseGraphique(plateau, y, x, cases));
				}
			}
		}
	}
}
