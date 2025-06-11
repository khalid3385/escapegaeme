package monsters;

import player.Player;

public class monsterGebruik {
    private Monster monster;

    public monsterGebruik(Monster monster) {
        this.monster = monster;
    }

    public void voerAanvalUit(Player speler) {
        monster.valAan(speler);
    }

    public void reageerOpAntwoord(boolean correct) {
        monster.update(correct);
    }

    public void verwijderMonster() {
        monster.verwijder();
    }

    public void toonMonsterInfo() {
        System.out.println("Monster: " + monster.getNaam());
        System.out.println("Beschrijving: " + monster.getBeschrijving());
        System.out.println("Schade: " + monster.getSchade());
    }
}
