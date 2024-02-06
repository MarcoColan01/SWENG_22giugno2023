package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.views.CentralStationView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CentralStationPresenterTest {
    @Test
    void testTrattoStradaSbagliato(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view, mock(Model.class));
        SUT.action("Segnala", "23,0,incidente");
        verify(view).showError("campo tratto non valido");
    }

    @Test
    void testKmSbagliato(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view, mock(Model.class));
        SUT.action("Segnala", "A4,ciao,incidente");
        verify(view).showError("campo km non numerico");
    }

    @Test
    void testDescrizioneMancante(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view, mock(Model.class));
        SUT.action("Segnala", "A4,87, ");
        verify(view).showError("campo descrizione mancante");
    }

    @Test
    void testDescrizioneOk(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view, mock(Model.class));
        SUT.action("Segnala", "A4,87,Incidente");
        verify(view).showSuccess();
    }

    @Test
    void testSegnalazioneDoppia(){
        CentralStationView view = mock(CentralStationView.class);
        Model model = spy(Model.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view, model);
        SUT.action("Segnala","A4,87,Incidente");
        SUT.action("Segnala","A4,87,Incidente");
        verify(view).showError("altra segnalazione già presente per questo tratto");
    }

    @Test
    void testRisolviSegnalazioneNonPresente(){
        CentralStationView view = mock(CentralStationView.class);
        Model model = spy(Model.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view, model);
        SUT.action("Risolto","A4,87");
        verify(view).showError("segnalazione non presente per questo tratto");
    }
}