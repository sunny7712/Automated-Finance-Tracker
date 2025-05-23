package org.fta.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class UserRole {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long roleId;

  private String name;
}
