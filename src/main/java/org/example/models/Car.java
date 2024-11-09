package org.example.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Color;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Id
    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "chassis_number")
    private String chassisNumber;

    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private Brand brand;

    private Color color;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<TestDriver> testDrivers;

    @CreatedDate
    @Column(name="creation_date")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
}
