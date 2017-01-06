
public class Dart extends Vaisseau {

	public Dart(int psTot, int pbTot) {
		super(10, 3);
		ajoutArme(new Arme("Laser",2,3,Type.DIRECT,1));
		// si arme direct, peux utiliser à tous les tours même si cptRecharge > 0
	}

	@Override
	void attaque(Vaisseau vaisseau) {
		// TODO Auto-generated method stub
		
	}

}
