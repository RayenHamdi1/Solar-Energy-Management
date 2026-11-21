package com.solarenergy.management.graphql;

import com.solarenergy.management.entity.Client;
import com.solarenergy.management.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientGraphQLController {

    private final ClientService service;

    @QueryMapping
    public List<Client> clients() {
        return service.findAll();
    }

    @QueryMapping
    public Client client(@Argument Long id) {
        return service.findById(id);
    }

    @MutationMapping
    public Client createClient(@Argument Client input) {
        return service.create(input);
    }

    @MutationMapping
    public Client updateClient(@Argument Long id, @Argument Client input) {
        return service.update(id, input);
    }

    @MutationMapping
    public boolean deleteClient(@Argument Long id) {
        return service.delete(id);
    }
}
