package utils;

//import io.qameta.allure.Attachment;
//import io.qameta.allure.Description;
//import org.junit.rules.TestRule;
//import org.junit.runners.model.Statement;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//
//public class ScreenshotOnFailureTest implements TestRule {
//    public Statement apply(final Statement statement, final Description description) {
//        return new Statement() {
//            @Override
//            public void evaluate() throws Throwable {
//                try {
//                    statement.evaluate();
//                } catch (Throwable t) {
//                    captureScreenshot();
//                    throw t;
//                }
//            }
//
//            @Attachment
//            private byte[] captureScreenshot() {
//                try {
//                    return ((TakesScreenshot) driver).getScreenshoAs(OutputType.BYTES);
//                } catch (Exception e) {
//                    //no need to crash the tests if screenshot fails
//                }
//            }
//        };
//    }
//}

