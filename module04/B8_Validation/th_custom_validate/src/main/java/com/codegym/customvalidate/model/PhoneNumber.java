package com.codegym.customvalidate.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;


@Component
public class PhoneNumber {
    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)", message = "Dien thoai phai dung dinh dang")
   private String number;

    public PhoneNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
