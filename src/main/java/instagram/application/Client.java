package instagram.application;

/**
 * Created by home on 29.08.2015.
 * Класс в котором содержится информация о клиентах-приложениях instagram
 */
public class Client {
    private String clientId;
    private String clientSecret;
    private String clientName;
    public Client (String client_name, String client_id,String client_secret) {
        this.clientId = client_id;
        this.clientSecret = client_secret;
        this.clientName = client_name;
    }

    public String getClientId () {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientName() {
        return clientName;
    }
}
