package vraag;

public class InvulVraag implements VraagStrategie {
    private final String vraag;
    private final String juistAntwoord;

    public InvulVraag(String vraag, String juistAntwoord) {
        this.vraag = vraag;
        this.juistAntwoord = juistAntwoord;
    }

    @Override
    public void stelVraag() {
        System.out.println("Vraag: " + vraag);
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equalsIgnoreCase(juistAntwoord);
    }

    @Override
    public String geefFeedback(String antwoord) {
        if (controleerAntwoord(antwoord)) {
            return "✅ Juist!";
        } else {
            return "❌ Fout. \n";
        }
    }
}
