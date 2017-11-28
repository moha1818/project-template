package com.gttown.template.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

public class TemplateModel {
    @Max(10)
    private Integer a;
    @Length(min = 1, max = 10)
    private String input;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
