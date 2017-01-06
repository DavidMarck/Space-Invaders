import java.util.ArrayList;
import java.util.List;

public class Armurerie {

	private List<Arme> lesArmes;
	
	public Armurerie() 
	{
		init();
	}
	
	private void init() 
	{
		lesArmes = new ArrayList<Arme>();
		
		Arme tourelle = new Arme("tourelle", 8, 88, Type.DIRECT);
		lesArmes.add(tourelle);
		Arme obus = new Arme("obus",100,300,Type.EXPLOSIF);
		lesArmes.add(obus);
		Arme missile = new Arme("missile",90,150,Type.GUIDE);
		lesArmes.add(missile);
	}
	
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
