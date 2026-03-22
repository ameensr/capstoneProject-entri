package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestProgressListener implements ITestListener {

    private int totalTests;
    private int executedTests = 0;

    @Override
    public void onStart(ITestContext context) {
        totalTests = context.getAllTestMethods().length;
        System.out.println("Total Test Cases: " + totalTests);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        printProgress(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        printProgress(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        printProgress(result, "SKIPPED");
    }

    private void printProgress(ITestResult result, String status) {
        executedTests++;
        int percentage = (executedTests * 100) / totalTests;

        System.out.println("Test: " + result.getName() + " → " + status);
        System.out.println("Progress: " + percentage + "%");
        System.out.println("----------------------------------");
    }
}