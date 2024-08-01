package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.entity.Client;
import org.bson.types.ObjectId;

import java.util.List;

public interface ClientService {
    List<ClientModel> getClients();

    ClientModel saveClient(ClientModel clientModel);

    Client findByClientId(ObjectId clientId);
}
