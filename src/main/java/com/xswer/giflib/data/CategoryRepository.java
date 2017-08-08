package com.xswer.giflib.data;

import com.xswer.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Funny"),
            new Category(2, "Sport"),
            new Category(3, "Movies")
    );

    public static List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for (Category category : ALL_CATEGORIES) {
            if (id == category.getId()) {
                return category;
            }
        }
        return null;
    }
}
