package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Applicant {
    private String name;
    private int age;
    private boolean valid;

    public Applicant(String name, int age){
        this.name = name;
        this.age = age;
        this.valid = true;
    }
}