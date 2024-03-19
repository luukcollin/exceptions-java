package org.example.missies;

public class QuizMissie extends Missie {

    public void quiz(String vraag, String antwoord) throws QuizException {
        GebruikerActies.toonBericht(vraag);
        String gegevenAntwoord = GebruikerActies.leesInput();
        if (!gegevenAntwoord.toLowerCase().equals(antwoord.toLowerCase())) throw new QuizException();
    }

    @Override
    int voerUit(boolean sloper) {
        try {
            quiz("\"Wat is de hoofdstad van Noord-Holland?\"", "Haarlem");
            setPunten(!sloper);
        } catch (QuizException e) {
            setPunten(sloper);
            e.printStackTrace();
            e.getMessage();
        } catch (Exception e) {
            behaaldePunten = DEVELOPER_STRAFPUNTEN;
        }
        finally {
            System.out.printf("Behaalde punten %d\n", behaaldePunten);
        }
        return behaaldePunten;
    }
}
