package rooms;


import US18ObserverPattern.AnswerObserver;
import US18ObserverPattern.AnswerSubject;
import interfaces.Questionable;
import interfaces.Hintable;
import monsters.*;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Questionable, Hintable, AnswerSubject {
    protected String naam;
    protected Monster monster = null;
    protected boolean monsterGeactiveerd = false;
    private String hint;

    private final List<AnswerObserver> observers = new ArrayList<>();

    public Room(String naam, String hint) {
        this.naam = naam;
        this.hint=hint;
    }

    public void revealHintJoker() {
        System.out.println("Hint: " + hint);
    }

    public abstract void enter(Player player);

    // Observer pattern implementatie
    @Override
    public void addObserver(AnswerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AnswerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(boolean correct) {
        for (AnswerObserver o : observers) {
            o.update(correct);
        }
    }

    public abstract void enter();

    @Override
    public void vraagOmHint() {
        System.out.println("Deze kamer heeft geen hint.");
    }

}
