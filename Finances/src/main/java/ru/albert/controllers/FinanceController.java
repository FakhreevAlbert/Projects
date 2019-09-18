package ru.albert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.albert.FinanceDto;
import ru.albert.models.CategoryType;
import ru.albert.models.Finance;
import ru.albert.models.FinanceType;
import ru.albert.service.FinanceService;

import java.util.List;

@Controller
public class FinanceController {

    @Autowired
    FinanceService service;

    @GetMapping("/add_finance")
    public String getAddFinancePage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("sumIncome", service.sumOfIncome());
        model.addAttribute("sumConsumption", service.sumOfConsumption());
        return "add_finance";
    }

    @PostMapping("/finances/add")
    public String addFinanceRecord(@ModelAttribute FinanceDto financeDto) {
        service.addFinance(financeDto);
        return "redirect:/add_finance";
    }

    @GetMapping("/category_consumption")
    public String getCategoryPage(@ModelAttribute("model") ModelMap model, @RequestParam("category") String category) {
        List<Finance> finances = service.getConsumptionsByCategory(category);
        model.addAttribute("consumptions", finances);
        return "category_consumption";
    }

    @GetMapping("/category_income")
    public String getCategoryPage1(@ModelAttribute("model") ModelMap model, @RequestParam("category") String category) {
        List<Finance> finances = service.getIncomeByCategory(category);
        model.addAttribute("income", finances);
        return "category_income";
    }

    @GetMapping("/category_income_sort")
    public String getCategoryPageSortIncome(@ModelAttribute("model") ModelMap model, @RequestParam("sort") String sort) {
        List<Finance> finances = service.getListBySort(sort, FinanceType.INCOME);
        model.addAttribute("income", finances);
        return "category_income_sort";
    }

    @GetMapping("/category_consumption_sort")
    public String getCategoryPageSortConsumption(@ModelAttribute("model") ModelMap model, @RequestParam("sort") String sort) {
        List<Finance> finances = service.getListBySort(sort, FinanceType.CONSUMPTION);
        model.addAttribute("income", finances);
        return "category_consumption_sort";
    }

    @GetMapping("/consumption_pie")
    public String getCategoryPageConsumptionPie(@ModelAttribute("model") ModelMap model, @RequestParam("sort") String sort) {
        model.addAttribute("sumShop", service.sumOfCategoryType(CategoryType.SHOP, FinanceType.CONSUMPTION, sort));
        model.addAttribute("sumAuto", service.sumOfCategoryType(CategoryType.AUTO, FinanceType.CONSUMPTION, sort));
        model.addAttribute("sumEntertaiment", service.sumOfCategoryType(CategoryType.ENTERTAINMENT, FinanceType.CONSUMPTION, sort));
        model.addAttribute("sumCommunal", service.sumOfCategoryType(CategoryType.COMMUNAL, FinanceType.CONSUMPTION, sort));
        model.addAttribute("sumOther", service.sumOfCategoryType(CategoryType.OTHER, FinanceType.CONSUMPTION, sort));
        model.addAttribute("sumMedia", service.sumOfCategoryType(CategoryType.MEDIA, FinanceType.CONSUMPTION, sort));
        return "consumption_pie";
    }

    @GetMapping("/income_pie")
    public String getCategoryPageIncomePie(@ModelAttribute("model") ModelMap model, @RequestParam("sort") String sort) {
        model.addAttribute("sumShop", service.sumOfCategoryType(CategoryType.SHOP, FinanceType.INCOME, sort));
        model.addAttribute("sumAuto", service.sumOfCategoryType(CategoryType.AUTO, FinanceType.INCOME, sort));
        model.addAttribute("sumEntertaiment", service.sumOfCategoryType(CategoryType.ENTERTAINMENT, FinanceType.INCOME, sort));
        model.addAttribute("sumCommunal", service.sumOfCategoryType(CategoryType.COMMUNAL, FinanceType.INCOME, sort));
        model.addAttribute("sumOther", service.sumOfCategoryType(CategoryType.OTHER, FinanceType.INCOME, sort));
        model.addAttribute("sumMedia", service.sumOfCategoryType(CategoryType.MEDIA, FinanceType.INCOME, sort));
        return "income_pie";
    }



}
