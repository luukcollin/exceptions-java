package org.example.missies;

public class NullPointerMissie extends Missie {

    @Override
    void voerUit() {
        GebruikerInteractie.toonBericht("Missie: Voorkom een NullPointerException.");
        String tekst = null; // Simuleert een situatie waar een variabele null kan zijn.

        try {
            if (tekst == null) {
                throw new NullPointerException("tekst is null");
            }
            GebruikerInteractie.toonBericht("De lengte van de tekst is: " + tekst.length());
        } catch (NullPointerException e) {
            GebruikerInteractie.toonBericht("Gevangen NullPointerException: " + e.getMessage());
            // Bied de gebruiker uitleg en tips om deze situatie te voorkomen.
        }
    }
}