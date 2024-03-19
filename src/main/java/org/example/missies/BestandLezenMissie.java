package org.example.missies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BestandLezenMissie extends Missie {
    @Override
    int voerUit(boolean sloper) {
        GebruikerInteractie.toonBericht("Missie: Lees een bestand en toon de inhoud.");
        GebruikerInteractie.toonBericht("Voer de naam van het bestand in:");

        String bestandsnaam = GebruikerInteractie.leesInput();
        try {
            leesBestand(bestandsnaam);
            setPunten(!sloper);
        } catch (IOException e) {
            setPunten(sloper);
            e.printStackTrace();
            GebruikerInteractie.toonBericht("Er is een fout opgetreden bij het lezen van het bestand: " + e.getMessage());
            // Bied de gebruiker hier de mogelijkheid om het opnieuw te proberen of uitleg te krijgen over IOException.
        } catch (Exception e){
            behaaldePunten = DEVELOPER_STRAFPUNTEN;
        }finally {
            System.out.printf("Behaalde punten %d\n", behaaldePunten);
        }
        return behaaldePunten;
    }

    private void leesBestand(String bestandsnaam) throws IOException {
        BufferedReader lezer = new BufferedReader(new FileReader(bestandsnaam));
        String regel;
        while ((regel = lezer.readLine()) != null) {
            GebruikerInteractie.toonBericht(regel);
        }
        lezer.close();
    }
}
