package gabriel_solitaire;

public class Case {
	private Pion pion;
	private int x, y;
	private boolean estLibre = false;

	/**
	 * le constructeur initialise le pion en lui donnant le plateau
	 * 
	 * @param plateau
	 */
	public Case(Plateau plateau, int x, int y) {
		pion = new Pion(plateau, x, y);
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @return la case est pleine par default
	 */
	public boolean libre() {
		return estLibre;
	}

	public void setLibre(boolean libre) {
		estLibre = libre;
	}

	public Pion getPion() {
		return pion;
	}

	public void setPion(Pion pion) {
		this.pion = pion;
	}

}
