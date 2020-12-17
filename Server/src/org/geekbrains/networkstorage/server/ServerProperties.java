package org.geekbrains.networkstorage.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ServerProperties extends Properties{
    private static final Path resourcesPath = Paths.get("org.geekbrains.networkstorage.server.Server", "resources", "server.properties");

    private static Properties properties = new Properties();

    private ServerProperties() {}

    static {
        try {
            System.out.println(resourcesPath.toFile().getAbsolutePath());
            FileReader reader = new FileReader(resourcesPath.toFile());
            properties.load(reader);
        } catch (FileNotFoundException e){
            /* TODO logging*/
            throw new ExceptionInInitializerError(e);
        } catch (IOException e){
            /* TODO logging*/
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Properties getServerProperties() {
        return properties;
    }
}
