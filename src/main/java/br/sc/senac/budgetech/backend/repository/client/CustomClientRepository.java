package br.sc.senac.budgetech.backend.repository.client;

import br.sc.senac.budgetech.backend.model.client.Client;
import br.sc.senac.budgetech.backend.projection.client.ClientNameClientProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientTest;
import br.sc.senac.budgetech.backend.projection.client.ClientW10;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomClientRepository {

    ClientTest customFindMethod(String nameClient);
}
