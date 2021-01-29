
public class Article {

	long reference ;
	String intitule;
	float prixHT;
	int quantiteEnstock;
	
	public Article(long reference, String intitule, float prixHT, int quantiteEnstock) {
		this.reference = reference;
		this.intitule = intitule;
		this.prixHT = prixHT;
		this.quantiteEnstock = quantiteEnstock;
	}

	public long getReference() {
		return reference;
	}

	public void setReference(long reference) {
		this.reference = reference;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public int getQuantiteEnstock() {
		return quantiteEnstock;
	}

	public void setQuantiteEnstock(int quantiteEnstock) {
		this.quantiteEnstock = quantiteEnstock;
	}
	
	public void approvisionner(int nombreUnites) {
		
		quantiteEnstock = quantiteEnstock + nombreUnites ; 
	}
	
	public boolean vendre(int nombreUnites) {
		
		if (quantiteEnstock > nombreUnites) {
			
			quantiteEnstock = quantiteEnstock + nombreUnites ;
			return true;
		}
		else 
			
			System.out.println("La quantité en stock n'est pas suffisante ");
			return false ;
		
	}
	
	public float prixHT() {
		
		return prixHT;
		
	}
	
	public float prixTTC() {
		
		float taxe = 20/100; 	
		float prixTTC = prixHT * taxe;
		return prixTTC;
		
	}
	
	public String Afficher(Article article ) {
		
		reference = article.getReference();
		intitule =article.getIntitule() ;
		prixHT= article.prixHT();
		float prixTTC = article.prixTTC();
		
		String art = ("L'article numéro : "+reference+" avec comme intitulé : "+intitule+" est au prix de : "+prixHT+ " et au prix de "+prixTTC+" avce les taxes");
		
		return art;
	}
	
	
}
