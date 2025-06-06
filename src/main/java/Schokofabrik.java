import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Schokofabrik extends JFrame {
    private JPanel myPanel;
    private JRadioButton rbVollmilch;
    private JRadioButton rbZartbitter;
    private JRadioButton rbWeiß;
    private JLabel lblSorte;
    private JRadioButton himbeerenRadioButton;
    private JRadioButton rbKekse;
    private JRadioButton rbNüsse;
    private JRadioButton rbSalzbrezeln;
    private JRadioButton rbSamrties;
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

    // ArrayList

    // Konstruktor
    public Schokofabrik() {
        setTitle("Schokofabrik");
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

    }

    // eigene Methode

    public static void main(String[] args) {
        new Schokofabrik();
    }

}