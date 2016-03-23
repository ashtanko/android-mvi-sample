package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.util.NetworkUtil
import com.twere.presentation.R
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var network: NetworkUtil

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