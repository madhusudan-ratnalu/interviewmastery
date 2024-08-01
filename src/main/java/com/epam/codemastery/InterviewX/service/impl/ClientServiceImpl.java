package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.ClientMapper;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.entity.Client;
import com.epam.codemastery.InterviewX.repository.ClientRepository;
import com.epam.codemastery.InterviewX.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Override
    public List<ClientModel> getClients() {
        List<Client> clientModelList = clientRepository.findAll();
        return clientMapper.clientEntityListToModelList(clientModelList);
    }

    @Override
    public ClientModel saveClient(ClientModel clientModel) {
        setDefaultFields(clientModel);
        Client client = clientRepository.save(clientMapper.modelToEntity(clientModel));
        return clientMapper.entityToModel(client);
    }

    @Override
    public Client findByClientId(ObjectId clientId) {
        try {
            return clientRepository.findBy_idAndIsDeleted(clientId, false).orElseThrow(() -> new BadRequestException("Invalid clientId"));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    private void setDefaultFields(ClientModel client) {
        client.setDateCreated(new Date());
        client.setDateModified(new Date());
        client.setIsDeleted(false);
    }
}
