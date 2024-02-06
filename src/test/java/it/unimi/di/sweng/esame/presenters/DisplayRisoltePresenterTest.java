package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class DisplayRisoltePresenterTest {
    @Test
    void testUpdateRisolte() {
        Model model = spy(Model.class);
        DisplayView view = mock(DisplayView.class);
        DisplayRisoltePresenter SUT = new DisplayRisoltePresenter(model, view, new RisolteStrategy());
        model.addSegnalazione(Segnalazione.creaSegnalazione("A4,54,Incidente"));
        model.addSegnalazione(Segnalazione.creaSegnalazione("A1,97,Traffico"));
        model.addSegnalazione(Segnalazione.creaSegnalazione("A5,96,Traffico"));
        model.removeSegnalazione("A1,97");

        verify(view).set(0, "Traffico sulla A1 al Km 97");
    }
}