
public class Dart extends Vaisseau {

	public Dart() 
	{
		super(10, 3);
		ajouteArme(Armurerie.getInstance().getArme("laser").copieArme());
	}
	
	@Override
	public void ajouteArme(Arme arme) 
	{
		// si l'arme est de type DIRECT, son temps de recharge est de 1
		if(arme.getTypeDegats() == Type.DIRECT)
		{
			arme.setTpsRecharge(1);
			arme.setCptRecharge(1);
		}
		super.ajouteArme(arme);
	}

	@Override
	void attaque(Vaisseau vaisseau)
	{
		
	}

}
