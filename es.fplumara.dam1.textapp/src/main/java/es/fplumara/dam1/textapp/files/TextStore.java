package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.model.Message;

public interface TextStore {
    void guardarMensaje(Message message);
    String readAll();
    String readLast(int n);
}
