import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private JLabel lblGewicht;
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
    private JTextField tfSpeichern;
    private JComboBox cbGewicht;
    private JLabel lblAnzahl;
    private JTextField tfAnzahl;

    // ArrayList

    // Konstruktor
    public Schokofabrik() {
        setTitle("Schokofabrik");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(myPanel);
        setVisible(true);
        setSize(700, 300);

        // im Konstruktor:
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


                // die ausgewählte Sorte erfassen
                String sorte = "";

                if (rbVollmilch.isSelected()) {
                    sorte = "Vollmilch";
                } else if (rbZartbitter.isSelected()) {
                    sorte = "Zartbitter";
                }else if (rbWeiß.isSelected()) {
                    sorte = "Weiß";
                }

                // die ausgewählten Toppings erfassen
                List<String> toppings = new ArrayList<>();

                if (rbKekse.isSelected()) {
                    toppings.add("Kekse");
                } if (rbNüsse.isSelected()) {
                    toppings.add("Nüsse");
                } if (rbSalzbrezeln.isSelected()) {
                    toppings.add("Salzbrezeln");
                } if (rbSmarties.isSelected()) {
                    toppings.add("Smarties");
                } if (rbHimbeeren.isSelected()) {
                    toppings.add("Himbeeren");
                }

                // das ausgewählte Gewicht erfassen

                String gewicht = "";
                gewicht = (String) cbGewicht.getSelectedItem();



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
                    JOptionPane.showMessageDialog(null, "Bitte eine gültige Zahl eingeben!");
                    return;
                }

                tfSpeichern.setText("Schokoladensorte: " + sorte + ", Toppings: " + toppings + ", Gewicht: " + gewicht + ", Vegan: " + vegan + ", Anzahl: " + anzahl);

            }
        });


        berechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                initObjekte(); // Methoden-Aufruf
            }
        });
    }

    // Methode initObjekte()
    public void initObjekte() {

        //Schokoladenart prüfen
        double schokoPreis = 0;

        if (rbVollmilch.isSelected()) {
            schokoPreis = 2.50;
        }
        if (rbWeiß.isSelected()) {
            schokoPreis = 2.50;
        }
        if (rbZartbitter.isSelected()) {
            schokoPreis = 2.50;
        }


        //Gewichtpreise prüfen
        double gewichtPreis = 0;

        String ausgewaehltesGewicht = (String) cbGewicht.getSelectedItem();

        if (ausgewaehltesGewicht != null) {
            switch (ausgewaehltesGewicht) {
                case "25g (Riegel)":
                    gewichtPreis = 1.5;
                    break;
                case "100g (Tafel)":
                    gewichtPreis = 3.0;
                    break;
                case "300g (XXL Tafel)":
                    gewichtPreis = 6.0;
                    break;
                default:
                    gewichtPreis = 0; // unbekannter Wert, vllt noch Fehlermeldung einfügen
            }
        }

        //Preis pro Topping
        double toppingPreis = 0;

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
        if (rbHimbeeren.isSelected()) {
            toppingPreis += 0.90;
        }


        // Vegan Preis
        double veganPreis = 0;
        if (cbVegan.isSelected()) {
            veganPreis = 1.0;
        }

        // Anzahl erfassen und sicher gehen, dass eine Zahl eingegeben wurde
        int anzahl = 0;

        try {
            anzahl = Integer.parseInt(tfAnzahl.getText());
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(null, "Bitte eine gültige Zahl eingeben!");
            return;
        }

        //Gesamtpreis
        double gesamtPreis = (gewichtPreis + toppingPreis + veganPreis + schokoPreis) * anzahl;

        tfPreis.setText(gesamtPreis + "€");

    }

    // eigene Methode

    public static void main(String[] args) {
        new Schokofabrik();
    }

}