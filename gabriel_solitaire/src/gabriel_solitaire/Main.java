package gabriel_solitaire;

public class Main {

	public static void main(String[] args) {
		//cr�� un nouvel objet solitaire implementant l'interface jeu
		Jeu solitaire = new Solitaire();
		
		solitaire.jouer();
	}

}
