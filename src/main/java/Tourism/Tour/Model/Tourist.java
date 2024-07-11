package Tourism.Tour.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



   
@Entity
@Table(name = "Tourist")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String language;
    private String email;
    private String phone;
    private String country;
    private String fullName;
}

