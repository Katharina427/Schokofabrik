package Projekt;

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

    public String toString() {
        return "Schokoladensorte: " + sorte + "; Toppings: " + toppings + "; Größe: " + größe + "; Vegan: " + vegan + "; Anzahl: " + anzahl;
    }



}
