package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DisplayStrategyTest {
    @Test
    void testSortSegnalate(){
        DisplayStrategy SUT = new SegnalateStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = Segnalazione.creaSegnalazione("A4,45,Incidente");
        Segnalazione s2 = Segnalazione.creaSegnalazione("A1,37,Incidente");
        Segnalazione s3 = Segnalazione.creaSegnalazione("A3,85,Incidente");
        Segnalazione s4 = Segnalazione.creaSegnalazione("A4,14,Incidente");
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        SUT.sortSegnalazioni(segnalazioni);
        assertThat(segnalazioni).containsExactly(s2, s3, s4, s1);

    }

    @Test
    void testShowSegnalate(){
        DisplayStrategy SUT = new SegnalateStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = Segnalazione.creaSegnalazione("A4,45,Incidente");
        Segnalazione s2 = Segnalazione.creaSegnalazione("A1,37,Incidente");
        Segnalazione s3 = Segnalazione.creaSegnalazione("A3,85,Incidente");
        Segnalazione s4 = Segnalazione.creaSegnalazione("A4,14,Incidente");
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        assertThat(SUT.showSegnalazioni(segnalazioni)).containsExactly(
                "Incidente sulla A1 al Km 37",
                "Incidente sulla A3 al Km 85",
                "Incidente sulla A4 al Km 14",
                "Incidente sulla A4 al Km 45"
        );
    }

    @Test
    void testSortRisolte(){
        DisplayStrategy SUT = new RisolteStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = Segnalazione.creaSegnalazione("A4,45,Incidente");
        Segnalazione s2 = Segnalazione.creaSegnalazione("A1,37,Incidente");
        Segnalazione s3 = Segnalazione.creaSegnalazione("A3,85,Incidente");
        Segnalazione s4 = Segnalazione.creaSegnalazione("A4,14,Incidente");
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        SUT.sortSegnalazioni(segnalazioni);
        assertThat(segnalazioni).containsExactly(s1, s2, s3, s4);

    }

    @Test
    void testShowRisolte(){
        DisplayStrategy SUT = new RisolteStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = Segnalazione.creaSegnalazione("A4,45,Incidente");
        Segnalazione s2 = Segnalazione.creaSegnalazione("A1,37,Incidente");
        Segnalazione s3 = Segnalazione.creaSegnalazione("A3,85,Incidente");
        Segnalazione s4 = Segnalazione.creaSegnalazione("A4,14,Incidente");
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        assertThat(SUT.showSegnalazioni(segnalazioni)).containsExactly(
                "Incidente sulla A4 al Km 45",
                "Incidente sulla A1 al Km 37",
                "Incidente sulla A3 al Km 85",
                "Incidente sulla A4 al Km 14"
        );
    }

}