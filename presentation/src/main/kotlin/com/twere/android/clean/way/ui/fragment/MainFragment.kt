package com.twere.android.clean.way.ui.fragment

import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.presentation.R

class MainFragment :BaseFragment() {

    override fun injectDependencies(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_main
    }

}