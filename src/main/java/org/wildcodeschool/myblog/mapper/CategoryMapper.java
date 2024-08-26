package org.wildcodeschool.myblog.mapper;

import org.springframework.stereotype.Component;
import org.wildcodeschool.myblog.dto.CategoryDTO;
import org.wildcodeschool.myblog.model.Category;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        if (category.getArticles() != null) {
            categoryDTO.setArticles(category.getArticles().stream()
                    .map(article -> {
                        ArticleMapper articleMapper = new ArticleMapper();
                        return articleMapper.convertToDTO(article);
                    })
                    .collect(Collectors.toList()));
        }
        return categoryDTO;
    }
}