package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DisplaySegnalatePresenterTest {
    @Test
    void updateSegnalateTest(){
        Model model = spy(Model.class);
        DisplayView view = mock(DisplayView.class);
        DisplaySegnalatePresenter SUT = new DisplaySegnalatePresenter(model, view, new SegnalateStrategy());
        model.addSegnalazione(Segnalazione.creaSegnalazione("A4,54,Incidente"));
        model.addSegnalazione(Segnalazione.creaSegnalazione("A1,97,Traffico"));
        verify(view).set(0, "Traffico sulla A1 al km 97");
        verify(view).set(1, "Incidente sulla A4 al km 54");
    }
}