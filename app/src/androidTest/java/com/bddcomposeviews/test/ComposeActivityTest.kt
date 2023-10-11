package com.bddcomposeviews.test

import android.content.Intent
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.bddcomposeviews.ComposeActivity
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposeActivityTest (private val composeRuleHolder: ComposeRuleHolder, private val scenarioHolder: ActivityScenarioHolder)
    : SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule{

    @Given("^I have a login Activity")
    fun i_have_a_login_activity(){
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        scenarioHolder.launch(Intent(instrumentation.targetContext, ComposeActivity::class.java))
    }

    @When("^I input email \"([^\"]*)\"$")
    fun i_input_email(email: String){
        onNodeWithTag("emailTextField").performTextInput(email)
    }

    @And("^I input password \"([^\"]*)\"$")
    fun i_input_password(password: String){
        onNodeWithTag("passwordTextField").performTextInput(password)
        Espresso.closeSoftKeyboard()
    }

    @And("^I press login button")
    fun i_press_login_button(){
        onNodeWithTag("loginButton").performClick()
    }

    @Then("^it means login successful")
    fun it_means_login_successful(){
        //
    }
}

