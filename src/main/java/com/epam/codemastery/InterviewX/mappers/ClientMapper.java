package com.epam.codemastery.InterviewX.mappers;

import com.epam.codemastery.InterviewX.config.MapperConfig;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.model.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapperConfig.class)
public abstract class ClientMapper {
    public abstract List<ClientModel> clientEntityListToModelList(List<Client> clients);

    public abstract Client modelToEntity(ClientModel clientModel);

    public abstract ClientModel entityToModel(Client client);
}
