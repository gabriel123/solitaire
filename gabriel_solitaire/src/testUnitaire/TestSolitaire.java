package testUnitaire;

import gabriel_solitaire.Plateau;

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

}
