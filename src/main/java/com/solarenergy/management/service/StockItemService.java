package com.solarenergy.management.service;

import com.solarenergy.management.entity.StockItem;
import com.solarenergy.management.exception.ResourceNotFoundException;
import com.solarenergy.management.repository.StockItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockItemService {

    private final StockItemRepository repository;

    public List<StockItem> findAll() {
        return repository.findAll();
    }

    public StockItem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockItem not found with id: " + id));
    }

    public StockItem create(StockItem item) {
        return repository.save(item);
    }

    public StockItem update(Long id, StockItem updated) {
        StockItem existing = findById(id);
        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setQty(updated.getQty());
        existing.setMinQty(updated.getMinQty());
        existing.setPrice(updated.getPrice());
        existing.setSupplier(updated.getSupplier());
        existing.setLocation(updated.getLocation());
        return repository.save(existing);
    }

    public boolean delete(Long id) {
        findById(id);
        repository.deleteById(id);
        return true;
    }
}
