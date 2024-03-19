package org.example.missies;

import java.util.Scanner;

public class NullPointerMissie extends Missie {
    final int TE_BEHALEN_PUNTEN = 3;
    int behaaldePunten = 0;
    @Override
    int voerUit(boolean sloper) {
        GebruikerInteractie.toonBericht("een NullPointerException.", sloper);
        String tekst = GebruikerInteractie.leesInput(); // Simuleert een situatie waar een variabele null kan zijn.

        try {
            if (tekst.isEmpty()) throw new NullPointerException("tekst is null");

            GebruikerInteractie.toonBericht("De lengte van de tekst is: " + tekst.length());
            setPunten(!sloper);
        } catch (NullPointerException e) {
            e.printStackTrace();
            setPunten(sloper);
            GebruikerInteractie.toonBericht("Gevangen NullPointerException: " + e.getMessage());
            return behaaldePunten;
            // Bied de gebruiker uitleg en tips om deze situatie te voorkomen.
        } catch (Exception e){
            behaaldePunten = DEVELOPER_STRAFPUNTEN;
        } finally {
            System.out.printf("Behaalde punten %d\n", behaaldePunten);
        }
        return behaaldePunten;
    }
}