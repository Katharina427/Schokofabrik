package Projekt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JButton ausgebenButton;

    // ArrayList "schoki" von Objekten des Typs "Schokolade" erstellen
    private ArrayList<Schokolade> schoki = new ArrayList();

    // Konstruktor
    public Schokofabrik() {
        setTitle("Schokofabrik");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(myPanel);
        setVisible(true);
        setSize(700, 600);

        // Hintergrundfarbe in hellgrau einfärben
        myPanel.setBackground(Color.LIGHT_GRAY);


        // Buttongroups erstellen, damit nur ein Radiobutton auswählbar ist
        ButtonGroup gruppierung = new ButtonGroup();

        // Hinzufügen von Radiobuttons zur Gruppe
        gruppierung.add(rbVollmilch);
        gruppierung.add(rbZartbitter);
        gruppierung.add(rbWeiß);


        // ActionListener
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                speichern();
            }
        });


        ausgebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ausgeben();
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

        try {

            // die ausgewählte Sorte erfassen
            String sorte = "";

            if (rbVollmilch.isSelected()) {
                sorte = "Vollmilch";
            } else if (rbZartbitter.isSelected()) {
                sorte = "Zartbitter";
            } else if (rbWeiß.isSelected()) {
                sorte = "Weiß";
            } else {
                throw new IllegalArgumentException("Bitte eine Schokoladensorte wählen.");
            }


            // die ausgewählten Toppings erfassen
            String toppings = "";
            if (rbHimbeeren.isSelected()) {
                toppings += "Himbeeren, ";
            } if (rbKekse.isSelected()) {
                toppings += "Kekse, ";
            } if (rbNüsse.isSelected()) {
                toppings += "Nüsse, ";
            } if (rbSalzbrezeln.isSelected()) {
                toppings += "Salzbrezeln, ";
            } if (rbSmarties.isSelected()) {
                toppings += "Smarties, ";
            }

            // Komma und Leerzeichen am Ende entfernen
            if (!toppings.isEmpty()) {
                toppings = toppings.substring(0, toppings.length() -2);
            } else {
                toppings = "/";
            }

            // die ausgewählte Größe erfassen
            String größe = cbGröße.getSelectedItem().toString();


            // erfassen, ob vegan oder nicht
            boolean vegan = false;

            if (cbVegan.isSelected()) {
                vegan = true;
            }

            // Anzahl erfassen und sicher gehen, dass eine Zahl eingegeben wurde
            String eingabe = tfAnzahl.getText();
            if (eingabe.isEmpty()) {
                throw new IllegalArgumentException("Bitte die gewünschte Anzahl eingeben.");
            }

            int anzahl = Integer.parseInt(eingabe);
            if (anzahl < 1) {
                throw new IllegalArgumentException("Bitte wähle eine gültige Anzahl.");
            }





            // Erstellen eines Objektes der Klasse Schokolade
            Schokolade s = new Schokolade(sorte, toppings, größe, vegan, anzahl);

            // Hinzufügen des Objektes zur ArrayList "schoki"
            schoki.add(s);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Bei Anzahl bitte eine ganze Zahl eingeben.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }


    // Methode ausgeben()

    public void ausgeben() {

        // wenn Liste "schoki" nicht leer ist
        if (!schoki.isEmpty()) {

            for (Schokolade s : schoki) {
                textAreaSpeichern.append(s.toString());
            }
        } else {
            // wenn in ArrayList keine Schokolade gespeichert ist
            JOptionPane.showMessageDialog(null, "Es wurde keine Schokolade kreiert.");
        }
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