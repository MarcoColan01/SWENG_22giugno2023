package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RisolteStrategy implements DisplayStrategy {
    @Override
    public void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {

    }

    @Override
    public List<String> showSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        List<String> s = new ArrayList<>();
        for(Segnalazione segnalazione: segnalazioni){
            s.add(segnalazione.toString());
        }
        return s;
    }
}
