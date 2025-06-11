package rooms;

import US18ObserverPattern.Door;
import US18ObserverPattern.StatusDisplay;
import hints.HintSystem;
import player.Player;
import vraag.VraagStrategie;
import monsters.ChickenJockey;

import java.util.Scanner;
import US18ObserverPattern.AnswerObserver;
import US18ObserverPattern.AnswerSubject;


public class BossRoom extends Room {
    private final HintSystem hintSystem;
    private final VraagStrategie vraagStrategie;
    private final Player player;

    public BossRoom(HintSystem hintSystem, VraagStrategie strategie, Player player) {
        super("Boss Room");
        this.hintSystem = hintSystem;
        this.vraagStrategie = strategie;
        this.player = player;
    }

    @Override
    public void enter() {
        player.nextRoom();
        System.out.println("Je bent in een normale kamer.");
        bepaalOfErEenMonsterIs();

        // Observers toevoegen
        addObserver(new Door());
        addObserver(new StatusDisplay());
        if (monster != null) addObserver(monster);

        stelVraag();
    }


    private static final double MONSTER_KANS = 0.4; // 40%

    public void bepaalOfErEenMonsterIs() {
        if (Math.random() < MONSTER_KANS) {
            monster = new ChickenJockey(); // of Creeper/Skeleton random kiezen
            System.out.println("⚠️ Je voelt een dreiging... er is iets in deze kamer.");
        }
    }

    public void stelVraag() {
        Scanner scanner = new Scanner(System.in);
        int pogingen = 0;
        boolean juist = false;

        while (pogingen < 2 && !juist) {
            vraagStrategie.stelVraag();

            String antwoord;
            while (true) {
                antwoord = scanner.nextLine().trim();
                if (!commands.CommandHandler.verwerk(antwoord)) break;
            }

            juist = vraagStrategie.controleerAntwoord(antwoord);
            System.out.println(vraagStrategie.geefFeedback(antwoord));

            // 🔔 Hier roep je alle observers aan:
            notifyObservers(juist);

            if (!juist && pogingen == 0) {
                if (monster != null && !monsterGeactiveerd) {
                    monster.valAan(player);
                    monsterGeactiveerd = true;
                }

                System.out.println("Wil je een hint? (ja/nee)");
                String hintAntwoord;
                while (true) {
                    hintAntwoord = scanner.nextLine().trim();
                    if (!commands.CommandHandler.verwerk(hintAntwoord)) break;
                }
                hintSystem.toonHintAlsGewenst(hintAntwoord);
            }

            pogingen++;
        }
    }
}
