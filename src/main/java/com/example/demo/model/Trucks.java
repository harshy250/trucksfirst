package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trucks")
public class Trucks {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truck_id")
    private long truck_id;
    @Column(name = "space")
    private long space;
    @Column(name = "count", nullable = true)
    private long count;
}
