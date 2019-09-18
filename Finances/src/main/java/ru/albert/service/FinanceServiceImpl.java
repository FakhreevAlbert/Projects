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
        List<Finance> finances = financeRepository.findAllByFinanceTypeOrderByTimeDesc(FinanceType.INCOME);
        int sumOfIncome = 0;

        for (Finance finance : finances) {
            sumOfIncome += finance.getSum();
        }

        return sumOfIncome;
    }

    @Override
    public int sumOfConsumption() {
        List<Finance> finances = financeRepository.findAllByFinanceTypeOrderByTimeDesc(FinanceType.CONSUMPTION);

        int sumOfConsumption = 0;

        for (Finance finance : finances){
            sumOfConsumption += finance.getSum();

        }

        return sumOfConsumption;
    }

    @Override
    public int sumOfCategoryType(CategoryType categoryType, FinanceType financeType, String sort) {

        int sum = 0;
        LocalDateTime start = null;
        LocalDateTime end = null;
        List<Finance> finances;

        switch (sort) {
            case "0":
                start = getDate(0, true);
                end = getDate(0, false);
                break;
            case "-1":
                start = getDate(1, true);
                end = getDate(1, false);
                break;
            case "-2":
                start = getDate(2, true);
                end = getDate(2, false);
                break;
            case "-3":
                start = getDate(3, true);
                end = getDate(3, false);
                break;
            case "-4":
                start = getDate(4, true);
                end = getDate(4, false);
                break;
            case "-5":
                start = getDate(5, true);
                end = getDate(5, false);
                break;
        }
        if (start != null && end != null) {
            finances = financeRepository.findAllByCategoryTypeAndFinanceTypeAndTimeBetweenOrderByTimeDesc(categoryType, financeType, start, end);
        } else {
            finances = financeRepository.findAllByCategoryTypeAndFinanceTypeOrderByTimeDesc(categoryType, financeType);
        }

        for (Finance finance : finances) {
            sum += finance.getSum();

        }
        return sum;
    }

    private LocalDateTime getDate(int sort, boolean start) {
        LocalDateTime startDate;
        LocalDateTime endDate;
        if (LocalDateTime.now().getMonthValue() - sort >= 0) {
            startDate = LocalDateTime.now().withDayOfMonth(1).minusMonths(sort);
        } else {
            startDate = LocalDateTime.now().withDayOfMonth(1).minusMonths(sort).minusYears(1);
        }

        if (startDate.getMonthValue() != 2) {
            endDate = startDate.withDayOfMonth(startDate.getMonth().maxLength());
        } else {
            endDate = startDate.withDayOfMonth(28);
        }


        if (start) {
            return startDate;
        } else {
            return endDate;
        }
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
        return financeRepository.findAllByCategoryTypeAndFinanceTypeOrderByTimeDesc(CategoryType.valueOf(category), FinanceType.CONSUMPTION);
    }

    @Override
    public List<Finance> getListBySort(String sort, FinanceType financeType) {
        LocalDateTime date = null;

        switch (sort) {
            case "DAY":
                date = LocalDateTime.now().minusDays(1);
                break;
            case "WEEK":
                date = LocalDateTime.now().minusWeeks(1);
                break;
            case "MONTH":
                date = LocalDateTime.now().minusMonths(1);
                break;
            case "YEAR":
                date = LocalDateTime.now().minusYears(1);
                break;
            case "ALL":
                return financeRepository.findAllByFinanceTypeOrderByTimeDesc(financeType);

        }
        if (date != null) {
            return financeRepository.findAllBySortType(date, financeType);
        } else {
            return financeRepository.findAllByFinanceTypeOrderByTimeDesc(financeType);
        }
    }

    @Override
    public List<Finance> getIncomeByCategory(String category) {
        return financeRepository.findAllByCategoryTypeAndFinanceTypeOrderByTimeDesc(CategoryType.valueOf(category), FinanceType.INCOME);
    }
}
