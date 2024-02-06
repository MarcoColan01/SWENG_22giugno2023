package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class SegnalateStrategy implements DisplayStrategy {
    @Override
    public void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        segnalazioni.sort((o1, o2) -> {
            int res = o1.tratta().compareTo(o2.tratta());
            if(res == 0) return Integer.compare(o1.km(), o2.km());
            return res;
        });
    }
}
