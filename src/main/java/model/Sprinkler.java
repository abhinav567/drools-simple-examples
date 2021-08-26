package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sprinkler {
    private Room room;
    private boolean on;
    // Getter and setter methods

    public Sprinkler(Room room){
        this.room = room;
        this.on = false;
    }
}