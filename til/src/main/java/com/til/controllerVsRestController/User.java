package com.til.controllerVsRestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long id;

    private String name;

    private String number;

    private String address;
}
