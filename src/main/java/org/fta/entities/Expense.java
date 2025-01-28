package org.fta.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String expenseId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime expenseDateTime;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category expenseCategory;

    @Column(nullable = false)
    private BigDecimal expenseAmount;

    @Column(nullable = true)
    private String expenseDescription;
}
