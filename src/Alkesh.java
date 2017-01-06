
public class Alkesh extends Vaisseau {

	public Alkesh() {
		super(3, 5);
		ajouteArme(Armurerie.getInstance().getArme("torpille").copieArme());
	}

	@Override
	void attaque(Vaisseau vaisseau) {
		for(Arme a : this.lesArmes)
		{
			vaisseau.subitDegats(a.tirer());
		}
	}

}
