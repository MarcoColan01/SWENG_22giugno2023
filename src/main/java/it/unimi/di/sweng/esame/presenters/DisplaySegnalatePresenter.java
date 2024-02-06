package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DisplaySegnalatePresenter implements Observer<List<Segnalazione>> {
    private final @NotNull Model model;
    private final @NotNull DisplayView view;
    private final @NotNull DisplayStrategy strategy;

    public DisplaySegnalatePresenter(Model model, DisplayView view, DisplayStrategy strategy) {
        this.model = model;
        this.strategy = strategy;
        this.view = view;
        model.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable<List<Segnalazione>> subject) {
        int i = 0;
        List<String> segnalazioni = strategy.showSegnalazioni(subject.getSegnalazioni());
        for(int j = 0; j < segnalazioni.size() && j < Main.PANEL_SIZE; j++){
            view.set(i++, segnalazioni.get(j));
        }
        if(i < Main.PANEL_SIZE){
            for(int j = i; j < Main.PANEL_SIZE; j++){
                view.set(j, "");
            }
        }
    }
}
