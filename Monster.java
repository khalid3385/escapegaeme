package monsters;

import US18ObserverPattern.AnswerObserver;

public interface Monster extends AnswerObserver {
    String getNaam();

    int getSchade();

    String getBeschrijving();

    void valAan(player.Player player);
    void verwijder();
    void update(boolean correct);
}