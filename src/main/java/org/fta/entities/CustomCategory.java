package org.fta.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
@Table(name = "custom_category")
public class CustomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "custom_category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;
}
