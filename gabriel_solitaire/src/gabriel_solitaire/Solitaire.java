package gabriel_solitaire;

import graphique.PlateauGraphique;

public class Solitaire implements Jeu {
	private Plateau plateau;
	private PlateauGraphique graphique;

	public Solitaire() {
		plateau = new Plateau();
		graphique = new PlateauGraphique(plateau);
	}

	@Override
	public void jouer() {

		graphique.setVisible(true);
	}

}
