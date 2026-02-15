package es.fplumara.dam1.textapp;

import es.fplumara.dam1.textapp.config.AppConfig;
import es.fplumara.dam1.textapp.files.StoryType;
import es.fplumara.dam1.textapp.files.TextStore;
import es.fplumara.dam1.textapp.files.TextStoreFactoryDemos;

import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // 1
        AppConfig config = new AppConfig("CSV");

        // 2
        StoryType storeType = config.getStoreType();

        // 3
        TextStore store = TextStoreFactoryDemos.getTextStore(storeType, config);

        // 5
        String[] mensajes = {
                "Mensaje 1: Hola mundo",
                "Mensaje 2: Probando logs",
                "Mensaje 3: Guardando información",
                "Mensaje 4: Más datos",
                "Mensaje 5: Último mensaje"
        };

        // 6
        for (String msg : mensajes) {
            store.save(msg);
        }

        // 7
        System.out.println("===== TODOS LOS MENSAJES =====");
        List<String> todos = Collections.singletonList(store.readAll());
        todos.forEach(System.out::println);

        // 8
        System.out.println("\n===== ÚLTIMOS 3 MENSAJES =====");
        List<String> ultimos3 = Collections.singletonList(store.readLast(3));
        ultimos3.forEach(System.out::println);
    }
}
