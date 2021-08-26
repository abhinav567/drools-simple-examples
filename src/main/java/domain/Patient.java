package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private String name;

    public Patient(String name){
        this.name = name;
    }
}