package org.example.missies;

public class ArithmeticExceptionMissie extends Missie {

    @Override
    int voerUit(boolean sloper) {
        int teller = 10;
        GebruikerInteractie.toonBericht("een ArithmeticException.", sloper);
        GebruikerInteractie.toonBericht("Voer een deling uit met het getal %d".formatted(teller));

        int noemer = 1; // default waarde
        String antwoord = GebruikerInteractie.leesInput();
        try {
            noemer = Integer.parseInt(antwoord);
            GebruikerInteractie.toonBericht("Resultaat is :" + teller / noemer);
            setPunten(!sloper);
        } catch(NumberFormatException e){
            setPunten(sloper);
            e.printStackTrace();
            GebruikerInteractie.toonBericht("Gevangen NumberFormatException: " + e.getMessage());
        } catch (ArithmeticException e) {
            setPunten(sloper);
            e.printStackTrace();
            GebruikerInteractie.toonBericht("Gevangen ArithmeticException: " + e.getMessage());
        } catch (Exception e){
            behaaldePunten = DEVELOPER_STRAFPUNTEN;
        }finally {
            System.out.printf("Behaalde punten %d\n", behaaldePunten);
        }
        return behaaldePunten;
    }
}