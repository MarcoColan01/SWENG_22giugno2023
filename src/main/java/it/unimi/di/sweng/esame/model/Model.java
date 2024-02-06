package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final @NotNull Map<Integer, Segnalazione> segnalazioni = new HashMap<>();
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

    public void removeSegnalazione(String s) {
    }
}
