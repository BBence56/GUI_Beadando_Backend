package nye.guibead.storebackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class Product {

    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String Category;

    private String Name;

    private double buyingPrice;

    private double sellingPrice;

    private int stock;

    private String description;
}
