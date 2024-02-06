package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Model implements Observable<List<Segnalazione>> {
    private final @NotNull Map<Integer, List<Segnalazione>> segnalazioni = new HashMap<>();
    private final @NotNull Map<String, List<Segnalazione>> risolte = new LinkedHashMap<>();
    private final @NotNull List<Observer<List<Segnalazione>>> observers = new ArrayList<>();
    public void addSegnalazione(@NotNull Segnalazione segnalazione) {
        if(segnalazioni.containsKey(segnalazione.km())){
            for(Segnalazione s: segnalazioni.get(segnalazione.km())) {
                if (s.tratta().equals(segnalazione.tratta()))
                    throw new IllegalArgumentException("altra segnalazione già presente per questo tratto");
            }
            segnalazioni.get(segnalazione.km()).add(segnalazione);
            notifyObservers();
        }else{
            List<Segnalazione> s = new ArrayList<>();
            s.add(segnalazione);
            segnalazioni.put(segnalazione.km(), s);
            notifyObservers();
        }
    }

    @Override
    public List<Segnalazione> getSegnalazioni() {
        List<Segnalazione> value = new ArrayList<>();
        for(List<Segnalazione> s: segnalazioni.values()){
            value.addAll(s);
        }
        return new ArrayList<>(value);
    }
    @Override
    public List<Segnalazione> getRisolte() {
        List<Segnalazione> value = new ArrayList<>();
        for(List<Segnalazione> s: risolte.values()){
            value.addAll(s);
        }
        return new ArrayList<>(value);
    }

    public void removeSegnalazione(@NotNull String segnalazione) {
        String[] s = segnalazione.split(",");
        int km = Integer.parseInt(s[1]);
        if(segnalazioni.containsKey(km)){
            List<Segnalazione> curr = segnalazioni.get(km);
            for(Segnalazione segnalazioneCurr: curr){
                if(segnalazioneCurr.tratta().equals(s[0])){
                    if(risolte.containsKey(segnalazioneCurr.tratta())){
                        risolte.get(segnalazioneCurr.tratta()).add(segnalazioneCurr);
                    }else{
                        List<Segnalazione> nuova = new ArrayList<>();
                        nuova.add(segnalazioneCurr);
                        risolte.put(segnalazioneCurr.tratta(), nuova);
                    }
                    segnalazioni.remove(segnalazioneCurr.km());
                }
            }
            notifyObservers();
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
