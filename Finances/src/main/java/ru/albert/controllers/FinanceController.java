package ru.albert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import ru.albert.FinanceDto;
import ru.albert.models.Finance;
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



}
