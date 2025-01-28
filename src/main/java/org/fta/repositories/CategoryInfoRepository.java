package org.fta.repositories;

import org.fta.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryInfoRepository extends JpaRepository<Category, Long> {
}
