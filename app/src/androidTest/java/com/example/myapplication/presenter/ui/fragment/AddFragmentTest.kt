package com.example.myapplication.presenter.ui.fragment

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myapplication.R
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class AddFragmentTest {
    private lateinit var scenario: FragmentScenario<AddFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MyApplication)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testFragment() {
        onView(withId(R.id.et_name)).perform(typeText("Minitha"))
        onView(withId(R.id.bn_click)).perform(click())
        Espresso.closeSoftKeyboard()
        assertThat(onView(withId(R.id.tv_home)).check(matches(withText("Minitha"))))
    }


}