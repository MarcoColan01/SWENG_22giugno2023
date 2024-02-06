package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Segnalazione;
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
        if(comando.equals("Segnala")){
            try{
                Segnalazione segnalazione = Segnalazione.creaSegnalazione(args);
                view.showSuccess();
            }catch (IllegalArgumentException e){
                view.showError(e.getMessage());
            }
        }
    }
}
