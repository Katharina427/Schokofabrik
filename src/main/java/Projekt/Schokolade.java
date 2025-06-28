package Projekt;

import javax.swing.*;

public class Schokolade {

    // Attribute deklarieren
    private String sorte;
    private String toppings;
    private String größe;
    private boolean vegan;
    private int anzahl;

    // Konstruktor

    public Schokolade(String sorte, String toppings, String größe, boolean vegan, int anzahl) {
        this.sorte = sorte;
        this.toppings = toppings;
        this.größe = größe;
        this.vegan = vegan;
        this.anzahl = anzahl;
    }

    // Sorte aus selbst erstellten Objekten lesen, Rückgriff in filtern()
    public String getSorte() {
        return sorte;
    }

    // berechneEinzelpreis-Methode
    public double berechneEinzelpreis() {

        double preis = 0.00;

        // Größenpreise
        switch (größe) {
            case "Riegel (25g)":
                preis = 1.50;
                break;
            case "Tafel (100g)":
                preis = 3.00;
                break;
            case "XXL Tafel (300g)":
                preis = 6.00;
                break;
        }

        // Toppingpreis
        if (!toppings.equals("/")) {
            preis += 1.00;
        }

        // Veganpreis
        if (vegan == true) {
            preis += 1.00;
        }

        return preis * anzahl;
    }


    // Ausgabe der erstellten Objekte
    public String toString() {
        return "Schokoladensorte: " + sorte + "; Toppings: " + toppings + "; Größe: " + größe + "; Vegan: " + vegan + "; Anzahl: " + anzahl;
    }

}
