package com.epam.codemastery.InterviewX.controller;

import com.epam.codemastery.InterviewX.model.CandidateModel;
import com.epam.codemastery.InterviewX.model.ClientModel;
import com.epam.codemastery.InterviewX.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    /**
     * This API will return all clients
     *@return List<ClientModel>
     */
    @GetMapping()
    public List<ClientModel> getClients() {
        return clientService.getClients();
    }

    /**
     * This API will store new client details.
     * @param clientModel
     * @return clientModel
     */
    @PostMapping()
    public ClientModel saveClient(@RequestBody ClientModel clientModel) {
        return clientService.saveClient(clientModel);
    }

    @GetMapping("/{id}")
    public ClientModel getClientById(@PathVariable ObjectId id) {
        return clientService.findByClientId(id);
    }
}
