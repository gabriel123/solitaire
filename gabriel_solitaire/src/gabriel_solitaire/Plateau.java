package gabriel_solitaire;

public class Plateau {
	private Case[][] plateau;

	// on parcoure toutes les cases du tableaux et on les initialise
	public Plateau() {
		plateau = new Case[7][7];
		for (int i = 0; i < plateau.length; ++i)
			for (int j = 0; j < plateau[i].length; ++j) {

				// ici this est le plateau donc je donne a la case le plateau
				plateau[i][j] = new Case(this, i, j);
			}
		// on retire les mauvaises cases (partie haute)
		plateau[0][0] = null;
		plateau[0][1] = null;
		plateau[1][0] = null;
		plateau[1][1] = null;
		plateau[0][5] = null;
		plateau[0][6] = null;
		plateau[1][5] = null;
		plateau[1][6] = null;
		// partie basse
		plateau[5][0] = null;
		plateau[6][0] = null;
		plateau[5][1] = null;
		plateau[6][1] = null;
		plateau[5][5] = null;
		plateau[5][6] = null;
		plateau[6][5] = null;
		plateau[6][6] = null;

		// On dit quelle case est libre
		plateau[3][3].setLibre(true);

	}

	public Case[][] getPlateau() {
		return plateau;
	}

	/**
	 * parcoure le plateau en faisant attention aux cases interdites et affiche
	 * le plateau
	 */
	public void afficheConsole() {
		for (int i = 0; i < plateau.length; ++i) {
			Case[] ligne = plateau[i];

			for (int j = 0; j < ligne.length; ++j) {
				Case cellule = plateau[i][j];

				if (cellule == null) {
					System.out.print(" ");
				} else if (cellule.libre()) {
					System.out.print("0");
				} else {
					System.out.print("X");
				}

			}
			System.out.println();
		}

	}

	/**
	 * Retourne la case a la position (x, y) Si les valeurs de x et y sont
	 * incorects, envoie une exception.
	 * 
	 * @param x
	 * @param y
	 * @return la case a la bonne position
	 * @throws IllegalArgumentException
	 *             envoyee lorsque les valeurs sont incorrects (depasse le
	 *             plateau)
	 */
	public Case getCase(int y, int x) throws IllegalArgumentException {
		if (x < 0 || x >= plateau.length) {
			throw new IllegalArgumentException();
		}
		if (y < 0 || y >= plateau.length) {
			throw new IllegalArgumentException();
		}
		return plateau[y][x];
	}

	/**
	 * renvoit la case par rapport a la direction de la case selectionnée
	 * 
	 * @param y
	 * @param x
	 * @param direction
	 * @return
	 */
	public Case getCaseAvecDirection(int y, int x, Direction direction) {
		switch (direction) {
		case Bas:
			return plateau[y + 1][x];
		case Droite:
			return plateau[y][x + 1];
		case Gauche:
			return plateau[y][x - 1];
		case Haut:
			return plateau[y - 1][x];
		}
		return null;
	}
}
