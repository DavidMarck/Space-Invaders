
public abstract class Vaisseau {

	protected int psTot, pbTot; // psTot = points de structure totaux; pbTot = points de bouclier totaux;
	protected int ps, pb; // suivis des points de structure et points de bouclier dans le temps
	protected boolean estDetruit;
	protected Arme lesArmes[];
	
	public Vaisseau(int psTot, int pbTot)
	{
		this.psTot = psTot;
		this.pbTot = pbTot;
		ps = psTot;
		pb = pbTot;
		estDetruit = false;
		lesArmes = new Arme[3]; // on décide qu'un vaisseau ne peut contenir que trois armes au maximum
	}
	
	/*
	 * Méthode qui vérifie si le Vaisseau est plein (= 3 armes)
	 */
	public boolean estPlein()
	{
		if(lesArmes[0] != null 
				&& lesArmes[1] != null 
				&& lesArmes[2] != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Méthode qui vérifie si les vaisseau est vide
	 */
	
	public boolean estVide()
	{
		if(lesArmes[0] == null 
				&& lesArmes[1] == null 
				&& lesArmes[2] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Méthode qui va vérifier si une arme (dont on fournit le nom) figure parmi les armes du vaisseau	
	 */
	public boolean existe(String nomArme)
	{
		if(!lesArmes[0].getNom().equals(nomArme)
				&& !lesArmes[1].getNom().equals(nomArme)
				&& !lesArmes[2].getNom().equals(nomArme))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Méthode d'ajout d'une arme aux armes du Vaisseau
	 */
	public void ajouteArme(Arme arme)
	{
		// Si il y a déjà trois armes
		if(estPlein())
		{
			System.out.println("L'inventaire est plein! Retirez une arme et réessayez.");
		}
		// Si il y a moins de trois armes
		else
		{
			int i = 0;
			while(i < lesArmes.length)
			{
				// Dès qu'un espace est vide, on ajoute l'arme
				if(lesArmes[i] == null)
				{
					lesArmes[i] = arme;
					break;
				}
				i++;
			}
		}
		
	}
	
	/*
	 * Méthode de suppression d'une arme parmi les armes du Vaisseau
	 * On utilise le nom des armes comme identifiant
	 */
	public void retireArme(String nomArme)
	{
		// Si aucune arme du Vaisseau ne correspond
		if(existe(nomArme))
		{
			System.out.println("Aucune arme de ce type ne figure parmi les armes.");
		}
		// Si au moins une arme correspond
		else
		{
			int i = 0;
			while(i < lesArmes.length)
			{
				// Dès qu'on trouve une arme qui correspond au nom en paramètre, on la retire
				if(lesArmes[i].getNom().equals(nomArme))
				{
					lesArmes[i] = null;
					break;
				}
				i++;
			}
		}
	}
	
	public void affichArmes()
	{
		for(Arme a : lesArmes)
		{
			System.out.println(a);
		}
	}
	
	/*
	 * Méthode qui calcule les dégâs moyens totaux des armes d'un Vaisseau
	 */
	public float moyDegats()
	{
		float moyDegats = 0;
		
		for(Arme a : lesArmes)
		{
			moyDegats += a != null ? (a.getDegMin() + a.getDegMax()) / 2 : 0;
		}
		
		return moyDegats;
	}
	
	
	/*
	 * Méthode qui définit la logique de prise des dégâts
	 */
	public void subitDegats(int degats)
	{
		if(pb > 0)
		{
			if(degats > pb)
			{
				ps -= degats - pb;
				pb -= pb;
			}
			else
			{
				pb -= degats;
			}
		}
		else
		{
			if(degats > ps)
			{
				ps = 0;
			}
			else
			{
				ps -= degats;
			}
		}
	}
	
	/*
	 * Méthode abstraite qui définiera le comportement d'attaque
	 */
	abstract void attaque(Vaisseau vaisseau);
	
	// Getters, Setters & Overrides
	public int getPs() {
		return psTot;
	}

	public void setPs(int ps) {
		this.psTot = ps;
	}

	public int getPb() {
		return pbTot;
	}

	public void setPb(int pb) {
		this.pbTot = pb;
	}

	public boolean estDetruit() {
		return estDetruit;
	}

	public void setEstDetruit(boolean estDetruit) {
		this.estDetruit = estDetruit;
	}
	
	@Override
	public String toString()
	{
		String infoVaisseau = "Vaisseau : "
				+ psTot + " points de structure; "
				+ pbTot + " points de bouclier; ";
		
		infoVaisseau += estDetruit ? "Deadly dead\n" : "Still alive!\n";
		infoVaisseau += "Armes : ";
		
		// Si le vaisseau ne contient aucune arme
		if(estVide())
		{
			infoVaisseau += "aucune arme";
			return infoVaisseau;
		}
		// Si le vaisseau contient au moins une arme
		else
		{
			// Pour chaque arme on afiche son nom
			for(Arme a : lesArmes)
			{
				if(a != null)
				{
					infoVaisseau += a.getNom() + "/";
				}
			}
			
			infoVaisseau += "\nDégâts moyens totaux : " + moyDegats() + "\n";
			return infoVaisseau;
		}
	}

}
