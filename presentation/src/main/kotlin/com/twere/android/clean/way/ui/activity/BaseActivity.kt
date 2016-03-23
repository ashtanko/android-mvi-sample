package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.twere.android.clean.way.MainApp
import com.twere.android.clean.way.di.component.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

    abstract fun injectDependencies(appComponent: ApplicationComponent)
    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        injectDependencies(MainApp.appComponent)
    }
}