package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import com.twere.android.clean.way.MainApp
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.presentation.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun injectDependencies(appComponent: ApplicationComponent)
    abstract fun getLayout(): Int
    val mToolbar: Toolbar by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        injectDependencies(MainApp.appComponent)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        bindViews()
    }

    fun bindViews() {
        setupToolbar()
    }

    protected fun setupToolbar() {
        setSupportActionBar(mToolbar)
        mToolbar.setNavigationIcon(R.drawable.ic_menu_white)
    }

    fun setContentViewWithoutInject(layoutResId: Int) {
        super.setContentView(layoutResId)
    }
}