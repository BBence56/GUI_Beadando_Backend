package nye.guibead.storebackend.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private int productId;

    @NonNull
    private String Category;

    @NonNull
    private String Name;

    private double buyingPrice;

    private double sellingPrice;


    private int stock;


    private String description;


    public Product() {}
}
