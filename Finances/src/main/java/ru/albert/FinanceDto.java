package ru.albert;

public class FinanceDto {
    private String financeType;
    private String categoryType;
    private int sum;
    private String description;



    public FinanceDto() {
    }

    public FinanceDto(String financeType, String categoryType, int sum, String description) {
        this.financeType = financeType;
        this.categoryType = categoryType;
        this.sum = sum;
        this.description = description;


    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
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
}
