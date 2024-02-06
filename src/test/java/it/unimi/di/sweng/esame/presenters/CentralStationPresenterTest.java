package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.views.CentralStationView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CentralStationPresenterTest {
    @Test
    void testTrattoStradaSbagliato(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view);
        SUT.action("Segnala", "23,0,incidente");
        verify(view).showError("campo tratto non valido");
    }

    @Test
    void testKmSbagliato(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view);
        SUT.action("Segnala", "A4,ciao,incidente");
        verify(view).showError("campo km non numerico");
    }

    @Test
    void testDescrizioneMancante(){
        CentralStationView view = mock(CentralStationView.class);
        CentralStationPresenter SUT = new CentralStationPresenter(view);
        SUT.action("Segnala", "A4,87, ");
        verify(view).showError("campo descrizione mancante");
    }
}