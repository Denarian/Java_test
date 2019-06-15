package pl.edu.pk.fmi.java.observer;


public interface Subject {

    void AttachN(Observer o);
    void DetachN(Observer o);
    void Notify();
}
