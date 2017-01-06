
public class ViperMKII extends Vaisseau {

	public ViperMKII() {
		super(10, 15);
		ajouteArme(Armurerie.getInstance().getArme("mitrailleuse"));
		ajouteArme(Armurerie.getInstance().getArme("emg"));
		ajouteArme(Armurerie.getInstance().getArme("missile"));
	}

	@Override
	void attaque(Vaisseau vaisseau) {
		// TODO Auto-generated method stub
		// une arme par tour seulement!
	}

}
