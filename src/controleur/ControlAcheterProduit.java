package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public boolean isDisponible(String produit) {
		Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
		return vendeur != null;
	}
	
	public String[] listeVendeur(String produit) {
		String[] liste = null;
		Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
		for(int i = 0; i < vendeur.length; i++) {
			liste[i] = vendeur[i].getNom();
		}
		return liste;
	}
	
	public int quantiteProduit(String vendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur).getQuantite();
	}
}
