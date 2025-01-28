package org.fta.services.impl;


import org.fta.dto.CustomCategoryDto;
import org.fta.entities.Category;
import org.fta.entities.User;
import org.fta.exceptions.ResourceNotFoundException;
import org.fta.repositories.CategoryInfoRepository;
import org.fta.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AddCustomCategoryImpl {
    @Autowired
    private CategoryInfoRepository categoryInfoRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Transactional
    public void addCategory(CustomCategoryDto customCategoryDto){
        User user = userInfoRepository.findById(customCategoryDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Category customCategory = Category.builder()
                .categoryName(customCategoryDto.getCategoryName())
                .isPredefined(Boolean.FALSE)
                .user(user).build();

        categoryInfoRepository.save(customCategory);

        user.getCustomCategories().add(customCategory);
        userInfoRepository.save(user);
    }
}
