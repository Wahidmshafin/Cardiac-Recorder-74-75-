package com.example.cardiac_recorder;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
//import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * UI testing for app
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {



    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test1checkappname(){
        onView(withText("Cardiac-Recorder")).check(matches(isDisplayed()));
    }
    @Test
    public void test2addmeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.menu_add_button)).perform(click());
        Espresso.onView(withId(R.id.sa_time)).perform(ViewActions.typeText("9:51"));
        Espresso.onView(withId(R.id.sa_date)).perform(ViewActions.typeText("22/07/2022"));
        Espresso.onView(withId(R.id.sa_et_systolic)).perform(ViewActions.typeText("135"));
        Espresso.onView(withId(R.id.sa_et_diatolic)).perform(ViewActions.typeText("80"));
        Espresso.onView(withId(R.id.sa_et_rate)).perform(ViewActions.typeText("80"));
        Espresso.pressBack(); //Back button
        Espresso. onView(withId(R.id.sa_et_comment)).perform(ViewActions.typeText("Health is good"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.sa_btn)).perform(click());
        Espresso.onView(withId(R.id.contactsrecview)).check(matches(isDisplayed()));

        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.menu_add_button)).perform(click());
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.sa_time)).perform(ViewActions.typeText("10:52"));
        Espresso.onView(withId(R.id.sa_date)).perform(ViewActions.typeText("30/12/2022"));
        Espresso.onView(withId(R.id.sa_et_systolic)).perform(ViewActions.typeText("120"));
        Espresso.onView(withId(R.id.sa_et_diatolic)).perform(ViewActions.typeText("90"));
        Espresso.onView(withId(R.id.sa_et_rate)).perform(ViewActions.typeText("80"));
        Espresso.pressBack(); //Back button
        Espresso. onView(withId(R.id.sa_et_comment)).perform(ViewActions.typeText("Health is good"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.sa_btn)).perform(click());
        Espresso.onView(withId(R.id.contactsrecview)).check(matches(isDisplayed()));

    }

    @Test
    public void test3updatemeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.contactsrecview)).perform(click());
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.button_edit)).perform(click());

        Espresso.onView(withId(R.id.sa_time)).perform(clearText()).perform(ViewActions.typeText("11:52"));
        Espresso.onView(withId(R.id.sa_date)).perform(clearText()).perform(ViewActions.typeText("31/11/2022"));
        Espresso.onView(withId(R.id.sa_et_systolic)).perform(clearText()).perform(ViewActions.typeText("140"));
        Espresso.onView(withId(R.id.sa_et_diatolic)).perform(clearText()).perform(ViewActions.typeText("100"));
        Espresso.onView(withId(R.id.sa_et_rate)).perform(clearText()).perform(ViewActions.typeText("80"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.sa_et_comment)).perform(clearText()).perform(ViewActions.typeText("You May be sick"));
        Espresso.pressBack(); //Back button
        SystemClock.sleep(2000);
        onView(withId(R.id.button_edit)).perform(click());
        SystemClock.sleep(5000);
//        onView(withId(R.id.button_delete)).perform(click());
}
@Test
    public void test4deletemeasurement(){
    SystemClock.sleep(5000);
    Espresso.onView(withId(R.id.contactsrecview)).perform(click());
    SystemClock.sleep(3000);
    Espresso.onView(withId(R.id.button_delete)).perform(click());
    SystemClock.sleep(5000);

}
}