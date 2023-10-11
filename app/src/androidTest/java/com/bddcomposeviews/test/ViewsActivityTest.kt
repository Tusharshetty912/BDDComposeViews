package com.bddcomposeviews.test

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.bddcomposeviews.ViewsActivity
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewsActivityTest(private val scenarioHolder: ActivityScenarioHolder) {

    @Before()
    fun setup(){
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        scenarioHolder.launch(Intent(instrumentation.targetContext, ViewsActivity::class.java))
    }

    @After()
    fun finish(){
        //finish
    }

    @Given("^I have login Activity")
    fun i_have_a_login_activity(){
        //do something
    }

    @When("^I input an email \"([^\"]*)\"$")
    fun i_input_email(email: String){
        Espresso.onView(ViewMatchers.withId(com.bddcomposeviews.R.id.emailText)).perform(ViewActions.typeText(email))
    }

    @And("^I input a password \"([^\"]*)\"$")
    fun i_input_password(password: String){
        Espresso.onView(ViewMatchers.withId(com.bddcomposeviews.R.id.passwordText)).perform(ViewActions.typeText(password))
        closeSoftKeyboard()
    }

    @And("^I press the login button")
    fun i_press_login_button(){
        Espresso.onView(ViewMatchers.withId(com.bddcomposeviews.R.id.loginBtn)).perform(ViewActions.click())
    }

    @Then("^I should see the status error on the \"([^\"]*)\"$")
    fun i_should_see_status_on_the(status: String){
        Espresso.onView(ViewMatchers.withId(com.bddcomposeviews.R.id.status)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    status
                )
            ))
    }
}