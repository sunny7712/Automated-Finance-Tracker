package org.fta.services.categories.customcategory.impl;

import org.fta.dto.CustomCategoryDto;
import org.fta.entities.CustomCategory;
import org.fta.entities.User;
import org.fta.exceptions.ResourceNotFoundException;
import org.fta.repositories.CustomCategoryRepository;
import org.fta.repositories.UserRepository;
import org.fta.services.categories.defaultcategory.CreateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreateCategoryImpl implements CreateCategory {
    @Autowired
    private CustomCategoryRepository customCategoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createCategory(CustomCategoryDto customCategoryDto){
        User user = userRepository.findById(customCategoryDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        CustomCategory customCategory = CustomCategory.builder()
                .categoryName(customCategoryDto.getCategoryName())
                .description(customCategoryDto.getCategoryDescription())
                .user(user).build();

        customCategoryRepository.save(customCategory);

        user.getCustomCategories().add(customCategory);
        userRepository.save(user);
    }
}
