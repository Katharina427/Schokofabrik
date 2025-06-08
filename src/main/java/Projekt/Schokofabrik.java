package Projekt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Schokofabrik extends JFrame {
    private JPanel myPanel;
    private JRadioButton rbVollmilch;
    private JRadioButton rbZartbitter;
    private JRadioButton rbWeiß;
    private JLabel lblSorte;
    private JRadioButton rbHimbeeren;
    private JRadioButton rbKekse;
    private JRadioButton rbNüsse;
    private JRadioButton rbSalzbrezeln;
    private JRadioButton rbSmarties;
    private JLabel lblGröße;
    private JRadioButton rbXXL;
    private JRadioButton rb100;
    private JRadioButton rb25;
    private JLabel lblPreis;
    private JTextField tfPreis;
    private JCheckBox cbVegan;
    private JLabel lblVegan;
    private JButton speichernButton;
    private JButton berechnenButton;
    private JLabel lblToppings;
    private JRadioButton rb300;
    private JComboBox cbGröße;
    private JLabel lblAnzahl;
    private JTextField tfAnzahl;
    private JTextArea textAreaSpeichern;

    // ArrayList "schoki" von Objekten des Typs "Schokolade" erstellen
    private ArrayList<Schokolade> schoki = new ArrayList();

    // Konstruktor
    public Schokofabrik() {
        setTitle("Schokofabrik");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(myPanel);
        setVisible(true);
        setSize(700, 300);

        // Hintergrundfarbe in hellgrau einfärben
        myPanel.setBackground(Color.LIGHT_GRAY);


        // Buttongroups erstellen, damit nur ein Radiobutton auswählbar ist
        ButtonGroup gruppierung1 = new ButtonGroup();
        ButtonGroup gruppierung2 = new ButtonGroup();

        // Hinzufügen von Radiobuttons zur Gruppe
        gruppierung1.add(rbVollmilch);
        gruppierung1.add(rbZartbitter);
        gruppierung1.add(rbWeiß);

        gruppierung2.add(rbXXL);
        gruppierung2.add(rb100);
        gruppierung2.add(rb25);


        // ActionListener
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                speichern();
            }
        });


        berechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                berechnen(); // Methoden-Aufruf
            }
        });
    }


    // Methode speichern()
    public void speichern() {

        // die ausgewählte Sorte erfassen
        String sorte = "";

        if (rbVollmilch.isSelected()) {
            sorte = "Vollmilch";
        } else if (rbZartbitter.isSelected()) {
            sorte = "Zartbitter";
        } else if (rbWeiß.isSelected()) {
            sorte = "Weiß";
        }


        // die ausgewählten Toppings erfassen
        List<String> toppings = new ArrayList<>();

        if (rbHimbeeren.isSelected()) {
            toppings.add("Himbeeren");
        } if (rbKekse.isSelected()) {
            toppings.add("Kekse");
        } if (rbNüsse.isSelected()) {
            toppings.add("Nüsse");
        } if (rbSalzbrezeln.isSelected()) {
            toppings.add("Salzbrezeln");
        } if (rbSmarties.isSelected()) {
            toppings.add("Smarties");
        }

        // die ausgewählte Größe erfassen
        String größe = "";
        größe = (String) cbGröße.getSelectedItem();


        // erfassen, ob vegan oder nicht
        boolean vegan = false;

        if (cbVegan.isSelected()) {
            vegan = true;
        }

        // Anzahl erfassen und sicher gehen, dass eine Zahl eingegeben wurde
        int anzahl = 0;

        try {
            anzahl = Integer.parseInt(tfAnzahl.getText());
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(null, "Bitte die gewünschte Anzahl eingeben!");
            return;
        }

        textAreaSpeichern.setText("Schokoladensorte: " + sorte + ", Toppings: " + toppings + ", Größe: " + größe + ", Vegan: " + vegan + ", Anzahl: " + anzahl);

    }


    // Methode berechnen()
    public void berechnen() {

        //Schokoladenart prüfen
        double schokoPreis = 0.00;

        if (rbVollmilch.isSelected()) {
            schokoPreis = 2.50;
        }
        if (rbWeiß.isSelected()) {
            schokoPreis = 2.50;
        }
        if (rbZartbitter.isSelected()) {
            schokoPreis = 2.50;
        }


        // Größenpreise prüfen
        double größenPreis = 0.00;

        String ausgewählteGröße = (String) cbGröße.getSelectedItem();

        if (ausgewählteGröße != null) {
            switch (ausgewählteGröße) {
                case "25g (Riegel)":
                    größenPreis = 1.50;
                    break;
                case "100g (Tafel)":
                    größenPreis = 3.00;
                    break;
                case "300g (XXL Tafel)":
                    größenPreis = 6.00;
                    break;
                default:
                    größenPreis = 0.00; // unbekannter Wert, vllt noch Fehlermeldung einfügen
            }
        }

        //Preis pro Topping
        double toppingPreis = 0.00;

        if (rbHimbeeren.isSelected()) {
            toppingPreis += 0.90;
        }
        if (rbKekse.isSelected()) {
            toppingPreis += 0.50;
        }
        if (rbNüsse.isSelected()) {
            toppingPreis += 0.70;
        }
        if (rbSalzbrezeln.isSelected()) {
            toppingPreis += 0.60;
        }
        if (rbSmarties.isSelected()) {
            toppingPreis += 0.40;
        }


        // Vegan Preis
        double veganPreis = 0.00;
        if (cbVegan.isSelected()) {
            veganPreis = 1.00;
        }

        // Anzahl erfassen und sicher gehen, dass eine Zahl eingegeben wurde
        int anzahl = 0;

        try {
            anzahl = Integer.parseInt(tfAnzahl.getText());
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(null, "Bitte die gewünschte Anzahl eingeben!");
            return;
        }

        //Gesamtpreis
        double gesamtPreis = (größenPreis + toppingPreis + veganPreis + schokoPreis) * anzahl;

        tfPreis.setText(gesamtPreis + " €");

    }


    public static void main(String[] args) {

        new Schokofabrik();
    }

}