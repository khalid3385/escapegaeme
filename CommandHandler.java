package commands;

import player.Player;

public class CommandHandler {
    private static Player speler;

    public static void setPlayer(Player p) {
        speler = p;
    }

    public static boolean verwerk(String input) {
        if (!input.startsWith("/")) return false;

        switch (input.toLowerCase()) {
            case "/help":
                toonHelp();
                return true;
            case "/status":
                toonStatus();
                return true;
            default:
                System.out.println("❌ Onbekende command.");
                return true;
        }
    }

    private static void toonHelp() {
        System.out.println("📖 Beschikbare commands:");
        System.out.println("/help    - Toon deze lijst met commands");
        System.out.println("/status  - Toon je huidige spelerstatus");
    }

    private static void toonStatus() {
        if (speler == null) {
            System.out.println("⚠ Geen speler geladen.");
        } else {
            System.out.println(speler.getStatus());
        }
    }
}
