package player;

public class Player {
    private final int playerId;
    private int hp = 100;
    private int currentRoom = 0;
    private int totaalKamers = 0;

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public void setTotaalKamers(int totaal) {
        this.totaalKamers = totaal;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void decreaseHP(int amount) {
        this.hp = Math.max(0, this.hp - amount);
    }

    public int getHP() {
        return hp;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void nextRoom() {
        this.currentRoom++;
    }

    public void setCurrentRoom(int index) {
        this.currentRoom = index;
    }

    public String getStatus() {
        String kamerTekst = totaalKamers > 0
                ? "Kamer: " + (currentRoom + 1) + " / " + totaalKamers
                : "Kamer index: " + currentRoom;
        return "📊 STATUS - Speler #" + playerId + "\n" +
                "HP: " + hp + "\n" +
                kamerTekst;
    }

    @Override
    public String toString() {
        return "Player{id=" + playerId + ", hp=" + hp + ", currentRoom=" + currentRoom + ", totaal=" + totaalKamers + "}";
    }

    public void schade(int i) {
    }
}
