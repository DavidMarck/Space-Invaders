import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViperMKII extends Vaisseau {

	public ViperMKII() {
		super(10, 15);
		ajouteArme(Armurerie.getInstance().getArme("mitrailleuse"));
		ajouteArme(Armurerie.getInstance().getArme("emg"));
		ajouteArme(Armurerie.getInstance().getArme("missile"));
	}

	@Override
	void attaque(Vaisseau vaisseau) {
		List<Arme> armesDispo = new ArrayList<Arme>();
		if(!estVide())
		{
			System.out.println("Le vaisseau ne contient aucune arme!");
		}
		else
		{
			System.out.println("Les armes utilisables sont les suivantes : ");
			int i = 0;
			for(Arme a : lesArmes)
			{
				if(a.getCptRecharge() == a.getTpsRecharge())
				{
					i++;
					armesDispo.add(a);
					System.out.println(i + ". " + a.toString());
				}
			}
			
			System.out.println("Quelle arme souhaitez-vous utiliser? (saisir numéro) : ");
			Scanner scan = new Scanner(System.in);
			String choixArme = scan.nextLine();
			
			vaisseau.subitDegats(armesDispo.get(Integer.parseInt(choixArme)).tirer());
		}
		
		
		// une arme par tour seulement!
	}

}
