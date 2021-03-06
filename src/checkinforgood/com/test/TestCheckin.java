package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestCheckin extends ActivityInstrumentationTestCase2<CheckinNativeActivity> {

	// LoginTest loginTest;
	private Solo solo;
	//private Boolean cndtn;
	Activity mActivity;

	public TestCheckin() {
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

	// //////////////// To test Public checkin for

//	public void testPublicCheckin() {
//		solo.clickOnButton("Supporting My Causes");
//		// solo.waitForDialogToClose(5000);
//		assertNotNull(solo.getCurrentListViews());
//		if (solo.getCurrentListViews().get(0).getChildAt(0) != null) {
//			solo.clickOnView(solo.getCurrentListViews().get(0).getChildAt(1));
//			assertNotNull(solo.getCurrentListViews());
//			if (!solo.searchButton("MAP")) {
//				solo.clickInList(0);
//			}
//			solo.clickOnText("NO");
//
//			solo.clickOnButton("CHECK-IN FOR GOOD!");
//
//			boolean text = solo.searchText("We're sorry");
//			if (!text) {
//				boolean txtSnap = solo.searchText("SNAP");
//				if (txtSnap) {
//					solo.clickOnButton(0);
//				} else {
//					boolean txt = solo.searchText("thank you.");
//					if (txt) {
//						solo.waitForDialogToClose(5000);
//						assertTrue(solo.searchText("SETTINGS"));
//						solo.waitForDialogToClose(5000);
//					} else {
//						assertFalse(solo.searchText("SETTINGS"));
//						solo.clickOnText("OK");
//					}
//				}
//			} else {
//				solo.waitForDialogToClose(2000);
//			}
//		}
//	}

	// ////////////// To test Private checkin
//	public void testPrivateCheckin() {
//		solo.clickOnButton("Supporting My Causes");
//		solo.waitForDialogToClose(5000);
//		boolean noBusiness = solo.searchText("No Businesses found");
//		assertFalse(noBusiness);
//		if (noBusiness) {
//
//			assertNotNull(solo.getCurrentListViews());
//			if (solo.getCurrentListViews().get(0).getChildAt(0) != null) {
//				solo.clickOnView(solo.getCurrentListViews().get(0)
//						.getChildAt(1));
//				assertNotNull(solo.getCurrentListViews());
//				if (!solo.searchButton("MAP")) {
//					solo.clickInList(0);
//				}
//				solo.clickOnText("YES");
//
//				solo.clickOnButton("CHECK-IN FOR GOOD!");
//				cndtn = solo.searchText("SETTINGS");
//				boolean txtSnap = solo.searchText("SNAP");
//
//				if (cndtn) {
//					assertTrue(solo.searchText("SETTINGS"));
//					solo.clickOnText("SETTINGS");
//				} else {
//					if (txtSnap) {
//						solo.clickOnButton(0);
//					} else {
//
//						boolean txt = solo.searchText("thank you.");
//						if (txt) {
//							solo.waitForDialogToClose(5000);
//							assertTrue(solo.searchText("SETTINGS"));
//							solo.waitForDialogToClose(5000);
//						} else {
//							assertFalse(solo.searchText("SETTINGS"));
//							solo.clickOnText("OK");
//						}
//					}
//				}
//				// boolean txt = solo.searchText("thank you.");
//				// if (txt) {
//				// solo.waitForDialogToClose(5000);
//				// assertTrue(solo.searchText("thank you."));
//				// solo.waitForDialogToClose(5000);
//				//
//				// } else if (cndtn) {
//				// assertTrue(solo.searchText("SETTINGS"));
//				// solo.clickOnText("SETTINGS");
//				//
//				// } else {
//				// assertFalse(solo.searchText("SETTINGS"));
//				// solo.clickOnText("OK");
//				// }
//			}
//		}
//	}
}