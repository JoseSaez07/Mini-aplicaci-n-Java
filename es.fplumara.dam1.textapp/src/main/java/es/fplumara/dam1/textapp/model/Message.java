package es.fplumara.dam1.textapp.model;

import java.time.Instant;

public class Message {
    private String texto;
    private Instant timestamp;
    private int numerodepalabras;

    public void setNumerodepalabras(int numerodepalabras) {
        this.numerodepalabras = numerodepalabras;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public  Message(String Texto){
        this.texto = texto;

    }
}
