package com.owu.spring.models;


import com.fasterxml.jackson.annotation.JsonView;
import com.owu.spring.views.Views;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "car_table")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(value = Views.Level1.class)
    private int id;
    @JsonView(value = {Views.Level1.class,Views.Level2.class, Views.Level3.class})

    private String model;
    @JsonView(value = {Views.Level1.class, Views.Level2.class, Views.Level3.class})

    private String producer;
    @Min(value = 0, message = "power cannot be lower than 0")
    @Max(value = 1100, message = "power cannot be higher than 1100")
    @JsonView(value = {Views.Level1.class, Views.Level2.class})
    private int power;

    public Car(String model, String producer, int power) {
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
