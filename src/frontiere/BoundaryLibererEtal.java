package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!Boolean.TRUE.equals(vendeurReconnu)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marchhé aujourd'hui !");
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0] != null && donneesEtal[0].equals("true")) {
				System.out.println("Vous avez vendu" + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2]);
				System.out.println("En revoir " + nomVendeur + ", passez une bonne journée");
			}
		}
	}

}
