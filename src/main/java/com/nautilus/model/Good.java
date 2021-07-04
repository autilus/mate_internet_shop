package com.nautilus.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long count;
    private Double price;
    @Type(type = "text")
    private String description;
    @Column(updatable = false)
    private LocalDateTime added;
}
