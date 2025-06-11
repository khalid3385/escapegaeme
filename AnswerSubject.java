package US18ObserverPattern;

public interface AnswerSubject {
    void addObserver(AnswerObserver observer);
    void removeObserver(AnswerObserver observer);
    void notifyObservers(boolean correct);
}
