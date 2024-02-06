package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final @NotNull Map<Integer, Segnalazione> segnalazioni = new HashMap<>();
    private final @NotNull Map<String, Segnalazione> risolte = new HashMap<>();
    public void addSegnalazione(@NotNull Segnalazione segnalazione) {
        if(segnalazioni.containsKey(segnalazione.km())){
            if(segnalazioni.get(segnalazione.km()).tratta().equals(segnalazione.tratta()))
                throw new IllegalArgumentException("altra segnalazione già presente per questo tratto");
        }
        segnalazioni.put(segnalazione.km(), segnalazione);
    }

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
            if(segnalazioni.get(km).tratta().equals(s[0])){
                risolte.put(segnalazioni.get(km).tratta(), segnalazioni.get(km));
                segnalazioni.remove(km);
            }
        }
    }
}
