package az.nokia.nokia.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "blogs")
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
}
