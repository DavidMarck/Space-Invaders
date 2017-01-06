import java.util.ArrayList;
import java.util.List;

public class Armurerie {
	// Utilisation du design pattern Singleton
	private static Armurerie instance = null;
	private List<Arme> lesArmes;
	
	private Armurerie() 
	{
		init();
	}
	
	public static Armurerie getInstance()
	{
		if(instance == null) {
		    instance = new Armurerie();
		}
		return instance;
	}
	
	/*
	 * Instanciation et ajout d'armes dans l'Armurerie
	 */
	private void init() 
	{
		lesArmes = new ArrayList<Arme>();
		
		Arme laser = new Arme("Laser",2,3,Type.DIRECT,1.0);
		lesArmes.add(laser);
		Arme hammer = new Arme("Hammer",1,8,Type.EXPLOSIF,1.5);
		lesArmes.add(hammer);
		Arme torpille = new Arme("Torpille",3,3,Type.GUIDE,2.0);
		lesArmes.add(torpille);
		Arme mitrailleuse = new Arme("Mitrailleuse",2,3,Type.DIRECT,1.0);
		lesArmes.add(mitrailleuse);
		Arme emg = new Arme("EMG",1,7,Type.EXPLOSIF,1.5);
		lesArmes.add(emg);
		Arme missile = new Arme("Missile",4,100,Type.GUIDE,4.0);
		lesArmes.add(missile);
	}
	
	/*
	 * Méthode qui permet la sélection d'une arme de l'armurerie par son nom
	 */
	public Arme getArme(String nomArme)
	{
		// l'arme à retourner
		Arme arme = null;
		
		for(Arme a : lesArmes)
		{
			if(a.getNom().toLowerCase().equals(nomArme.toLowerCase()))
			{
				arme = a;
				return arme;
			}
		}
		
		return arme;
	}
	
	// Getters, Setters & Overrides
	public boolean contientArme(Arme a)
	{
		return (lesArmes.contains(a));
	}

	public List getLesArmes() {
		return lesArmes;
	}

	public void setLesArmes(List lesArmes) {
		this.lesArmes = lesArmes;
	}
	
	@Override
	public String toString()
	{
		String armurerie = "Contenu de l'armurerie :\n";
		
		for(Arme a : lesArmes)
		{
			armurerie += "\t" + a.toString() + "\n";
		}
		
		return armurerie;
	}
}
