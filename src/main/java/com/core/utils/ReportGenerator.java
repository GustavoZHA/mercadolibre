package com.core.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    public static void generateReport() {
        File reportOutputDirectory = new File("build/cucumber");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("build/cucumber/cucumber.json");
        String projectName = "Accounting Module";
        Configuration configuration = configurationInformation(reportOutputDirectory, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }

    private static Configuration configurationInformation(File reportDirectory, String projectName) {
        Configuration configuration = new Configuration(reportDirectory, projectName);
        configuration.addClassifications("System", System.getProperty("os.name"));
        configuration.addClassifications("Branch", "develop");
        configuration.addClassifications("Execute", "LOCAL");
        return configuration;
    }
}
