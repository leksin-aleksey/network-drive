import java.util.Properties;

public class ServerProperties extends Properties {
    private final Properties properties;

    public ServerProperties(int port) {
        
        this.properties = port;
    }

    public Properties getServerProperties() {
        return properties;
    }
}
