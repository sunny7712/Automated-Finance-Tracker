package org.fta.entities;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    @Column(nullable = false)
    private Boolean isPredefined;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

}
