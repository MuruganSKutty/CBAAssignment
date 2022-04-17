package com.cbaassignment.feature.newsList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.cbaassignment.MainActivity
import com.cbaassignment.R
import com.cbaassignment.service.ApiService
import com.cbaassignment.service.FakeRepository
import com.cbaassignment.service.Repository
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4ClassRunner::class)
class NewsDetailsFragmentTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    //test list is visible
    @Test
    fun test_isDetailsVisible() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<NewsItemViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_image)).check(matches(isDisplayed()))
    }

    //navigate to test details
    @Test
    fun test_pressSystemBackButton_isListFragmentVisible() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<NewsItemViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_pressBackButton_isListFragmentVisible() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<NewsItemViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        val imageButton = onView(
            Matchers.allOf(
                withContentDescription(R.string.abc_action_bar_up_description),
                isDisplayed()
            )
        )
        imageButton.perform(click())
    }
}