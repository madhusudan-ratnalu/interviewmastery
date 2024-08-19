package com.epam.codemastery.InterviewX.service.impl;

import com.epam.codemastery.InterviewX.mappers.ClientMapper;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.entity.Candidate;
import com.epam.codemastery.InterviewX.model.entity.Client;
import com.epam.codemastery.InterviewX.repository.ClientRepository;
import com.epam.codemastery.InterviewX.service.ClientService;
import com.epam.codemastery.InterviewX.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Utility.setDefaultFields(clientModel);
        Client client = clientRepository.save(clientMapper.modelToEntity(clientModel));
        return clientMapper.entityToModel(client);
    }

    @Override
    public ClientModel findByClientId(ObjectId clientId) {
        Optional<Client> client;
        try {
            client = Optional.ofNullable(clientRepository.findBy_idAndIsDeleted(clientId, false).orElseThrow(() -> new BadRequestException("Invalid clientId")));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
        return  clientMapper.entityToModel(client.get());
    }

}
