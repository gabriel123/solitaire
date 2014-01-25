package gabriel_solitaire;

public class Solitaire implements Jeu {
	private Plateau plateau;

	public Solitaire() {
		plateau = new Plateau();
	}

	@Override
	public void jouer() {
		plateau.afficheConsole();

	}

}
