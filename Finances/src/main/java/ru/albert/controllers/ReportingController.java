package ru.albert.controllers;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.albert.models.FinanceType;
import ru.albert.service.FinanceService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportingController {

    @Autowired
    FinanceService service;


    @RequestMapping(value = "/ConsumptionReport/{sort}", method = RequestMethod.GET)
    @ResponseBody
    public void getConsumptionReport(HttpServletResponse response, @PathVariable String sort) throws JRException, IOException {
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/consumption.jrxml");
        Map<String, Object> parameters = new HashMap<String, Object>();
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(service.getListBySort(sort, FinanceType.CONSUMPTION));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=report.pdf");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    @RequestMapping(value = "/IncomeReport/{sort}", method = RequestMethod.GET)
    @ResponseBody
    public void getIncomeReport(HttpServletResponse response, @PathVariable String sort) throws JRException, IOException {
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/consumption.jrxml");
        Map<String, Object> parameters = new HashMap<String, Object>();
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(service.getListBySort(sort, FinanceType.INCOME));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=report.pdf");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

}
