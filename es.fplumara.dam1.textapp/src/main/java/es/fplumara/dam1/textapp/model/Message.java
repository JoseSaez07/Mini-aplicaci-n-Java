package es.fplumara.dam1.textapp.model;

import java.time.LocalDateTime;

public class Message {
    private String texto;
    private LocalDateTime timestamp;
    private int numerodepalabras;
    public Message(String text) {
        this.texto = texto;
        this.timestamp = LocalDateTime.now();
        this.numerodepalabras = numerodepalabras(texto);
    }

    private int numerodepalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        return texto.trim().split("").length;
    }
    public String getTexto() {
        return texto;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getNumerodepalabras() {
        return numerodepalabras;
    }
}