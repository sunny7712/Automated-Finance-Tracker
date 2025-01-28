package org.fta.repositories;

import org.fta.entities.CustomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomCategoryRepository extends JpaRepository<CustomCategory, Long> {
}
