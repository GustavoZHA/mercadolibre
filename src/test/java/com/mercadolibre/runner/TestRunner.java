package com.mercadolibre.runner;

import com.core.utils.ReportGenerator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        glue = {"mercadolibre"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    private static final Logger logger = LogManager.getLogger(TestRunner.class);

    @AfterTest
    public void afterExecution() {
        ReportGenerator.generateReport();
    }
}
