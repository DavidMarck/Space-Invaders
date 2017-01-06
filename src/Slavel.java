
public class Slavel extends Vaisseau {

	public Slavel() 
	{
		super(30, 0);
		ajouteArme(Armurerie.getInstance().getArme("hammer").copieArme());
	}
	
	@Override
	public void ajouteArme(Arme arme) 
	{
		// si l'arme est de type EXPLOSIF, son temps de recharge est de 1
		if(arme.getTypeDegats() == Type.EXPLOSIF)
		{
			arme.setTpsRecharge(1);
			arme.setCptRecharge(1);
		}
		super.ajouteArme(arme);
	}

	@Override
	void attaque(Vaisseau vaisseau) 
	{
		// TODO Auto-generated method stub
	}

}
