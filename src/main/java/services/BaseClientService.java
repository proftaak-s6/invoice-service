package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class BaseClientService {
    private Client client = ClientBuilder.newClient();

    public Client getClient() {
        return this.client;
    }

}