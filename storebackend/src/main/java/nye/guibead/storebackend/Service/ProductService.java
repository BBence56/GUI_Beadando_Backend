package nye.guibead.storebackend.Service;

import nye.guibead.storebackend.Model.Product;
import nye.guibead.storebackend.Repo.ProductRepository;
import nye.guibead.storebackend.Repo.StoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public ProductService(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    // \Buy product
    public void buyProduct(int id, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Product with id " + id + " not found.");
        }
        Product product = optionalProduct.get();
        double totalCost = product.getBuyingPrice() * quantity;
        product.setStock(product.getStock() + quantity);
        productRepository.save(product);
        storeRepository.findAll().forEach(store -> {
            store.setBudget(store.getBudget() - totalCost);
            store.setExpenses(store.getExpenses() + totalCost);
            storeRepository.save(store);
        });
    }

    // \Sell product
    public void sellProduct(int id, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Product with id " + id + " not found.");
        }
        Product product = optionalProduct.get();
        double totalCost = product.getSellingPrice() * quantity;
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
        storeRepository.findAll().forEach(store -> {
            store.setBudget(store.getBudget() + totalCost);
            store.setRevenue(store.getRevenue() + totalCost);
            storeRepository.save(store);
        });
    }

    // \Create
    public Product createProduct(Product product) {
        //todo
    }


    // \Read all
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // \Read by id
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // \Update
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // \Delete by id
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}