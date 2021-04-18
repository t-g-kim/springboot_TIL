package com.example.admin.repository;

import com.example.admin.AdminApplicationTest;
import com.example.admin.model.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends AdminApplicationTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = new Item();
        item.setName("Notebook");
        item.setPrice(100000);
        item.setContent("gram");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    public void read() {
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);
        Assert.assertTrue(item.isPresent());
//        item.ifPresent(i -> {
//            System.out.println(i);
//        });
    }
}
