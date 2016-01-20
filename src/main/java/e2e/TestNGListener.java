package e2e;

import org.testng.*;


public class TestNGListener implements ISuiteListener, ITestListener, IConfigurationListener {

	@Override
	public void onStart(ISuite suite) {
	}

	@Override
	public void onFinish(ISuite suite) {

	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String screenshotName = ScreenshotUtils.takeScreenshot();
		Reporter.log("<b style=\"color: red;\">" + methodName + " FAILED</b>");
		Reporter.log("<a href=\"" + screenshotName + "\">Screenshot:</a>");
		Reporter.log("<br /><img  width=\"300\" src=\"" + screenshotName + "\" /><br />");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String screenshotName = ScreenshotUtils.takeScreenshot();
		Reporter.log("<b style=\"color: green;\">" + methodName + " SUCCESS</b>");
		Reporter.log("<a href=\"" + screenshotName + "\">Screenshot:</a>");
		Reporter.log("<br /><img  width=\"300\" src=\"" + screenshotName + "\" /><br />");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {

	}
}