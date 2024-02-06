package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements Observable<List<Segnalazione>> {
    private final @NotNull Map<Integer, Segnalazione> segnalazioni = new HashMap<>();
    private final @NotNull Map<String, Segnalazione> risolte = new HashMap<>();
    private final @NotNull List<Observer<List<Segnalazione>>> observers = new ArrayList<>();
    public void addSegnalazione(@NotNull Segnalazione segnalazione) {
        if(segnalazioni.containsKey(segnalazione.km())){
            if(segnalazioni.get(segnalazione.km()).tratta().equals(segnalazione.tratta()))
                throw new IllegalArgumentException("altra segnalazione già presente per questo tratto");
        }
        segnalazioni.put(segnalazione.km(), segnalazione);
        notifyObservers();
    }

    @Override
    public List<Segnalazione> getSegnalazioni() {
        return new ArrayList<>(segnalazioni.values());
    }

    public List<Segnalazione> getRisolte() {
        return new ArrayList<>(risolte.values());
    }

    public void removeSegnalazione(@NotNull String segnalazione) {
        String[] s = segnalazione.split(",");
        int km = Integer.parseInt(s[1]);
        if(segnalazioni.containsKey(km)){
            Segnalazione curr = segnalazioni.get(km);
            if(curr.tratta().equals(s[0])){
                risolte.put(curr.tratta(), curr);
                segnalazioni.remove(km);
            }
        }else throw new IllegalArgumentException("segnalazione non presente per questo tratto");
    }

    @Override
    public void notifyObservers() {
        for (Observer<List<Segnalazione>> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(@NotNull Observer<List<Segnalazione>> observer) {
        observers.add(observer);
    }
}
