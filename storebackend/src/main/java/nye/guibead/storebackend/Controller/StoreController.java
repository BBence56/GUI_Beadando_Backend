package nye.guibead.storebackend.Controller;

import nye.guibead.storebackend.Model.Store;
import nye.guibead.storebackend.Service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // Get all stores
    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    // Get store by ID
    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable int id) {
        Store store = storeService.getStoreById(id);
        return ResponseEntity.ok(store);
    }

    // Create new store
    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store created = storeService.createStore(store);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Update store data
    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable int id,
                                             @RequestBody Store store) {
        Store updated = storeService.updateStore(id, store);
        return ResponseEntity.ok(updated);
    }

    // Update store capacity (storage)
    @PatchMapping("/{id}/storage")
    public ResponseEntity<Store> updateStoreStorage(@PathVariable int id,
                                                     @RequestBody int newStorage) {
        Store updated = storeService.updateStoreStorage(id, newStorage);
        return ResponseEntity.ok(updated);
    }

    // Delete store
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}
