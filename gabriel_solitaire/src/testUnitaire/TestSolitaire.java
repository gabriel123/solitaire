package testUnitaire;

import gabriel_solitaire.Plateau;
import graphique.PlateauGraphique;

import org.junit.Test;

public class TestSolitaire {

	@Test
	public void sortieDuPlateau() {
		Plateau plateau = new Plateau();

		try {
			plateau.getCase(100000, 0);
			plateau.getCase(0, 100000);
			plateau.getCase(10000, 10000);
		} catch (IllegalArgumentException e) {

		}

	}

	@Test
	public void voirPlateau() {
		Plateau plateau = new Plateau();
		PlateauGraphique plateauGraphique = new PlateauGraphique(plateau);
		plateauGraphique.setVisible(true);

	}

	@Test
	public void voirPlateauConsole() {
		Plateau plateau = new Plateau();
		plateau.afficheConsole();
	}
}
