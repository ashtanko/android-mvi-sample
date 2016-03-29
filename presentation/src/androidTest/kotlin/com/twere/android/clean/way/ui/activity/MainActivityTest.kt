package com.twere.android.clean.way.ui.activity

import android.content.Context
import com.twere.android.clean.way.mvp.impl.MainPresenterImpl
import org.junit.Before
import javax.inject.Inject

class MainActivityTest {

    @Inject
    lateinit var presenter: MainPresenterImpl

    protected var context: Context? = null


    @Before
    fun setUp() {
       
    }
}