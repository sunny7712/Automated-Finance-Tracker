package org.fta.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
@Table(name = "default_category")
public class DefaultCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    @Column(nullable = true)
    private String description;

    @OneToMany(mappedBy = "default_category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;
}
