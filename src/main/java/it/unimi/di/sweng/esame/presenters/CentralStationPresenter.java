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
        try{
            int km = Integer.parseInt(arg[1]);
        }catch (NumberFormatException e){
            view.showError("campo km non numerico");
            return;
        }
        if(arg[2].isBlank()){
            view.showError("campo descrizione mancante");
            return;
        }
    }
}
