package ru.albert.service;

import ru.albert.FinanceDto;
import ru.albert.models.CategoryType;
import ru.albert.models.Finance;
import ru.albert.models.FinanceType;

import java.util.List;

public interface FinanceService {
    int sumOfIncome();
    int sumOfConsumption();

    int sumOfCategoryType(CategoryType categoryType, FinanceType financeType, String sort);
    void addFinance(FinanceDto finance);

    List<Finance> getConsumptionsByCategory(String category);

    List<Finance> getListBySort(String sort, FinanceType financeType);
    List<Finance> getIncomeByCategory(String category);
}
