package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.AppStatus;
import checkinforgood.com.CheckinNativeActivity;
import checkinforgood.com.account.LoginActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestAllUserLogin extends
		ActivityInstrumentationTestCase2<LoginActivity> {

	private Solo solo;
	Activity mActivity;

	public TestAllUserLogin() {
		super("checkinforgood.com.accounts", LoginActivity.class);
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

	public void testAllLogin() {

		String name = solo.getCurrentActivity().getClass().getName();

		// solo.assertCurrentActivity("login page", solo.getCurrentActivity()
		// .getClass().getName());
		// assertEquals(name, solo.getCurrentActivity().getClass()
		// .getSimpleName());
		solo.clickOnButton("Create Account");
		// assertTrue(true);

		solo.enterText(0, "thurisazmt@gmail.com");
		solo.enterText(1, "11111111");
		solo.enterText(2, "Webonise");
		solo.enterText(3, "Lab");
		// assertTrue(true);

		solo.clickOnButton("Create");
		assertTrue(true);

		solo.waitForDialogToClose(5000);
		solo.goBack();
		// solo.goBackToActivity("LoginActivity");
		// solo.assertCurrentActivity("login activity",
		// solo.getCurrentActivity()
		// .getClass().getName());
		// assertEquals("LoginActivity", solo.getCurrentActivity().getClass()
		// .getSimpleName());

		solo.sleep(2000);
		solo.clickOnText("Forgot Your Password?");
		assertTrue(true);

		solo.enterText(0, "thurisazmt@gmail.com");
		assertTrue(true);
		solo.clickOnButton("Send Notification");

		// assertEquals("LoginActivity", solo.getCurrentActivity().getClass()
		// .getSimpleName());

		solo.sleep(2000);

		AppStatus appStatus = AppStatus.getInstance(getActivity());
		if (!appStatus.isOnline()) {

		} else {
			if (appStatus.isRegistered()) {
				assertTrue(appStatus.isRegistered());
				solo.assertCurrentActivity("User already registered",
						LoginActivity.class);

				String currentActivity = solo.getCurrentActivity().getClass()
						.getSimpleName();

				if (currentActivity.equalsIgnoreCase("CheckinNativeActivity")) {
					assertEquals("CheckinNativeActivity", solo
							.getCurrentActivity().getClass().getSimpleName());
				} else {
					assertEquals("LoginActivity", solo.getCurrentActivity()
							.getClass().getSimpleName());
				}

			} else {

				// assertEquals("LoginActivity", solo.getCurrentActivity()
				// .getClass().getSimpleName());

				// assertTrue(appStatus.isRegistered());
				// if (appStatus.isOnline()) {}

				solo.enterText(0, "thurisazmt@gmail.com");
				solo.enterText(1, "11111111");

				// EditText email = (EditText) getActivity().findViewById(
				// R.id.EditLoginEmail);
				//
				// email.setText("thurisazmt@gmail.com");
				// EditText password = (EditText) getActivity().findViewById(
				// R.id.EditLoginPassword);
				// password.setText("11111111");
				if (((LoginActivity) solo.getCurrentActivity()) != null) {
					// assertTrue(appStatus.isRegistered());
					solo.clickOnButton("Sign-in");

					solo.waitForDialogToClose(10000);

					solo.assertCurrentActivity(
							"User entered login details and clicked login!",CheckinNativeActivity.class);
					assertEquals("CheckinNativeActivity", solo
							.getCurrentActivity().getClass().getSimpleName());

					// String currentActivity = solo.getCurrentActivity()
					// .getClass().getSimpleName();
					//
					// solo.assertCurrentActivity("LoginActivity",
					// LoginActivity.class);

					// solo.waitForActivity("CheckinNativeActivity", 10000);
					//
					// assertEquals("CheckinNativeActivity", solo
					// .getCurrentActivity().getClass().getSimpleName());

					// if (currentActivity
					// .equalsIgnoreCase("CheckinNativeActivity")) {
					// assertEquals("CheckinNativeActivity", solo
					// .getCurrentActivity().getClass()
					// .getSimpleName());
					// } else {
					// assertEquals("LoginActivity", solo.getCurrentActivity()
					// .getClass().getSimpleName());
					//
					// solo.assertCurrentActivity("CheckinNativeActivity",
					// solo.getCurrentActivity().getClass()
					// .getSimpleName());
					// // assertTrue(true);
					// }
				}
				// solo.waitForDialogToClose(5000);
				// solo.assertCurrentActivity("CheckinNativeActivity", solo
				// .getCurrentActivity().getClass().getSimpleName());

				System.out.println("");
				// solo.waitForDialogToClose(5000);

				// solo.assertCurrentActivity(
				// "User entered login details and clicked login!",
				// AppStatus.class);
				//
				//
				//
				// assertEquals("CheckinNativeActivity", solo
				// .getCurrentActivity().getClass().getSimpleName());
				// }
				// else {
				// solo.assertCurrentActivity("User enterd wrong Id password!",
				// LoginActivity.class);
				// assertEquals("Login", solo.getCurrentActivity().getClass()
				// .getSimpleName());
				// }

				// AppStatus appStatus = AppStatus.getInstance(getActivity());
				// if (!appStatus.isOnline()) {
				// EditText email = (EditText) getActivity().findViewById(
				// R.id.EditLoginEmail);
				//
				// email.setText("thurisazmt@gmail.com");
				// EditText password = (EditText) getActivity().findViewById(
				// R.id.EditLoginPassword);
				// password.setText("11111111");
				// if (((LoginActivity) solo.getCurrentActivity()) != null) {
				// solo.clickOnButton("Sign-in");
				// solo.assertCurrentActivity(
				// "User entered login details and clicked login!",
				// AppStatus.class);
				// assertEquals("CheckinNativeActivity",
				// solo.getCurrentActivity()
				// .getClass().getSimpleName());
				// } else {
				// solo.assertCurrentActivity("User enterd wrong Id password!",
				// LoginActivity.class);
				// assertEquals("Login", solo.getCurrentActivity().getClass()
				// .getSimpleName());
				// }
				//
				// }

			}
		}
	}
}
