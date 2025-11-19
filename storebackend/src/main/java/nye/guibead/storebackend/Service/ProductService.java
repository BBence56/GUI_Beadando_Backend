package nye.guibead.storebackend.Service;

import nye.guibead.storebackend.Model.Product;
import nye.guibead.storebackend.Repo.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    // \Create
    public Product createProduct(Product product) {
        return productRepository.save(product);
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