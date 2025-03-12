import java.util.List;

class UIWeekEnd {    
    public static void main(String[] args) {

	Personne pierre = new Personne("Durand","Pierre"); 
	System.out.println(pierre.getNom()); 
	Personne paul = new Personne("Dupond","Paul"); 
	Personne marie = new Personne("Dumond","Marie");
	Personne anne = new Personne("Dunon","Anne");  
	Depense d1 = new Depense(pierre, 12, "pain"); 	
	Depense d2 = new Depense(paul, 100, "pizza"); 
	Depense d3 = new Depense(pierre, 70, "essence");
	Depense d4 = new Depense(marie, 15, "vin");  
	Depense d5 = new Depense(paul, 10, "vin"); 
	WeekEnd we = new WeekEnd();  

	AppWeekEnd app = new AppWeekEnd(we);
	we.ajouterPersonne(pierre); 
	we.ajouterPersonne(paul);
	we.ajouterPersonne(marie);
	we.ajouterPersonne(anne); 
	we.ajouterDepense(d1);   
	we.ajouterDepense(d2); 
	we.ajouterDepense(d4);   
	we.ajouterDepense(d3);
	we.ajouterDepense(d5);

	app.run();
    }
}
    
class AppWeekEnd {

    WeekEnd we;
    boolean quitter;

    AppWeekEnd(WeekEnd we) {
	this.we = we;
	this.quitter = false;
    }

    public void run() {
	bienvenue();
	boolean continuer = true;
	while(!quitter) {
	    menu();
	}
	au_revoir();
    }

    public void menu() {
	boolean commande_faite = false;
	while(!commande_faite) {
	    System.out.println("Que voulez vous faire?");
	    System.out.println("Q: quitter blablabla");
		System.out.println("P: pour afficher les personnes du weekend");
	    String commande_brute = System.console().readLine();
	    String commande = commande_brute.strip().toLowerCase();
	    if(commande.equals("q")) {
			quitter = true;
			commande_faite = true;
	    }
		if(commande.equals("p")) {
			List<Personne> lesPersonnes = we.getAmis();
			System.out.println("les Personnne du week end sont :");
			for (Personne p : lesPersonnes){
				System.out.println("\t" + p );
			}
			commande_faite = true;
		}
		 else {
		System.out.println("Commande '" + commande_brute + "' invalide.");
	    }
	}
    }

    /// Affiche un message de bienvenue
    public void bienvenue() {
	System.out.println("╭────────────────────────────────────────────────────────────────────────────────────╮");
	System.out.println("│ Bienvenue! En week-end comme dans la semaine, les bons comptes font les bons amis. │");
	System.out.println("╰────────────────────────────────────────────────────────────────────────────────────╯");
    }

    /// Affiche un message d'au revoir
    public void au_revoir() {
	System.out.println("╭────────────────────────────────────────────────────────────────────────────────────╮");
	System.out.println("│ Degage sale connard de merde                                                       │");
	System.out.println("╰────────────────────────────────────────────────────────────────────────────────────╯");
    }

}
