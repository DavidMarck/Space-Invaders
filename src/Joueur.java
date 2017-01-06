
public class Joueur {

	private final String nom, prenom;
	private String pseudo;
	private Vaisseau vaisseau;
	
	public Joueur (String nom, String prenom, String pseudo)
	{
		this.nom = formatNP(nom);
		this.prenom = formatNP(prenom);
		this.pseudo = pseudo;
		vaisseau = new ViperMKII();
	}
	
	/*
	 * Méthode de formattage de chaîne destinée aux attributs nom et prenom de la classe Joueur
	 * (première lettre en majuscule et reste de la chaîne en minuscules)
	 */
	private static String formatNP(String np)
	{
		// On formatte la première lettre en majuscule
		String premLettre = np.substring(0,1).toUpperCase();
		// On formatte le reste du mot en minuscules
		String restMot = np.substring(1,np.length()).toLowerCase();
		
		return premLettre + restMot;
	}
	
	// Getters, Setters & Overrides
	public String getNomPrenom() {
		return prenom + " " + nom;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Vaisseau getVaisseau() {
		return vaisseau;
	}

	@Override
	public boolean equals(Object o)
	{
		Joueur j = (Joueur) o;
		
		return (j.pseudo == this.pseudo);
	}
	
	@Override
	public String toString()
	{
		return pseudo + " (" + prenom + " " + nom + ")";
	}

}
