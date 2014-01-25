package gabriel_solitaire;

public class Pion {

	private Plateau plateau;
	private int x;

	private int y;

	/**
	 * je recupere le plateau pour que le pion puisse avoir acces au cases
	 * adjacentes
	 * 
	 * @param plateau
	 */
	public Pion(Plateau plateau, int x, int y) {
		this.plateau = plateau;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	/**
	 * grace a l'enum
	 * 
	 * @param direction
	 * @return
	 */
	// recupere la case recherchée
	public boolean peutBouger(Direction direction) {
		Case caseIntermediaire = null;
		Case caseVoulu = null;

		// Ici on recupere la caseVoulu grace a la direction
		try {
			switch (direction) {
			case Bas:
				caseIntermediaire = plateau.getCase(x, y - 1);
				break;
			case Haut:
				caseIntermediaire = plateau.getCase(x, y + 1);
				break;
			case Droite:
				caseIntermediaire = plateau.getCase(x + 1, y);
				break;
			case Gauche:
				caseIntermediaire = plateau.getCase(x - 1, y);
				break;
			}

			int xSuivant = caseIntermediaire.getPion().getX();
			int ySuivant = caseIntermediaire.getPion().getY();

			switch (direction) {
			case Bas:
				caseVoulu = plateau.getCase(xSuivant, ySuivant - 1);
				break;
			case Haut:
				caseVoulu = plateau.getCase(xSuivant, ySuivant + 1);
				break;
			case Droite:
				caseVoulu = plateau.getCase(xSuivant + 1, ySuivant);
				break;
			case Gauche:
				caseVoulu = plateau.getCase(xSuivant - 1, ySuivant);
				break;
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Mauvais mouvement");
		}

		return caseVoulu.libre();
	}
}
