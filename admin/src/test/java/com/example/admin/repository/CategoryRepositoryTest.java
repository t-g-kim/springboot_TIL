package com.example.admin.repository;

import com.example.admin.AdminApplicationTest;
import com.example.admin.model.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends AdminApplicationTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void create() {
        String type = "COMPUTER";

        String title = "컴퓨퓨터";

        LocalDateTime createdAt = LocalDateTime.now();

        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory); // newCategory는 null이 아니다.
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read() {

//        Optional<Category> optionalCategory = categoryRepository.findById(1L);

        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);
        // select * from category where type = "COMPUTER"
        optionalCategory.ifPresent(c -> {

            Assert.assertEquals(c.getType(), type);

            System.out.println(c.getId());
            System.out.println(c.getTitle());
            System.out.println(c.getType());
        });

    }
}
