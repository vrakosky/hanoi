package cfranc.hanoi;

import static org.junit.Assert.*;

import org.junit.Test;

public class TourTest {

	@Test
	public void test() {

	}
        
        @Test
        public void testEmpilerDansTourVide() {
            System.out.println("TEST Vrai : Empiler dans tour vide");
            Tour tour = new Tour(); 
            Disque d1 = new Disque(1);
            boolean resultatAttendu = true;
            boolean resultat = tour.empiler(d1);
            assertEquals(resultatAttendu, resultat);
        }
        
        @Test
        public void testEmpilerSurDisquePlusGrand() {
            System.out.println("TEST Vrai : Empiler sur disque plus grand");
            Tour tour = new Tour(); 
            Disque d1 = new Disque(3);
            tour.empiler(d1);
            Disque d2 = new Disque(2);
            tour.empiler(d2);
            Disque d3 = new Disque(1);
            boolean resultatAttendu = true;
            boolean resultat = tour.empiler(d3);
            assertEquals(resultatAttendu, resultat);
        }
        
        @Test
        public void testEmpilerSurDisquePlusPetit() {
            System.out.println("TEST Faux : Empiler sur disque plus petit");
            Tour tour = new Tour(); 
            Disque d1 = new Disque(4);
            tour.empiler(d1);
            Disque d2 = new Disque(3);
            tour.empiler(d2);
            Disque d3 = new Disque(4);
            boolean resultatAttendu = false;
            boolean resultat = tour.empiler(d3);
            assertEquals(resultatAttendu, resultat);
        }
        
        @Test
        public void testEmpilerSurDisqueDeLaMemeTaille() {
            System.out.println("TEST Faux: Empiler sur disque de la même taille");
            Tour tour = new Tour();
            Disque d1 = new Disque(3);
            tour.empiler(d1);
            Disque d2 = new Disque(2);
            tour.empiler(d2);
            Disque d3 = new Disque(2);
            boolean resultatAttendu = false;
            boolean resultat = tour.empiler(d3);
            assertEquals(resultatAttendu, resultat);
        }
        
        @Test
        public void testEmpilerDansTourPleine() {
            System.out.println("TEST Faux : Empiler correctement mais dans tour pleine");
            Tour tour = new Tour();
            Disque d1 = new Disque(4);
            tour.empiler(d1);
            Disque d2 = new Disque(3);
            tour.empiler(d2);
            Disque d3 = new Disque(2);
            tour.empiler(d3);
            Disque d4 = new Disque(1);
            boolean resultatAttendu = false;
            boolean resultat = tour.empiler(d4); //On dépasse la hauteurMax
            assertEquals(resultatAttendu, resultat);
        }
}
