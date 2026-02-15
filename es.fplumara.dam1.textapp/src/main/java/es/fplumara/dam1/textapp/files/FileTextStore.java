package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

public class FileTextStore {

    private AppConfig appConfig;

    public FileTextStore(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void save(String message) {
        Path path = Path.of(appConfig.getMessagesFile().toUri());

        try {
            Files.write(
                    path,
                    List.of(message),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}