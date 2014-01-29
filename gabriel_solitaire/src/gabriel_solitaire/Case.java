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
	public Case(Plateau plateau, int y, int x) {
		pion = new Pion(plateau, y, x);
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

}
