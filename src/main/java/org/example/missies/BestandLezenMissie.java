package org.example.missies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BestandLezenMissie extends Missie {
    @Override
    void voerUit() {
        GebruikerInteractie.toonBericht("Missie: Lees een bestand en toon de inhoud.");
        GebruikerInteractie.toonBericht("Voer de naam van het bestand in:");

        String bestandsnaam = GebruikerInteractie.leesInput();
        try {
            leesBestand(bestandsnaam);
        } catch (IOException e) {
            GebruikerInteractie.toonBericht("Er is een fout opgetreden bij het lezen van het bestand: " + e.getMessage());
            // Bied de gebruiker hier de mogelijkheid om het opnieuw te proberen of uitleg te krijgen over IOException.
        }
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
