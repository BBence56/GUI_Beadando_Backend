package nye.guibead.storebackend.Controller;

import nye.guibead.storebackend.Model.Product;
import nye.guibead.storebackend.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // \Create product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.ok(created);
    }

    // \Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // \Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // \Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setProductId(id);
        Product updated = productService.updateProduct(product);
        return ResponseEntity.ok(updated);
    }

    // \Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // \Buy product
    @PostMapping("/{id}/buy")
    public ResponseEntity<Void> buyProduct(@PathVariable int id, @RequestParam int quantity) {
        productService.buyProduct(id, quantity);
        return ResponseEntity.ok().build();
    }

    // \Sell product
    @PostMapping("/{id}/sell")
    public ResponseEntity<Void> sellProduct(@PathVariable int id,
                                            @RequestParam int quantity) {
        productService.sellProduct(id, quantity);
        return ResponseEntity.ok().build();
    }
}