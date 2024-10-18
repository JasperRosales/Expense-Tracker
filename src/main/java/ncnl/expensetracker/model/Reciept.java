package ncnl.expensetracker.model;


import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Reciept {
    private UUID id;
    private String description;
    private Double budget;
    private Double amount;
    private LocalDate transDate;

    public Double getRemainingBudget() {
        return this.budget - this.amount;
    }

    public Reciept(String description, Double budget, Double amount, LocalDate transDate) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.budget = (budget != null && budget >= 0) ? budget : 0.0;
        this.amount = (amount != null && amount >= 0) ? amount : 0.0;
        this.transDate = transDate != null ? transDate : LocalDate.now();
    }

}
