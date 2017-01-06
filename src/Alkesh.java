
public class Alkesh extends Vaisseau {

	public Alkesh() {
		super(3, 5);
		ajouteArme(Armurerie.getInstance().getArme("torpille").copieArme());
	}

	@Override
	void attaque(Vaisseau vaisseau) {
		// TODO Auto-generated method stub
		// pareil que pour Dart mais avec explosif
	}

}
