package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		Boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if(!Boolean.TRUE.equals(nomAcheteurConnu)) {
			System.out.println("Je suis d�sol�e " + nomAcheteur + " mais il faut �tre un habitant de notre village pour acheter ici");
		}else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			Boolean produitDiponible = controlAcheterProduit.isDisponible(produit);
			if(!produitDiponible) {
				System.out.println("D�sol�e " + nomAcheteur + " il n'y a pas d'etal qui vend des " + produit);
			}else {
				vendreProduit(produit, nomAcheteur);
			}
		}
	}
		
	private void vendreProduit(String produit, String nomAcheteur) {
		int i = 1;
		int choixUtilisateur = -1;
		int quantite;
		String vendeurChoisie;
		String[] liste = controlAcheterProduit.listeVendeur(produit);
		do {
			StringBuilder question = new StringBuilder();
			question.append("Chez quel vendeur voulez-vous acheter ?(choisissez le numero");
			for(String vendeur : liste) {
				question.append(i + " - " + vendeur);
				i++;
			}
			choixUtilisateur = Clavier.entrerEntier(question.toString());
		} while(choixUtilisateur > 0 && choixUtilisateur < i);
		vendeurChoisie = liste[choixUtilisateur-1];
		quantite = controlAcheterProduit.quantiteProduit(vendeurChoisie);
		System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + vendeurChoisie);
		System.out.println("Bonjour " + nomAcheteur);
		
		transaction(produit,nomAcheteur,vendeurChoisie,quantite);
	}
	
	private void transaction(String produit, String nomAcheteur, String vendeurChoisie, int quantite) {
		int choixUtilisateur = Clavier.entrerEntier(vendeurChoisie + " - Combien voulez vous en acheter ? (<= 0 pour annuler)");
		if (choixUtilisateur <= 0) {
			System.out.println(vendeurChoisie + " - Je n'ai malheureseument plus de " + produit + " revenez une prochaine fois");
		}else if (choixUtilisateur < quantite) {
			System.out.println("Panoramix a achet� " + choixUtilisateur + produit);
		}else if (choixUtilisateur > quantite) {
			System.out.println(vendeurChoisie + " - Je n'ai pas " + choixUtilisateur + " " + produit + " mais je peux vous en vendre " + quantite);
			System.out.println("Panoramix a achet� " + choixUtilisateur + " " + produit + " � " + vendeurChoisie);
		}
	}
}
