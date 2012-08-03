package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestFragmentNavigation extends
ActivityInstrumentationTestCase2<CheckinNativeActivity> {

	TestCheckin checkin;
	private Solo solo;
	Activity mActivity;
	Boolean waitLoading;

	public TestFragmentNavigation() {
		super("checkinforgood.com", CheckinNativeActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	protected void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}
	public void testTopNavigation() {

		// solo.waitForActivity(solo.getCurrentActivity().getClass()
		// .getSimpleName());
		// solo.assertCurrentActivity("in context of CheckinNativeActivity",
		// CheckinNativeActivity.class);
		// assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
		// .getClass().getSimpleName());
		//
		// ArrayList<ListView> oldList = solo.getCurrentListViews();
		// oldList = solo.getCurrentListViews();
		//
		// solo.clickOnText("Businesses");
		// assertNotSame("Clicked Businesses Tab", solo.getCurrentListViews(),
		// oldList);
		//
		// solo.waitForDialogToClose(2000);
		//
		// solo.clickOnText("Causes");
		// assertNotSame("Clicked Causes Tab", solo.getCurrentListViews(),
		// oldList);
		//
		// solo.waitForDialogToClose(2000);
		//
		// solo.clickOnText("Settings");
		// assertNotSame("Clicked Settings Tab", solo.getCurrentListViews(),
		// oldList);
		//
		solo.waitForDialogToClose(5000);
		// //////////////////////
		solo.waitForActivity("CheckinNativeActivity", 2000);

		// ArrayList<ListView> oldList = solo.getCurrentListViews();
		solo.clickOnText("Causes");
		// assertNotSame("Clicked Causes Tab", solo.getCurrentListViews(),
		// oldList);

		// oldList = solo.getCurrentListViews();
		solo.waitForActivity("CheckinNativeActivity", 2000);
		solo.clickOnText("Settings");
		solo.sleep(2000);
		// assertNotSame("Clicked Settings Tab", solo.getCurrentListViews(),
		// oldList);

		// oldList = solo.getCurrentListViews();
		solo.clickOnText("Businesses");
		solo.waitForActivity("CheckinNativeActivity", 2000);
		// assertNotSame("Clicked Businesses Tab", solo.getCurrentListViews(),
		// oldList);

		solo.assertCurrentActivity("activity should be this",
				CheckinNativeActivity.class);
		assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
				.getClass().getSimpleName());
	}
}
