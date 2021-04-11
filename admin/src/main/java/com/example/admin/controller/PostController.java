package com.example.admin.controller;

import com.example.admin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    /*
        HTML <Form>
        ajax 검색
        http post body -> data

        json, xml, multipart-form(file), text-plain
     */

    @PostMapping("/postMethod") // @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping
    public void put() {

    }

    @PatchMapping
    public void path() {

    }


}
