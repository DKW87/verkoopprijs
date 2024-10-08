package controller;

import java.util.Scanner;

/* Dit is een applicatie die de verkoopprijs berekent van een product.
De verkoopprijs wordt berekend op basis van de inkoopprijs van een product en de winstmarge.
Mvg, Danny Kwant */
public class VerkoopprijsController {

    // public methods
    public static double berekenVerkoopprijsEx(double inkoopprijs, double winstmarge) {
        double winstMargeInProcenten = (winstmarge / 100.0) + 1;
        return inkoopprijs * winstMargeInProcenten;
    };

    public static void main(String[] args) {

        // Variabelen
        double inkoopprijs;
        double winstmarge;
        double verkoopprijsExBTW;
        final double btwLaag = 1.09; // verkoopprijsExBTW wordt * deze variabele gedaan (laag BTW tarief 9%)
        final double btwHoog = 1.21; // verkoopprijsExBTW wordt * deze variabele gedaan (hoog BTW tarief 21%)
        int gebruikerskeuzeHoogLaagBTW;
        boolean blijfdraaien = true;

        // Scanner init
        Scanner scanner = new Scanner(System.in);

        while (blijfdraaien) {

            System.out.print("\nInkoopprijs: ");
            inkoopprijs = scanner.nextDouble();

            System.out.print("Winstmarge in %: ");
            winstmarge = scanner.nextDouble();

            verkoopprijsExBTW = berekenVerkoopprijsEx(inkoopprijs, winstmarge);

            System.out.print("\nVerkoopprijs exclusief BTW: " + verkoopprijsExBTW + ".\n");

            System.out.println("\nOnder welk BTW-tarief valt het product?");
            System.out.printf("%5d Laag%n", 1);
            System.out.printf("%5d Hoog%n", 2);
            System.out.print("Geef je keuze op: ");

            gebruikerskeuzeHoogLaagBTW = scanner.nextInt();

            switch (gebruikerskeuzeHoogLaagBTW) {
                case 1 -> {
                    System.out.print("Verkoopprijs inclusief 9% BTW: " + verkoopprijsExBTW * btwLaag + ".\n");
                }
                case 2 -> {
                    System.out.print("Verkoopprijs inclusief 21% BTW: " + verkoopprijsExBTW * btwHoog + ".\n");
                }
                default -> {
                    System.out.print("Ongeldige keuze, probeer het opnieuw.\n");
                }
            }

        }


    }
}
