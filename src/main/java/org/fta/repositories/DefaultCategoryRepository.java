package org.fta.repositories;

import org.fta.entities.DefaultCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultCategoryRepository extends JpaRepository<DefaultCategory, Long> {
}
