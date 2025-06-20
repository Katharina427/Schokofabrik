package Projekt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SchokoladeTest {

    @Test
    public void berechneEinzelpreisTest() {

        // Testfall: Tafel (100g), Himbeeren, nicht vegan, 2 Stück
        Schokolade s = new Schokolade("Vollmilch", "Himbeeren", "Tafel (100g)", false, 2);

        // Erwarteter Preis: 3.00 (Größe) + 1.00 (Topping) = 4.00 * 2 = 8.00
        double expected = 8.00;
        double actual = s.berechneEinzelpreis();

        assertEquals(expected, actual);
    }
}