package com.example.mswallet.CiruitBreaker;

import com.example.mswallet.Dto.CategoryDTO;
import com.example.mswallet.Dto.SubcategoryDTO;
import com.example.mswallet.Feign.CategoryFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CategoryFeignFallback implements CategoryFeignClient {

    @Override
    public CategoryDTO getCategoryById(Long id) {
        log.warn("⚠️ ms-categories no disponible — devolviendo categoría dummy con id={}", id);
        return CategoryDTO.builder()
                .id(id)
                .name("Categoría desconocida")
                .icon("help-circle")
                .color("#BDBDBD")
                .build();
    }

    @Override
    public SubcategoryDTO getSubcategoryById(Long categoryId, Long subcategoryId) {
        log.warn("⚠️ ms-categories no disponible — devolviendo subcategoría dummy con id={}", subcategoryId);
        return SubcategoryDTO.builder()
                .id(subcategoryId)
                .categoryId(categoryId)
                .name("Subcategoría desconocida")
                .build();
    }

    @Override
    public List<CategoryDTO> getCategoriesByUser(Long userId) {
        log.warn("⚠️ ms-categories no disponible — devolviendo lista vacía para userId={}", userId);
        return List.of();
    }
}
