package org.example.missies;

public class ArithmeticExceptionMissie extends Missie {
    @Override
    void voerUit() {
        GebruikerInteractie.toonBericht("Missie: Voer een veilige deling uit en voorkom ArithmeticException.");
        int teller = 10;
        int noemer = 0; // Riskante waarde

        try {
            if (noemer == 0) {
                throw new ArithmeticException("Delen door nul is niet toegestaan");
            }
            int resultaat = teller / noemer;
            GebruikerInteractie.toonBericht("Resultaat van de deling is: " + resultaat);
        } catch (ArithmeticException e) {
            GebruikerInteractie.toonBericht("Gevangen ArithmeticException: " + e.getMessage());
            // Bied uitleg over waarom delen door nul een probleem is en hoe dit te voorkomen.
        }
    }
}