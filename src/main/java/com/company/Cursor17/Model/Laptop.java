package com.company.Cursor17.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Laptop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "cpu_brand")
    private String cpuBrand;
    @Column(name = "cpu_model")
    private String cpuModel;
    @Column(name = "memory_ram")
    private Integer ram;
    @Column(name = "memory_hdd")
    private Integer hddCapacity;
    @Column(name ="second_hand")
    private boolean secondHand;
    @Column(name ="case_material")
    private String caseMaterial;
    @Column(name ="price")
    private double price;
    @Column(name ="date", nullable = false)
    private Date productionDate;
}
