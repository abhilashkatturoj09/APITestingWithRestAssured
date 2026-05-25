package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utilities.ExtentManager;
import utilities.ExtentTestManager;

public class Hooks {

    ExtentReports extent = ExtentManager.getInstance();

    @Before
    public void beforeScenario(Scenario scenario) {

        ExtentTest test =
                extent.createTest(scenario.getName());

        ExtentTestManager.setTest(test);
    }

    @After
    public void afterScenario() {

        extent.flush();
    }
}