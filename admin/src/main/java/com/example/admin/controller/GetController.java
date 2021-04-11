package com.example.admin.controller;

import com.example.admin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    // localhost:8080/api/getParameter
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {

        return "HI get method";
    }

    // localhost:8080/api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam String password) { // @RequestParam(name ="password") String pwd
        System.out.println("id : " + id);
        System.out.println("pw : " + password);

        return id+password;
    }

    // localhost:8080/api/getMultiParameter?account=abcd&email=abc@gmail.com&page=10
    @RequestMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }
}
