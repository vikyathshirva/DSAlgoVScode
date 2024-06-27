package TestLibrary;
import java.util.ArrayList;
import java.util.List;

public class SimpleTestLibrary {

    private List<TestCase> testCases = new ArrayList<>();

    // Functional interface for test cases
    interface TestCase {
        void runTest();
    }

    // Method to define a test case
    public void test(String testName, Runnable testLogic) {
        testCases.add(() -> {
            try {
                testLogic.run();
                System.out.println("Test Passed: " + testName);
            } catch (AssertionError e) {
                System.out.println("Test Failed: " + testName);
                System.out.println("Reason: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Test Failed: " + testName);
                System.out.println("Unexpected Exception: " + e.getMessage());
            }
        });
    }

    // Method to execute all stored test cases
    public void runTests() {
        System.out.println("===== Running All Tests =====");
        for (TestCase testCase : testCases) {
            testCase.runTest();
        }
    }

    // Assertion method for comparing expected and actual values
    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }
}

