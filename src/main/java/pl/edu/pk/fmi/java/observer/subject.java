package pl.edu.pk.fmi.java.observer;
import java.util.Observer;

interface Subject {

    void Attach(Observer o);
    void Detach(Observer o);
    void Notify();
}
