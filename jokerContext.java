package Joker;

import rooms.Room;

public class jokerContext {
    private Joker joker;
    private boolean used = false;

    public jokerContext(Joker joker) {
        this.joker = joker;
    }

    public void useJoker(Room room) {
        if (!used) {
            joker.useIn(room);
            used = true;
        } else {
            System.out.println("Je hebt je joker al gebruikt.");
        }
    }

    public void setJoker(Joker joker) {
        this.joker = joker;
        used = false;
    }
}
