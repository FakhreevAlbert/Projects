package ru.albert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.albert.FinanceDto;
import ru.albert.models.CategoryType;
import ru.albert.models.Finance;
import ru.albert.models.FinanceType;
import ru.albert.repositories.FinanceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    @Override
    public int sumOfIncome() {
        List<Finance> finances  = financeRepository.findAllByFinanceType(FinanceType.INCOME);
        int sumOfIncome = 0;

        for (Finance finance : finances) {
            sumOfIncome += finance.getSum();
        }

        return sumOfIncome;
    }

    @Override
    public int sumOfConsumption() {
        List<Finance> finances = financeRepository.findAllByFinanceType(FinanceType.CONSUMPTION);

        int sumOfConsumption = 0;

        for (Finance finance : finances){
            sumOfConsumption += finance.getSum();

        }

        return sumOfConsumption;
    }

    @Override
    public void addFinance(FinanceDto finance) {
        Finance model = new Finance(
                LocalDateTime.now(),
                finance.getSum(),
                FinanceType.valueOf(finance.getFinanceType()),
                CategoryType.valueOf(finance.getCategoryType()),
                finance.getDescription()

        );
        financeRepository.save(model);
    }

    @Override
    public List<Finance> getConsumptionsByCategory(String category) {
        return financeRepository.findAllByCategoryTypeAndFinanceTypeOrderByIdDesc(CategoryType.valueOf(category), FinanceType.CONSUMPTION);
    }

    @Override
    public List<Finance> getIncomeByCategory(String category) {
        return financeRepository.findAllByCategoryTypeAndFinanceTypeOrderByIdDesc(CategoryType.valueOf(category), FinanceType.INCOME);
    }
}
