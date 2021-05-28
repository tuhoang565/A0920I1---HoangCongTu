package com.codegym.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class User {
//    Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự
//
//    Phonenumber đúng quy tắc của sđt
//
//    Age >=18
//
//    Email đúng quy tắc của email
    @NotBlank(message = "Bat buoc nhap")
    @Size(min = 2, max = 7, message = "Toi thieu 2 ki tu, toi da 7 ki tu")
    private String firstname;

    @NotBlank(message = "Bat buoc nhap")
    @Size(min = 2, max = 45, message = "Toi thieu 2 ki tu, toi da 45 ki tu")
    private String lastname;

    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)", message = "Dien thoai phai dung dinh dang")
    private String phoneNumber;

    @Min(value = 18, message = "Tuoi >= 18")
    @Max(value = 120, message = "Tuoi < 120")
    private int age;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email phai dung dinh dang abc@abc.xyz")
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
