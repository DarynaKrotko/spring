package com.owu.spring.models;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car_table")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String producer;
    private int power;

    public Car(String model, String producer, int power) {
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
