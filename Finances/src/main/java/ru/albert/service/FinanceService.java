package ru.albert.service;

import ru.albert.FinanceDto;
import ru.albert.models.Finance;

import java.util.List;

public interface FinanceService {
    int sumOfIncome();
    int sumOfConsumption();
    void addFinance(FinanceDto finance);

    List<Finance> getConsumptionsByCategory(String category);
    List<Finance> getIncomeByCategory(String category);
}
