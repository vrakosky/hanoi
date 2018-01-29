package cfranc.hanoi;

public class Hanoi {
	
	Tour tourInit;
	Tour tourInter;
	Tour tourDest;

	public Hanoi(int n){
                this.tourInit = new Tour(n);
		this.tourInter = new Tour(n);
		this.tourDest = new Tour(n);
		    
		for(int i = n ; i > 0 ; i--){
		    Disque d = new Disque(i);
		    tourInit.empiler(d);
		}
	}
	
	public Hanoi(){
		tourInit = new Tour();
		tourInter = new Tour();
		tourDest = new Tour();
		Disque petit = new Disque(1);
		Disque moyen = new Disque(2);
		Disque grand = new Disque(3);
		tourInit.empiler(grand);
		tourInit.empiler(moyen);
		tourInit.empiler(petit);
	}
	
	public void bougerSommet(Tour from, Tour to) {
                if(!from.estVide() && !to.estPleine()){
                    Disque disqueAdeplacer = from.depiler();  
                    to.empiler(disqueAdeplacer);
                }
	}

	public void deplacer(int nbDisque, Tour from, Tour to, Tour by){
		if (nbDisque > 0) {
			deplacer(nbDisque-1, from, by, to);
			bougerSommet(from, to);
			deplacer(nbDisque-1, by, to, from);
		}
	}

	public void jouer() {
		deplacer(tourInit.taille(), tourInit, tourDest, tourInter);
	}

	public static void main(String[] args) {
		// Compléter la classe Hanoi pour résoudre le jeux avec 3 disques :
		Hanoi game = new Hanoi();
                System.out.println("---------Jeu hanoi de taille 3 :--------");
		System.out.println("Tour initiale : "+game.tourInit.estVide());
                System.out.println("Tour intermediare :"+game.tourInter.estVide());
		System.out.println("Tour destination :"+game.tourDest.estVide());
		System.out.println("-------------------Jeu-------------------");
                game.jouer();
		System.out.println("Tour initiale :"+game.tourInit.estVide());
                System.out.println("Tour intermediare : "+game.tourInter.estVide());
		System.out.println("Tour destination : "+game.tourDest.estVide());
                System.out.println("----------------Fin du jeu----------------\n");
		
		// Compléter la classe Hanoi pour résoudre le jeux avec n disques :
		int n =25;
		Hanoi gameN = new Hanoi(n);
                System.out.println("---------Jeu hanoi de taille "+n+" :---------");
		System.out.println("Tour initiale : "+gameN.tourInit.estVide());
                System.out.println("Tour intermediare : "+game.tourInter.estVide());
		System.out.println("Tour destination : "+gameN.tourDest.estVide());
		System.out.println("-------------------Jeu-------------------");
                gameN.jouer();
		System.out.println("Tour initiale : "+gameN.tourInit.estVide());
                System.out.println("Tour intermediare : "+game.tourInter.estVide());
		System.out.println("Tour destination : "+gameN.tourDest.estPleine());
                System.out.println("----------------Fin du jeu----------------");
		
	}
}