package com.solarenergy.management.service;

import com.solarenergy.management.entity.Client;
import com.solarenergy.management.entity.ClientOrder;
import com.solarenergy.management.exception.ResourceNotFoundException;
import com.solarenergy.management.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
    }

    @Transactional
    public Client create(Client client) {
        if (client.getOrders() != null) {
            client.getOrders().forEach(order -> order.setClient(client));
        }
        return repository.save(client);
    }

    @Transactional
    public Client update(Long id, Client updated) {
        Client existing = findById(id);
        existing.setName(updated.getName());
        existing.setCin(updated.getCin());
        existing.setPhone(updated.getPhone());
        existing.setAddress(updated.getAddress());
        existing.setCreatedAt(updated.getCreatedAt());

        if (updated.getOrders() != null) {
            existing.getOrders().clear();
            updated.getOrders().forEach(order -> {
                order.setClient(existing);
                existing.getOrders().add(order);
            });
        }
        return repository.save(existing);
    }

    @Transactional
    public boolean delete(Long id) {
        findById(id);
        repository.deleteById(id);
        return true;
    }
}
