package nye.guibead.storebackend.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;


@Entity
@Data
public class Store {

    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storeId;

    private double budget;

    private int storage;

    private double revenue;

    private double expenses;

    private String location;

    @OneToMany(mappedBy = "store")
    private List<Product> products;
}
