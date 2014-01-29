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
	public Pion(Plateau plateau, int y, int x) {
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
				caseIntermediaire = plateau.getCase(y + 1, x);
				break;
			case Haut:
				caseIntermediaire = plateau.getCase(y - 1, x);
				break;
			case Droite:
				caseIntermediaire = plateau.getCase(y, x + 1);
				break;
			case Gauche:
				caseIntermediaire = plateau.getCase(y, x - 1);
				break;
			}

			int xSuivant = caseIntermediaire.getPion().getX();
			int ySuivant = caseIntermediaire.getPion().getY();

			switch (direction) {
			case Bas:
				caseVoulu = plateau.getCase(ySuivant + 1, xSuivant);
				break;
			case Haut:
				caseVoulu = plateau.getCase(ySuivant - 1, xSuivant);
				break;
			case Droite:
				caseVoulu = plateau.getCase(ySuivant, xSuivant + 1);
				break;
			case Gauche:
				caseVoulu = plateau.getCase(ySuivant, xSuivant - 1);
				break;
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Mauvais mouvement");
			return false;
		}

		return caseVoulu.libre();
	}
}
