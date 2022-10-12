package Hook;

import org.junit.After;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

//public class AllureHelper implements AfterTestExecutionCallback {
//    @Override
//    public void afterTestExecution(ExtensionContext extensionContext) {
//        Boolean testFailed= extensionContext.getExecutionException().isPresent();
//        if(testFailed) {
//            CustomAllureSelenide.getScreenshotBytes().ifPresent((bytes)) ->{
//                Allure.getLifeCycle().addAttachment("Screenshot"; "image/png", "png", bytes);
//            });
//        }
//    }
//    public void afterTestExecution() {
//        CustomAllureSelenide.getScreenshotBytes().ifPresent((bytes)) ->{
//            Allure.getLifeCycle().addAttachment("Screenshot"; "image/png", "png", bytes);
//        });
//        }
//    }
