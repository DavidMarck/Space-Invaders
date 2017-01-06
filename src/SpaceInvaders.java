import java.util.ArrayList;
import java.util.List;

public class SpaceInvaders {

	private List<Joueur> lesJoueurs;
	private Armurerie armurerie = Armurerie.getInstance();

	public SpaceInvaders()
	{
		init();
	}
	
	private void init()
	{
		
		// Création, instanciation et ajout de joueurs à la liste des joueurs
		lesJoueurs = new ArrayList<Joueur>();
		
		Joueur j1 = new Joueur("maRck","dAviD","OeufMayo");
		j1.getVaisseau().ajouteArme((Arme)armurerie.getLesArmes().get(0));
		
		// Test ArmurerieException
		/*
		try
		{
			Arme armeTest = new Arme("rockat", 8, 88, Type.DIRECT);
			if(armurerie.contientArme(armeTest))
			{
				j1.getVaisseau().ajoutArme(armeTest);
			}
			else
			{
				throw new ArmurerieException();
			}
		}
		catch(ArmurerieException e)
		{
			e.printStackTrace();
		}
		*/
		
		lesJoueurs.add(j1);
		
		Joueur j2 = new Joueur("mOSer","maxImE","ThunderDiamond");
		lesJoueurs.add(j2);
		
		Joueur j3 = new Joueur("borile","valentin","Soulbreaker");
		lesJoueurs.add(j3);
		
		
	}

	public List<Joueur> getListJoueurs() {
		return lesJoueurs;
	}

	public void setListJoueurs(List<Joueur> listJoueurs) {
		this.lesJoueurs = listJoueurs;
	}
	
	public Armurerie getArmurerie() {
		return armurerie;
	}
	
	public static void main(String[] args) 
	{
		SpaceInvaders jeu = new SpaceInvaders();
		
		// On affiche les joueurs, leurs info et le contenu de l'armurerie
		System.out.println("Liste des joueurs :");
		for(Joueur j : jeu.getListJoueurs())
		{
			System.out.println(j + "\n" + j.getVaisseau() + "\n");
		}
		System.out.println(jeu.getArmurerie());
	}
	
}
