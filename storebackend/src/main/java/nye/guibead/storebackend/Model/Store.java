package nye.guibead.storebackend.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;



@Entity
@Data
public class Store {

    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storeId;
}
