package monsters;

import player.Player;

public class Skeleton implements Monster {
    private boolean actief = false;

    @Override
    public String getNaam() {
        return "Skeleton";
    }
    @Override
    public int getSchade() {
        return 10;
    }
    @Override
    public String getBeschrijving() {
        return "💀 De skeleton valt aan!";
    }
    @Override
    public void valAan(Player player) {
        actief = true;
        System.out.println("💀 De skeleton valt aan!");
        player.schade(10);
    }

    @Override
    public void verwijder() {
        actief = false;
        System.out.println("💀 De skeleton verdwijnt in het niets.");
    }

    @Override
    public void update(boolean correct) {
        if (!correct) {
            System.out.println("💢 De Skeleton wordt woedend en valt aan!");
            // Roep hier `valAan(...)` aan met een geldige Player (zie toelichting hieronder)
        } else {
            System.out.println("😴 Skeleton Jockey blijft stil.");
        }
    }
}
