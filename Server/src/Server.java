import java.util.Properties;

public class Server {
    private final Properties serverProperties;

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    public Server() {
        serverProperties = getServerProperties();
    }

    private void run(){

    }
}
