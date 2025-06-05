import javax.swing.*;

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
    private JLabel lblGröße;
    private JRadioButton rbXXL;
    private JRadioButton rbTafel;
    private JRadioButton rbRiegel;
    private JLabel lblPreis;
    private JTextField tfPreis;
    private JCheckBox cbVegan;
    private JLabel lblVegan;
    private JButton speichernButton;
    private JButton berechnenButton;
    private JLabel lblToppings;

    // ArrayList

    // Konstruktor
    public Schokofabrik() {
        setTitle("Schokofabrik");
        setContentPane(myPanel);
        setVisible(true);
        setSize(300, 300);

        // im Konstruktor:
        // Buttongroups erstellen, damit nur ein Radiobutton auswählbar ist
        ButtonGroup gruppierung1 = new ButtonGroup();
        ButtonGroup gruppierung2 = new ButtonGroup();

        // Hinzufügen von Radiobuttons zur Gruppe
        gruppierung1.add(rbVollmilch);
        gruppierung1.add(rbZartbitter);
        gruppierung1.add(rbWeiß);

        gruppierung2.add(rbXXL);
        gruppierung2.add(rbTafel);
        gruppierung2.add(rbRiegel);
}

    public static void main(String[] args) {
        new Schokofabrik();
    }

}