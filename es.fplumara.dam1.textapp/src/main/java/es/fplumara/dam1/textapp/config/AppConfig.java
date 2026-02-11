package es.fplumara.dam1.textapp.config;

import es.fplumara.dam1.textapp.exceptions.ConfigException;
import es.fplumara.dam1.textapp.files.StoryType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppConfig {
    private StoryType storeType;
    private String messages;
    private int messagesMaxLength;

    public void setMessagesMaxLength(int messagesMaxLength) {
        this.messagesMaxLength = messagesMaxLength;
    }


    public void setMessages(String messages) {
        this.messages = messages;
    }

    public void setStoreType(StoryType storeType) {
        this.storeType = storeType;
    }

    public StoryType getStorType(){
    return storeType;
    }

    public Path getMessagesFile() {
      Path path = Path.of("C:\\Users\\JoseSaezSerrano\\Mini-aplicaci-n-Java\\es.fplumara.dam1.textapp\\data\\mensajes.txt");
      return path;
    }

    public int getMaxLength(){
      return messagesMaxLength;
    }


    public AppConfig()  {
        Path path = Path.of("C:\\Users\\JoseSaezSerrano\\Mini-aplicaci-n-Java\\es.fplumara.dam1.textapp\\data\\config.properties");
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(path)) {
            properties.load(in);
        } catch (IOException e){
            throw new ConfigException("");
        }


    }
}

