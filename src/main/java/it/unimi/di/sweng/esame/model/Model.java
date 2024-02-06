package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final @NotNull Map<Integer, Segnalazione> segnalazioni = new HashMap<>();
    public void addSegnalazione(@NotNull Segnalazione segnalazione) {
        segnalazioni.put(segnalazione.km(), segnalazione);
    }

    public List<Segnalazione> getSegnalazioni() {
        return new ArrayList<>(segnalazioni.values());
    }
}
