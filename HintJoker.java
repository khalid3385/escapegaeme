package Joker;

import rooms.Room;

public class HintJoker implements Joker{
    boolean used = false;
    @Override
    public void useIn(Room room){
        if(!used){
            room.revealHintJoker();
            used = true;
        } else {
            System.out.println(" HintJoker is al gebruikt.");
        }
    }
}