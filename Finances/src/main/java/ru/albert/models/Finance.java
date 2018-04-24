package ru.albert.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "finances_db")
public class Finance {

    transient private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private String stringTime;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime time;
    private int sum;
    private  String description;



    @Enumerated(EnumType.STRING)
    private FinanceType financeType;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    public Finance() {
    }

    public Finance(LocalDateTime rawTime , int sum, FinanceType financeType, CategoryType categoryType, String description) {
        this.time = rawTime;
        this.stringTime = rawTime.format(formatter);
        this.sum = sum;
        this.description = description;



        this.financeType = financeType;
        this.categoryType = categoryType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FinanceType getFinanceType() {
        return financeType;
    }

    public void setFinanceType(FinanceType financeType) {
        this.financeType = financeType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getStringTime() {
        return stringTime;
    }
}
