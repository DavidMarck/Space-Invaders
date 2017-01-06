enum Type 
{
	DIRECT,
	EXPLOSIF,
	GUIDE;
}

public class Arme {
	
	private String nom; // nom du vaisseau
	private int degMin, degMax; // dégâts minimums et dégâts maximums
	private Type typeDegats; // type de dégats du vaisseau (voir enum Type)
	private int tpsRecharge; // temps de rechargement exprimé en nbre de tours
	private int cptTours; // compteur de tours (pour contrôler recharge)
	
	public Arme(String nom, int degMin, int degMax, Type typeDegats, int tpsRecharge) 
	{
		this.nom = nom;
		this.degMin = degMin;
		this.degMax = degMax;
		this.typeDegats = typeDegats;
		this.tpsRecharge = tpsRecharge;
		cptTours = tpsRecharge;
	}
	
	/*
	 * Méthode qui simule un tir
	 */
	public int tirer()
	{
		int degatsInfliges = 0;
		
		cptTours -= 1;
		
		if(cptTours != 0)
		{
			return degatsInfliges;
		}
		else
		{
			// On détermine les dégâts de base (valeur aléatoire comprise entre degMin et degMax)
			degatsInfliges = degMin + (int)(Math.random() * ((degMax - degMin) + 1));
			
			int lancer; // nombre aléatoire qui détermine si le tir va toucher (selon le type de dégâts)
			
			// Selon le type de dégâts, on applique un modificateur
			switch(typeDegats)
			{
				case DIRECT :
					// Le tir a 1 chance sur 10 de rater
					lancer = 1 + (int)(Math.random() * ((10 - 1) + 1));
					if(lancer == 1)
					{
						degatsInfliges = 0;
					}
					break;
				case EXPLOSIF :
					degatsInfliges *= 2;
					tpsRecharge *= 2;
					// Le tir a 1 chance sur 4 de rater
					lancer = 1 + (int)(Math.random() * ((4 - 1) + 1));
					if(lancer == 1)
					{
						degatsInfliges = 0;
					}
					break;
				case GUIDE :
					degatsInfliges = degMin;
					break;
				default :
					break;
			}
			return degatsInfliges;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDegMin() {
		return degMin;
	}

	public void setDegMin(int degMin) {
		this.degMin = degMin;
	}

	public int getDegMax() {
		return degMax;
	}

	public void setDegMax(int degMax) {
		this.degMax = degMax;
	}

	public Type getTypeDegats() {
		return typeDegats;
	}

	public void setTypeDegats(Type typeDegats) {
		this.typeDegats = typeDegats;
	}
	
	@Override
	public String toString()
	{
		return nom
				+ " [" + "dégâts minimums : " + degMin 
				+ "; dégâts maximums : " + degMax 
				+ "; types dégâts : " + typeDegats +"]";
	}
	
}
