package com.example.mswallet.Feign;

import com.example.mswallet.Dto.CategoryDTO;
import com.example.mswallet.Dto.SubcategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-categories-service", path = "/categories")
public interface CategoryFeignClient {
    
    @GetMapping("/{id}")
    CategoryDTO getCategoryById(@PathVariable("id") Long id);

    @GetMapping("/{categoryId}/subcategories/{subId}")
    SubcategoryDTO getSubcategoryById(
        @PathVariable("categoryId") Long categoryId,
        @PathVariable("subId") Long subcategoryId
    );
    
    @GetMapping("/user/{userId}")
    List<CategoryDTO> getCategoriesByUser(@PathVariable("userId") Long userId);
}