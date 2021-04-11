package com.example.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;



//    public SearchParam() {
//
//    }
//
//    public SearchParam(String account) {
//        this.account = account;
//    }
//
//    public SearchParam(String account, String email, int page) {
//        this.account = account;
//        this.email = email;
//        this.page = page;
//    }
//
//    // { "account" : "", "email" : "", "page" : 0}
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
}
