package com.epam.codemastery.InterviewX.service;

import com.epam.codemastery.InterviewX.model.ClientModel;

import java.util.List;

public interface ClientService {
    List<ClientModel> getClients();

    ClientModel saveClient(ClientModel clientModel);
}
