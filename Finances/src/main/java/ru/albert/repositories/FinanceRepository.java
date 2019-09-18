package ru.albert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.albert.models.CategoryType;
import ru.albert.models.Finance;
import ru.albert.models.FinanceType;

import java.time.LocalDateTime;
import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Integer> {
  //  List<Finance> findAllByCategoryTypeOrderByIdDesc(CategoryType type);
  List<Finance> findAllByFinanceTypeOrderByTimeDesc(FinanceType type);

  List<Finance> findAllByCategoryTypeAndFinanceTypeOrderByTimeDesc(CategoryType categoryType, FinanceType financeType);

  @Query("select f from Finance f where f.time >= :time and f.financeType = :financeType order by f.time")
  List<Finance> findAllBySortType(@Param("time") LocalDateTime time, @Param("financeType") FinanceType financeType);

  //@Query("select f from Finance f where f.time > :start and f.time < :endDate and f.financeType = :financeType and f.categoryType = :categoryType")
  List<Finance> findAllByCategoryTypeAndFinanceTypeAndTimeBetweenOrderByTimeDesc(CategoryType categoryType, FinanceType financeType, LocalDateTime start, LocalDateTime endDate);

}
