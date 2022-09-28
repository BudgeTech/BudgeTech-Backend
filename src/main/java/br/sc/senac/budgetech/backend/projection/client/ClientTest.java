package br.sc.senac.budgetech.backend.projection.client;

public class ClientTest {

    private String nameClient;

    public ClientTest(ClientNameClientProjection clientNameClientProjection) {
        nameClient = clientNameClientProjection.nameClient();
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}
