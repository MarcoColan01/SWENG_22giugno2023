package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DisplayStrategy {
    void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni);

    List<String> showSegnalazioni(@NotNull List<Segnalazione> segnalazioni);
}
