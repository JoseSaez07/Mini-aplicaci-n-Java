package es.fplumara.dam1.textapp.files;

import es.fplumara.dam1.textapp.config.AppConfig;


public class TextStoreFactoryDemos{


    public static class StoreException extends RuntimeException {
        public StoreException(String message) {
            super(message);
        }
    }


    public interface TextStore {
        void save(String text);
        String read();
    }


    public static class FileTextStore implements TextStore {

        private AppConfig config;

        public FileTextStore(AppConfig config) {
            this.config = config;
        }

        @Override
        public void save(String text) {
            // Lógica para guardar en archivo
            System.out.println("Guardando en File: " + text);
        }

        @Override
        public String read() {
            // Lógica para leer archivo
            return "Contenido del FileTextStore";
        }
    }

    //  Implementacion Csv
    public static class CsvTextStore implements TextStore {

        private AppConfig config;

        public CsvTextStore(AppConfig config) {
            this.config = config;
        }

        @Override
        public void save(String text) {
            // Lógica para guardar en CSV
            System.out.println("Guardando en CSV: " + text);
        }

        @Override
        public String read() {
            // Lógica para leer CSV
            return "Contenido del CsvTextStore";
        }
    }


    public static class TextStoreFactory {

        public static TextStore createTextStore(AppConfig appConfig) throws StoreException {
            String type = appConfig.getStoreType();

            if (type.equalsIgnoreCase("FILE")) {
                return new FileTextStore(appConfig);
            } else if (type.equalsIgnoreCase("CSV")) {
                return new CsvTextStore(appConfig);
            } else {
                throw new StoreException("El tipo de TextStore no es válido: " + type);
            }
        }
    }


    public static void main(String[] args) {
        AppConfig configFile = new AppConfig("FILE");
        AppConfig configCsv = new AppConfig("CSV");

        TextStore fileStore = TextStoreFactory.createTextStore(configFile);
        TextStore csvStore = TextStoreFactory.createTextStore(configCsv);

        fileStore.save("Hola File");
        csvStore.save("Hola CSV");

        System.out.println(fileStore.read());
        System.out.println(csvStore.read());
    }
}