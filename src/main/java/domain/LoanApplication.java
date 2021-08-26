package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanApplication {
    private int amount;
    private boolean approved;

    public LoanApplication(int amount){
        this.amount = amount;
        this.approved = false;
    }
}