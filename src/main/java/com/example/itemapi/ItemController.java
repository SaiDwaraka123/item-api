package com.example.itemapi;

// import com.example.itemapi.model.Item;
// import com.example.itemapi.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepository;
    
    /**
     * Get all items
     */
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    /**
     * Get item by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    /**
     * Add new item
     */
    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item savedItem = itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }
}

