package it.unimi.di.sweng.esame.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void addSegnalazioneTest(){
        Model SUT = new Model();
        SUT.addSegnalazione(Segnalazione.creaSegnalazione("A4,57,Incidente"));
        assertThat(SUT.getSegnalazioni()).hasSize(1);
    }
}