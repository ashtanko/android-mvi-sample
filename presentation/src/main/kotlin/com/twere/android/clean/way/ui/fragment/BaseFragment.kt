package com.twere.android.clean.way.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twere.android.clean.way.MainApp
import com.twere.android.clean.way.di.component.ApplicationComponent

abstract class BaseFragment : Fragment() {

    abstract fun injectDependencies(appComponent: ApplicationComponent)
    abstract fun getLayout(): Int
    protected var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(getLayout(), container, false)
        return rootView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependencies(MainApp.appComponent)
    }
}