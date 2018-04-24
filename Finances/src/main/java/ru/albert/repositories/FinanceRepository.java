package ru.albert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.albert.models.CategoryType;
import ru.albert.models.Finance;
import ru.albert.models.FinanceType;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Integer> {
    List<Finance> findAllByCategoryTypeOrderByIdDesc(CategoryType type);
    List<Finance> findAllByFinanceType(FinanceType type);
    List<Finance> findAllByCategoryTypeAndFinanceTypeOrderByIdDesc(CategoryType categoryType, FinanceType financeType);
}
