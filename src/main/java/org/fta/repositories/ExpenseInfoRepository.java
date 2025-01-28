package org.fta.repositories;

import org.fta.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseInfoRepository extends JpaRepository<Expense, String> {
}
