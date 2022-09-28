package br.sc.senac.budgetech.backend.repository.client;

import br.sc.senac.budgetech.backend.projection.client.ClientNameClientProjection;
import br.sc.senac.budgetech.backend.projection.client.ClientTest;
import br.sc.senac.budgetech.backend.projection.client.ClientW10;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomClientRepositoryImpl implements CustomClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ClientTest customFindMethod(String nameClient) {
        return (ClientTest) entityManager.createQuery("Select c.cpf as cpf FROM Client c WHERE c.nameClient = :nameClient")
                .setParameter("nameClient", nameClient)
                .getSingleResult();
    }
}
