import hints.*;
import rooms.*;
import player.Player;
import commands.CommandHandler;
import vraag.*;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hintproviders instellen
        List<HintProvider> providers = new ArrayList<>();
        providers.add(new HelpHint());
        providers.add(new FunnyHint());
        HintSystem hintSystem = new HintSystem(providers);

        // Speler aanmaken
        Player speler = new Player(1);
        CommandHandler.setPlayer(speler);

        // Kamers aanmaken met vraagstrategieën
        Room startRoom = new StartRoom(hintSystem,
                new InvulVraag("Wat is 2 + 2?", "4"), speler);
        Room save1 = new SaveRoom(hintSystem,
                new InvulVraag("Welk dier is het snelst op land?", "cheetah"), speler);
        Room save2 = new SaveRoom(hintSystem,
                new InvulVraag("Hoeveel uur zitten er in een dag?", "24"), speler);

        Room normal1 = new NormalRoom(hintSystem,
                new InvulVraag("Hoeveel dagen zitten er in een week?", "7"), speler);
        Room normal2 = new NormalRoom(hintSystem,
                new MeerkeuzeVraag("Wat is 5 x 5?",
                        List.of("15", "20", "25", "30"), "25"), speler);

        Room easy1 = new EasyRoom(hintSystem,
                new InvulVraag("Wat komt er na A in het alfabet?", "B"), speler);
        Room easy2 = new EasyRoom(hintSystem,
                new MeerkeuzeVraag("Wat is 1 + 1?",
                        List.of("1", "2", "3", "4"), "2"), speler);

        Room hard1 = new HardRoom(hintSystem,
                new InvulVraag("Wat is de wortel van 169?", "13"), speler);
        Room hard2 = new HardRoom(hintSystem,
                new MeerkeuzeVraag("Wat is het chemisch symbool voor goud?",
                        List.of("Ag", "Gd", "Au", "Pt"), "Au"), speler);

        Room boss = new BossRoom(hintSystem,
                new InvulVraag("Wat is de hoofdstad van IJsland?", "Reykjavik"), speler);

        // Kamerlijst (zonder start/boss)
        List<Room> kamerLijst = new ArrayList<>(Arrays.asList(
                save1, save2, normal1, normal2, easy1, easy2, hard1, hard2
        ));

        Collections.shuffle(kamerLijst);
        speler.setTotaalKamers(kamerLijst.size() + 1); // +1 voor startkamer

        Set<Room> bezocht = new HashSet<>();

        // Startkamer
        startRoom.enter();
        bezocht.add(startRoom);

        // Hoofdloop
        while (bezocht.size() < kamerLijst.size() + 1) {
            System.out.println("\n🧭 Kies een kamer om te betreden:");
            int index = 1;
            Map<Integer, Room> keuzeMap = new HashMap<>();

            for (Room kamer : kamerLijst) {
                if (!bezocht.contains(kamer)) {
                    System.out.println("Kamer " + index);
                    keuzeMap.put(index, kamer);
                }
                index++;
            }

            System.out.print("Typ het kamernummer (bijv. 1) of /help: ");
            String input;
            while (true) {
                input = scanner.nextLine().trim();
                if (!CommandHandler.verwerk(input)) break;
            }

            try {
                int keuze = Integer.parseInt(input);
                Room gekozen = keuzeMap.get(keuze);
                if (gekozen != null && !bezocht.contains(gekozen)) {
                    gekozen.enter();
                    bezocht.add(gekozen);
                } else {
                    System.out.println("❌ Ongeldige keuze.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Typ een geldig nummer.");
            }
        }

        // Boss Room
        System.out.println("\n✅ Je hebt alle kamers bezocht. De Boss Room is nu beschikbaar!");
        boss.enter();

        System.out.println("\n🎉 Einde van het spel! Goed gedaan.");
    }
}
