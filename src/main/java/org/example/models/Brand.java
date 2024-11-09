package org.example.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "brands")
public class Brand {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

}
