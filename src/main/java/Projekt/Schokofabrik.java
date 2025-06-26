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
    private JLabel lblPreis;
    private JTextField tfPreis;
    private JCheckBox cbVegan;
    private JLabel lblVegan;
    private JButton speichernButton;
    private JButton berechnenButton;
    private JLabel lblToppings;
    private JComboBox cbGröße;
    private JLabel lblAnzahl;
    private JTextField tfAnzahl;
    private JTextArea textArea;
    private JButton ausgebenButton;
    private JButton hinzufügenButton;
    private JButton filternButton;
    private JComboBox cbFiltern;

    // ArrayList "bestellung" von Objekten des Typs "Schokolade" erstellen
    private ArrayList<Schokolade> bestellung = new ArrayList();

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


        // Aufruf der initObjekte-Methode
        initObjekte();


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


        filternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                filtern();
            }
        });


        berechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                berechnen();

            }
        });


        // weitere Schokolade hinzugügen - Button
        hinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // alle Eingaben löschen
                gruppierung.clearSelection();

                rbHimbeeren.setSelected(false);
                rbKekse.setSelected(false);
                rbNüsse.setSelected(false);
                rbSalzbrezeln.setSelected(false);
                rbSmarties.setSelected(false);

                cbGröße.setSelectedIndex(0);

                tfAnzahl.setText("");

                cbVegan.setSelected(false);

                tfPreis.setText("");
            }
        });
    }


    // initObjekte-Methode
    public void initObjekte() {

        Schokolade s1 = new Schokolade("Vollmilch", "Himbeeren, Salzbrezeln", "Tafel (100g)", false, 2);
        Schokolade s2 = new Schokolade("Zartbitter", "Nüsse", "Riegel (25g)", false, 5);
        Schokolade s3 = new Schokolade("Weiß", "Smarties, Kekse", "XXL Tafel (300g)", true, 1);

        bestellung.add(s1);
        bestellung.add(s2);
        bestellung.add(s3);
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


            // ausgewählte Toppings erfassen
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
            // wenn Toppings ausgewäht sind
            if (!toppings.isEmpty()) {
                toppings = toppings.substring(0, toppings.length() -2);

                // wenn keine Toppings ausgewählt sind
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

            // wenn keine Eingabe bei Anzahl gemacht wurde
            if (eingabe.isEmpty()) {
                throw new IllegalArgumentException("Bitte die gewünschte Anzahl eingeben.");
            }

            // wenn eine negative Zahl eingegeben wird
            int anzahl = Integer.parseInt(eingabe);
            if (anzahl < 1) {
                throw new IllegalArgumentException("Bitte wähle eine gültige Anzahl.");
            }



            // Erstellen eines Objektes der Klasse Schokolade
            Schokolade s = new Schokolade(sorte, toppings, größe, vegan, anzahl);

            // Hinzufügen des Objektes zur ArrayList "bestellung"
            bestellung.add(s);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Bei Anzahl bitte eine ganze Zahl eingeben.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }


    // Methode ausgeben()

    public void ausgeben() {

        // Überschreiben der textArea auf "nichts", damit nur das neue Objekt angehängt wird
        textArea.setText("");

        // wenn Liste "bestellung" nicht leer ist
        if (!bestellung.isEmpty()) {

            for (Schokolade s : bestellung) {
                textArea.append(s.toString() + "\n");
            }
        }
    }


    // Methode filtern()
    public void filtern() {

        // Überschreiben der textArea auf "nichts", um Doppelungen nach jeder Ausgabe zu vermeiden
        textArea.setText("");

        /* Zugriff auf Attribut "Sorte" des Objekts über Getter-Methode,
        da Attribute in Klasse "Schokolade" auf private gesetzt sind */
        // nur Ausgabe von Objekten, die Filter entsprechen

        // Filter lesen
        String gefiltert = cbFiltern.getSelectedItem().toString();

        for (Schokolade s : bestellung) {

            // wenn kein Filter ausgewählt ist oder der Filter mit Objekt übereinstimmt
            if (gefiltert.equals("kein Filter ausgewählt") || s.getSorte().equals(gefiltert)) {
                textArea.append(s.toString() + "\n");
            }
        }
    }

    // Methode berechnen()
    public void berechnen() {

        double gesamtpreis = 0.00;

        // Gesamtpreis setzt sich aus Einzelpreisen jedes Objekts zusammen
        for (Schokolade s : bestellung) {
            gesamtpreis += s.berechneEinzelpreis();
        }

        tfPreis.setText(gesamtpreis + " €");
    }

    public static void main(String[] args) {

        new Schokofabrik();
    }

}