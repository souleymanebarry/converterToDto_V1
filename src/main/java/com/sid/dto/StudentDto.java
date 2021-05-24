package com.sid.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private Long id;
    private String name;
    private String username;
    private String password;
    private AddressDto address;
}
