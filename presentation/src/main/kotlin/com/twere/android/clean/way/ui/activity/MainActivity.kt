package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.presentation.R

class MainActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.main_activity
    }

    override fun injectDependencies(appComponent: ApplicationComponent) {
       appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}