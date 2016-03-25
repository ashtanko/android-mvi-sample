package com.twere.android.clean.way.ui.activity

import android.support.v7.widget.Toolbar
import com.twere.android.clean.way.MainApp
import com.twere.presentation.BuildConfig
import com.twere.presentation.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(application = MainApp::class, constants = BuildConfig::class, sdk = intArrayOf(21), manifest = "/src/main/AndroidManifest.xml")
class MainActivityTest {

    private var activity: MainActivity? = null
    private var toolbar: Toolbar? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        findViews()
    }

    private fun findViews() {
        toolbar = activity!!.findViewById(R.id.toolbar) as Toolbar
    }

    @Test
    fun toolbarShouldBePresentAndVisible() {
        // MatcherAssert.assertThat(toolbar,true);
        // MatcherAssert.assertThat(toolbar.getVisibility(), is(View.VISIBLE));
    }
}
