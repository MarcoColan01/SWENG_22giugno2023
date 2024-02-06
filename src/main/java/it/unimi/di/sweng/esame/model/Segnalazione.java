package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public record Segnalazione(@NotNull String tratta, int km, @NotNull String descrizione) {

    public static Segnalazione creaSegnalazione(@NotNull String comando){
        String[] arg = comando.split(",");
        int km = 0;
        if(!arg[0].matches("[A-Z]\\d"))
            throw new IllegalArgumentException("campo tratto non valido");
        try{
            km = Integer.parseInt(arg[1]);
            if(km < 0) throw new IllegalArgumentException("campo km negativo");
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("campo km non numerico");
        }
        if(arg[2].isBlank()) throw new IllegalArgumentException("campo descrizione mancante");
        return new Segnalazione(arg[0], km, arg[2]);
    }
}
