package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.views.CentralStationView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CentralStationPresenter implements Presenter {
    private final @NotNull CentralStationView view;
    private final @NotNull Model model;
    public CentralStationPresenter(@NotNull CentralStationView view, Model model) {
        this.view = view;
        this.model = model;
        view.addHandlers(this);
    }

    @Override
    public void action(String comando, String args) {
        if(comando.equals("Segnala")){
            try{
                Segnalazione segnalazione = Segnalazione.creaSegnalazione(args);
                model.addSegnalazione(segnalazione);
            }catch (IllegalArgumentException e){
                view.showError(e.getMessage());
                return;
            }
            view.showSuccess();
        }else if(comando.equals("Risolto")){
            try{
                model.removeSegnalazione(args);
            }catch (IllegalArgumentException e){
                view.showError(e.getMessage());
            }
        }
    }
}
