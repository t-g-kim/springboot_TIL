package com.example.admin.controller;

import com.example.admin.ifs.CrudInterface;
import com.example.admin.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PatchMapping("")       // /api/user
    public Header create() {
        return null;
    }

    @Override
    @GetMapping({"id"})         // pathVariable     /api/user/{id}
    public Header read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")     // /api/user
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}")      //  a/pi/user/{id}
    public Header delete(Long id) {
        return null;
    }


}
