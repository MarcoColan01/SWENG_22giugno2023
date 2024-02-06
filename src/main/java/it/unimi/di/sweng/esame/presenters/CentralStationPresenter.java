package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.views.CentralStationView;
import org.jetbrains.annotations.NotNull;

public class CentralStationPresenter implements Presenter{
    private final @NotNull CentralStationView view;
    public CentralStationPresenter(@NotNull CentralStationView view) {
        this.view = view;
        view.addHandlers(this);
    }

    @Override
    public void action(String comando, String args) {
        String[] arg = args.split(",");
        if(!arg[0].matches("[A-Z]\\d")){
            view.showError("campo tratto non valido");
            return;
        }
    }
}
