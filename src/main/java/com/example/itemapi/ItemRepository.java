package com.example.itemapi;

// import com.example.itemapi.model.Item;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {
    private final List<Item> items = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public List<Item> findAll() {
        return new ArrayList<>(items);
    }
    
    public Optional<Item> findById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
    
    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(idGenerator.getAndIncrement());
        }
        items.add(item);
        return item;
    }
}

