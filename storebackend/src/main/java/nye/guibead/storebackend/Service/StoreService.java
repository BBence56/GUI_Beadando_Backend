package nye.guibead.storebackend.Service;

import nye.guibead.storebackend.Model.Store;
import nye.guibead.storebackend.Repo.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    // Create new store
    public Store createStore(Store store){
        return storeRepository.save(store);
    }

    // Get all stores
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    // Get store by ID
    public Store getStoreById(int id) {
        return  storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found (id = " + id + ")"));
    }

    // Update store data (budget, storage, revenue, expenses)
    public Store updateStore(int id, Store updated) {
        Store existing = getStoreById(id);

        existing.setBudget(updated.getBudget());
        existing.setStorage(updated.getStorage());
        existing.setRevenue(updated.getRevenue());
        existing.setExpenses(updated.getExpenses());
        existing.setProducts(updated.getProducts());

        return storeRepository.save(existing);
    }

    // Update store capacity (storage)
    public Store updateStoreStorage(int id, int newStorage) {
        Store store = getStoreById(id);
        store.setStorage(newStorage);
        return  storeRepository.save(store);
    }

    // Delete store
    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }
}
