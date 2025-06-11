package monsters;

import player.Player;

public class Creeper implements Monster {

    @Override
    public String getNaam() {
        return "Creeper";
    }

    @Override
    public int getSchade() {
        return 5;
    }

    @Override
    public String getBeschrijving() {
        return "Een creeper schuifelt op je af.";
    }

    @Override
    public void valAan(Player speler) {
        speler.decreaseHP(getSchade());
        System.out.println("🧟 " + getBeschrijving());
        System.out.println("💥 De creeper explodeert! Je verliest " + getSchade() + " HP.");
    }
    @Override
    public void verwijder() {
        System.out.println("💨 De Chicken Jockey verdwijnt in het niets.");
    }

    @Override
    public void update(boolean correct) {
        if (!correct) {
            System.out.println("💢 De Creeper wordt woedend en valt aan!");
            // Roep hier `valAan(...)` aan met een geldige Player (zie toelichting hieronder)
        } else {
            System.out.println("😴 De Creeper blijft AFK");
        }
    }
}
