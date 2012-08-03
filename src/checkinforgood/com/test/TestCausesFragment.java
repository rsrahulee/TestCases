package checkinforgood.com.test;

import java.util.ArrayList;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestCausesFragment extends
		ActivityInstrumentationTestCase2<CheckinNativeActivity> {

	TestCheckin checkin;
	private Solo solo;
	Activity mActivity;
	Boolean waitLoading;

	public TestCausesFragment() {
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

	public void testCausesListItems() {
		solo.clickOnText("Causes");
		ArrayList<ListView> oldList = solo.getCurrentListViews();
		solo.clickOnText("Causes I'm supporting", 0);

		if (solo.getCurrentListViews() != null)
			assertNotSame("Clicked Causes I'm supporting item",
					solo.getCurrentListViews(), oldList);

		solo.goBack();

		solo.clickOnText("All Causes");

		boolean searchingLocation = solo.searchText("Searching for location");
		if(searchingLocation)
		solo.waitForDialogToClose(10000);

		boolean textGPS = solo.searchText("unable to find your location");

		if (textGPS) {
			solo.goBack();
			assertTrue(true);
		} else {
			if (!(solo.getCurrentListViews().isEmpty())) {
				assertNotSame("Clicked All Causes item",
						solo.getCurrentListViews(), oldList);

				assertNotNull(solo.getCurrentListViews());
				ArrayList<ListView> list = solo.getCurrentListViews();
				if (!(list.isEmpty())) {
					ListView lst = list.get(0);
					int cnt = lst.getChildCount();
					for (int i = 0; i < cnt - 1; i++) {
						solo.clickInList(i);
						assertTrue(true);
					}
				}
				solo.goBack();
				solo.clickOnText("Causes I'm supporting", 0);
				solo.sleep(2000);

				solo.goBack();
				solo.clickOnText("Learn how Check-in for Good works");
				// solo.sleep(2000);

			} else {
				assertTrue(!textGPS);
				solo.goBack();
				solo.goBack();
				solo.clickOnText("Learn how Check-in for Good works");
				// solo.sleep(2000);
			}
		}

		solo.waitForActivity(solo.getCurrentActivity().getClass()
				.getSimpleName());
		solo.assertCurrentActivity("in context of CheckinNativeActivity",
				CheckinNativeActivity.class);
		assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
				.getClass().getSimpleName());
	}
}
