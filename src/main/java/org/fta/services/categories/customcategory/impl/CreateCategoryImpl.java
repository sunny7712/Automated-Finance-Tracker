package org.fta.services.categories.customcategory.impl;

import org.fta.dto.customcategory.CreateCustomCategoryDto;
import org.fta.entities.CustomCategory;
import org.fta.entities.User;
import org.fta.exceptions.ResourceNotFoundException;
import org.fta.repositories.CustomCategoryRepository;
import org.fta.repositories.UserRepository;
import org.fta.services.categories.customcategory.CreateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreateCategoryImpl implements CreateCategory {
    @Autowired
    private CustomCategoryRepository customCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void createCategory(CreateCustomCategoryDto createCustomCategoryDto){
        User user = userRepository.findById(createCustomCategoryDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        CustomCategory customCategory = CustomCategory.builder()
                .categoryName(createCustomCategoryDto.getCategoryName())
                .description(createCustomCategoryDto.getCategoryDescription())
                .user(user).build();

        customCategoryRepository.save(customCategory);

        user.getCustomCategories().add(customCategory);
        userRepository.save(user);
    }
}
