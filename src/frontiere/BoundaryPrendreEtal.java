package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Bonjour "+ nomVendeur + " je vais vous regarder si je peux vous trouver un �tal.");
			Boolean etatDisponible = controlPrendreEtal.resteEtals();
			if(!etatDisponible) {
				System.out.println("D�sol�e "+ nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�j� occup�.");	
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un �tal pour vous !");
		System.out.println("Il me faudrait quelques renseignements.");
		System.out.println("Quel produit souhaitez-vous vendre ?");
		String produit = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur +" s'est install� � l'etal n�"+ numeroEtal);
		}
	}
}
