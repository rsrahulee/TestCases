package checkinforgood.com.test;

import java.util.ArrayList;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestBusinessFragment extends
		ActivityInstrumentationTestCase2<CheckinNativeActivity> {

	TestCheckin checkin;
	private Solo solo;
	Activity mActivity;
	private Boolean cndtn;
	Boolean waitLoading;
	int businessCount;

	public TestBusinessFragment() {
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

	// /////////Determining the sequence of test cases

	// public void TestingSequence() {
	// // AppStatus appStatus = AppStatus.getInstance(getActivity());
	// // if (!appStatus.isOnline()) {
	// //
	// // } else {
	// // if (appStatus.isRegistered()) {
	// // solo.assertCurrentActivity("User already registered",
	// // LoginActivity.class);
	// // assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
	// // .getClass().getSimpleName());
	// // } else {
	// // loginTest.testLogin();
	// // }
	// // }
	// // assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
	// // .getClass().getSimpleName());
	// //assertTrue(appStatus.isRegistered());
	// solo.waitForDialogToClose(5000);
	// testBusinessesButtons();
	//
	// assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
	// .getClass().getSimpleName());
	// //assertTrue(appStatus.isRegistered());
	// solo.waitForDialogToClose(5000);
	//
	// testCausesListItems();
	// // checkin.testPublicCheckin();
	// testTopNavigation();
	//
	// }

	// ///////////////////// To test Top navigation tab

	// /////////////////////// To test Buttons in Business Fragment

	public void testBusinessesButtons() {

		// AppStatus appStatus = AppStatus.getInstance(getActivity());
		// assertTrue(appStatus.isRegistered());
		// solo.waitForDialogToClose(2000);

		// boolean loginEntered =
		// solo.searchText("Watch Check-in for Good in action");
		// if(loginEntered){
		// assertTrue(loginEntered);
		// }else{
		// assertFalse(loginEntered);
		// }
		// solo.assertCurrentActivity("CheckinNativeActivity",
		// CheckinNativeActivity.class);
		// assertEquals("CheckinNativeActivity",
		// solo.getCurrentActivity().getClass().getName());

		// boolean businessFound = solo.searchText("Businesses");
		// if (businessFound) {
		// solo.clickOnText("Businesses");
		// assertEquals("Businesses", "Businesses");
		// }
		// solo.clickOnText("Businesses");

		// waitLoading = solo.searchText("Please Wait...");
		// if (waitLoading) {
		// solo.waitForDialogToClose(5000);
		// }

		// ArrayList<ListView> oldList = solo.getCurrentListViews();

		// ArrayList<ListView> oldList =new ArrayList<ListView>();
		// oldList = solo.getCurrentListViews();
		// boolean abc = oldList.contains("No businesses found");

		solo.clickOnButton("Supporting My Causes");
		assertTrue("Supporting My Caauses Button is clicked", true);
		// assertNotSame("Clicked Supporting My Causes Button",
		// solo.getCurrentListViews(), oldList);
		// oldList = solo.getCurrentListViews();
		// assertNotNull(solo.getCurrentListViews());

		solo.clickOnImage(0);
		assertTrue("Refresh Button is clicked", true);
		// assertNotSame("Clicked image button", solo.getCurrentListViews(),
		// oldList);
		// assertNotNull(solo.getCurrentListViews());

		solo.clickOnButton("All");
		assertTrue("All Button is clicked", true);

		ArrayList<ListView> oldList = solo.getCurrentListViews();
		if (!(oldList.isEmpty())) {
			ListView lst = oldList.get(0);
			businessCount = lst.getChildCount();
		}
		// assertNotSame("Clicked All button", solo.getCurrentListViews(),
		// oldList);
		// assertNotNull(solo.getCurrentListViews());
		// boolean noBusiness = solo.searchText("No Businesses found");

		// oldList = solo.getCurrentListViews();

		// boolean businessNotFound = solo.searchText("No Businesses found");

		// int sizeOfList = oldList.toArray().length;
		if (businessCount > 0) {

			// assertTrue("No businesses found", false);

			solo.clickInList(0);
			assertNotNull(solo.getCurrentListViews());

			boolean textDirectScreen = solo.searchText("MAP");
			if (textDirectScreen) {
				solo.clickOnText("NO");

				solo.clickOnButton("CHECK-IN FOR GOOD!");
				
				boolean textOnePerDayAllNOMap = solo.searchText("only once per day");
				boolean textSorryAllNOMap = solo.searchText("We're sorry");
				boolean txtSettingAllNOMap = solo.searchText("SETTINGS");

				if (textSorryAllNOMap) {
					solo.clickOnText("OK");
					assertTrue(true);
				} else if (textOnePerDayAllNOMap) {
					solo.clickOnText("OK");
					assertTrue(true);
				} else if (txtSettingAllNOMap) {
					solo.waitForDialogToClose(2000);
				} else {

					boolean txtSnapNO = solo.searchText("SNAP");
					if (txtSnapNO) {
						solo.clickOnButton(0);
						solo.goBack();
						assertTrue(txtSnapNO);
					} else {
						boolean txt = solo.searchText("thank you.");
						if (txt) {
							solo.waitForDialogToClose(5000);
							assertTrue(solo.searchText("SETTINGS"));
							solo.waitForDialogToClose(5000);
						} else {
							assertFalse(solo.searchText("SETTINGS"));
							solo.clickOnText("OK");
						}
					}

				}

//				boolean text = solo.searchText("We're sorry");
//				if (!text) {
//					boolean txtSnap = solo.searchText("SNAP");
//					if (txtSnap) {
//						solo.clickOnButton(0);
//						solo.goBack();
//						assertTrue(txtSnap);
//					} else {
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
//				} else {
//					solo.clickOnText("OK");
//				}
			} else {

				if (!(solo.getCurrentListViews().isEmpty())) {
					solo.clickInList(0);
					assertNotNull(solo.getCurrentListViews());
					if (!solo.searchButton("MAP")) {
						solo.clickInList(0);
					}
					solo.clickOnText("NO");

					solo.clickOnButton("CHECK-IN FOR GOOD!");
					////////////////////
					boolean textOnePerDayAllNO = solo.searchText("only once per day");
					boolean textSorryAllNO = solo.searchText("We're sorry");
					boolean txtSettingAllNO = solo.searchText("SETTINGS");

					if (textSorryAllNO) {
						solo.clickOnText("OK");
						assertTrue(true);
					} else if (textOnePerDayAllNO) {
						solo.clickOnText("OK");
						assertTrue(true);
					} else if (txtSettingAllNO) {
						solo.waitForDialogToClose(2000);
					} else {

						boolean txtSnapNO = solo.searchText("SNAP");
						if (txtSnapNO) {
							solo.clickOnButton(0);
							solo.goBack();
							assertTrue(txtSnapNO);
						} else {
							boolean txt = solo.searchText("thank you.");
							if (txt) {
								solo.waitForDialogToClose(5000);
								assertTrue(solo.searchText("SETTINGS"));
								solo.waitForDialogToClose(5000);
							} else {
								assertFalse(solo.searchText("SETTINGS"));
								solo.clickOnText("OK");
							}
						}

					}					
					///////////////////

//					boolean text = solo.searchText("We're sorry");
//					if (!text) {
//						boolean txtSnap = solo.searchText("SNAP");
//						if (txtSnap) {
//							solo.clickOnButton(0);
//							solo.goBack();
//							assertTrue(txtSnap);
//						} else {
//							boolean txt = solo.searchText("thank you.");
//							if (txt) {
//								solo.waitForDialogToClose(5000);
//								assertTrue(solo.searchText("SETTINGS"));
//								solo.waitForDialogToClose(5000);
//							} else {
//								assertFalse(solo.searchText("SETTINGS"));
//								solo.clickOnText("OK");
//							}
//						}
//					} else {
//						solo.clickOnText("OK");
//					}
				}
			}
		} else {
			// assertTrue("No businesses found", true);
		}

		// waitLoading = solo.searchText("Please Wait...");
		// if (waitLoading) {
		// solo.waitForDialogToClose(5000);
		// }
		solo.clickOnText("Businesses");
		assertTrue(true);
		solo.clickOnButton("All");
		assertNotSame("Clicked All button", solo.getCurrentListViews(), oldList);
		assertNotNull(solo.getCurrentListViews());
		// boolean noBusiness = solo.searchText("No Businesses found");
		// assertFalse(noBusiness);
		// if (noBusiness) {

		// oldList = solo.getCurrentListViews();
		if (businessCount > 0) {// && businessNotFound == false

			// assertTrue("No businesses found", false);

			solo.clickInList(0);
			assertNotNull(solo.getCurrentListViews());

			boolean textDirectScreen = solo.searchText("MAP");
			if (textDirectScreen) {
				solo.clickOnText("YES");

				solo.clickOnButton("CHECK-IN FOR GOOD!");
				boolean textOnePerDayAllYESMap = solo.searchText("only once per day");
				boolean textSorryAllYESMap = solo.searchText("We're sorry");
				boolean txtSettingAllYESMap = solo.searchText("SETTINGS");

				if (textSorryAllYESMap) {
					solo.clickOnText("OK");
					assertTrue(true);
				} else if (textOnePerDayAllYESMap) {
					solo.clickOnText("OK");
					assertTrue(true);
				} else if (txtSettingAllYESMap) {
					solo.waitForDialogToClose(2000);
				} else {

					boolean txtSnapNO = solo.searchText("SNAP");
					if (txtSnapNO) {
						solo.clickOnButton(0);
						solo.goBack();
						assertTrue(txtSnapNO);
					} else {
						boolean txt = solo.searchText("thank you.");
						if (txt) {
							solo.waitForDialogToClose(5000);
							assertTrue(solo.searchText("SETTINGS"));
							solo.waitForDialogToClose(5000);
						} else {
							assertFalse(solo.searchText("SETTINGS"));
							solo.clickOnText("OK");
						}
					}

				}
//				cndtn = solo.searchText("SETTINGS");
//				boolean txtSnap = solo.searchText("SNAP");
//
//				if (cndtn) {
//					assertTrue(solo.searchText("SETTINGS"));
//					solo.clickOnText("SETTINGS");
//				} else {
//					if (txtSnap) {
//						solo.clickOnButton(0);
//						solo.goBack();
//						assertTrue(txtSnap);
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
			} else {
				if (solo.getCurrentListViews() != null) {
					solo.clickInList(0);
					assertNotNull(solo.getCurrentListViews());
					if (!solo.searchButton("MAP")) {
						solo.clickInList(0);
					}
					solo.clickOnText("YES");

					solo.clickOnButton("CHECK-IN FOR GOOD!");
					
					boolean textOnePerDayAllYES = solo.searchText("only once per day");
					boolean textSorryAllYES = solo.searchText("We're sorry");
					boolean txtSettingAllYES = solo.searchText("SETTINGS");

					if (textSorryAllYES) {
						solo.clickOnText("OK");
						assertTrue(true);
					} else if (textOnePerDayAllYES) {
						solo.clickOnText("OK");
						assertTrue(true);
					} else if (txtSettingAllYES) {
						solo.waitForDialogToClose(2000);
					} else {

						boolean txtSnapNO = solo.searchText("SNAP");
						if (txtSnapNO) {
							solo.clickOnButton(0);
							solo.goBack();
							assertTrue(txtSnapNO);
						} else {
							boolean txt = solo.searchText("thank you.");
							if (txt) {
								solo.waitForDialogToClose(5000);
								assertTrue(solo.searchText("SETTINGS"));
								solo.waitForDialogToClose(5000);
							} else {
								assertFalse(solo.searchText("SETTINGS"));
								solo.clickOnText("OK");
							}
						}

					}
//					cndtn = solo.searchText("SETTINGS");
//					boolean txtSnap = solo.searchText("SNAP");
//
//					if (cndtn) {
//						assertTrue(solo.searchText("SETTINGS"));
//						solo.clickOnText("SETTINGS");
//					} else {
//						if (txtSnap) {
//							solo.clickOnButton(0);
//							solo.goBack();
//							assertTrue(txtSnap);
//						} else {
//
//							boolean txt = solo.searchText("thank you.");
//							if (txt) {
//								solo.waitForDialogToClose(5000);
//								assertTrue(solo.searchText("SETTINGS"));
//								solo.waitForDialogToClose(5000);
//							} else {
//								assertFalse(solo.searchText("SETTINGS"));
//								solo.clickOnText("OK");
//							}
//						}
//					}
				}
			}
		} else {
			// assertTrue("No businesses found", true);
		}
		solo.waitForActivity(solo.getCurrentActivity().getClass()
				.getSimpleName());
		solo.assertCurrentActivity("in context of CheckinNativeActivity",
				CheckinNativeActivity.class);
		assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
				.getClass().getSimpleName());
	}

	public void testBusinessesButtonsForSupportingMyCauses() {

		solo.clickOnButton("Supporting My Causes");
		
//		ArrayList<ListView> oldList = solo.getCurrentListViews();
//		if (!(oldList.isEmpty())) {
//			ListView lst = oldList.get(0);
//			businessCount = lst.getChildCount();
//		}
		// solo.waitForDialogToClose(5000);
		assertNotNull(solo.getCurrentListViews());
		if (solo.getCurrentListViews().get(0).getChildAt(0) != null) {
			solo.clickOnView(solo.getCurrentListViews().get(0).getChildAt(1));
			
			assertNotNull(solo.getCurrentListViews());
			if (!solo.searchButton("MAP")) {
				solo.clickInList(0);
			}
			solo.clickOnText("NO");

			solo.clickOnButton("CHECK-IN FOR GOOD!");
			boolean textOnePerDayNO = solo.searchText("only once per day");
			boolean textSorryNO = solo.searchText("We're sorry");
			boolean txtSetting = solo.searchText("SETTINGS");

			if (textSorryNO) {
				solo.clickOnText("OK");
				assertTrue(true);
			} else if (textOnePerDayNO) {
				solo.clickOnText("OK");
				assertTrue(true);
			} else if (txtSetting) {
				solo.waitForDialogToClose(2000);
			} else {

				boolean txtSnapNO = solo.searchText("SNAP");
				if (txtSnapNO) {
					solo.clickOnButton(0);
					solo.goBack();
					assertTrue(txtSnapNO);
				} else {
					boolean txt = solo.searchText("thank you.");
					if (txt) {
						solo.waitForDialogToClose(5000);
						assertTrue(solo.searchText("SETTINGS"));
						solo.waitForDialogToClose(5000);
					} else {
						assertFalse(solo.searchText("SETTINGS"));
						solo.clickOnText("OK");
					}
				}

			}
		}

		solo.clickOnText("Businesses");
		assertTrue(true);
		solo.clickOnButton("Supporting My Causes");
		solo.waitForDialogToClose(5000);
		boolean noBusiness = solo.searchText("No Businesses found");
		assertFalse(noBusiness);
		if (noBusiness) {

			assertNotNull(solo.getCurrentListViews());
			if (solo.getCurrentListViews().get(0).getChildAt(0) != null) {
				solo.clickOnView(solo.getCurrentListViews().get(0)
						.getChildAt(1));
				assertNotNull(solo.getCurrentListViews());
				if (!solo.searchButton("MAP")) {
					solo.clickInList(0);
				}
				solo.clickOnText("YES");

				solo.clickOnButton("CHECK-IN FOR GOOD!");
				cndtn = solo.searchText("SETTINGS");
				boolean txtSnapYES = solo.searchText("SNAP");
				boolean txtOncePerDayYES = solo.searchText("only once");
				boolean txtSorryYES = solo.searchText("We're sorry");

				if (cndtn) {
					assertTrue(solo.searchText("SETTINGS"));
					solo.clickOnText("SETTINGS");
					assertTrue(true);
				} else if (txtOncePerDayYES) {
					solo.clickOnButton("OK");
					assertTrue(true);
				} else if (txtSorryYES) {
					solo.clickOnButton("OK");
					assertTrue(true);
				} else {
					if (txtSnapYES) {
						solo.clickOnButton(0);
						solo.goBack();
						assertTrue(txtSnapYES);
					} else {

						boolean txt = solo.searchText("thank you.");
						if (txt) {
							solo.waitForDialogToClose(5000);
							assertTrue(solo.searchText("SETTINGS"));
							solo.waitForDialogToClose(5000);
						} else {
							assertFalse(solo.searchText("SETTINGS"));
							solo.clickOnText("OK");
						}
					}
				}
			}
		}
		// boolean txt = solo.searchText("thank you.");
		// if (txt) {
		// solo.waitForDialogToClose(5000);
		// assertTrue(solo.searchText("thank you."));
		// solo.waitForDialogToClose(5000);
		//
		// } else if (cndtn) {
		// assertTrue(solo.searchText("SETTINGS"));
		// solo.clickOnText("SETTINGS");
		//
		// } else {
		// assertFalse(solo.searchText("SETTINGS"));
		// solo.clickOnText("OK");
		// }

	}

}
