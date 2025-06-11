package US18ObserverPattern;

public interface AnswerObserver {
    void update(boolean correct); // true = juist, false = fout
}
