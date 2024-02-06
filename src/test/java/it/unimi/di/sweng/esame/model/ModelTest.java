package it.unimi.di.sweng.esame.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void addSegnalazioneTest(){
        Model SUT = new Model();
        SUT.addSegnalazione(Segnalazione.creaSegnalazione("A4,57,Incidente"));
        assertThat(SUT.getSegnalazioni()).hasSize(1);
    }
    @Test
    void testAddSegnalazioneDoppia(){
        Model SUT = new Model();
        SUT.addSegnalazione(Segnalazione.creaSegnalazione("A4,57,Incidente"));
        assertThatThrownBy(() -> SUT.addSegnalazione(Segnalazione.creaSegnalazione("A4,57,Incidente")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("altra segnalazione già presente per questo tratto");
    }

    @Test
    void testRisolviSegnalazione(){
        Model SUT = new Model();
        SUT.addSegnalazione(Segnalazione.creaSegnalazione("A4,57,Incidente"));
        SUT.removeSegnalazione("A4,57");
        assertThat(SUT.getSegnalazioni()).hasSize(0);
        assertThat(SUT.getRisolte()).hasSize(1);
    }
}