package com.twere.android.clean.way.ui.activity

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import butterknife.bindView
import com.twere.presentation.R

abstract class BaseDrawerActivity : BaseActivity() {

    val drawer_layout: DrawerLayout by bindView(R.id.drawer_layout)
    val nav_view: NavigationView by bindView(R.id.nav_view)


    override fun setContentView(layoutResID: Int) {
        super.setContentViewWithoutInject(R.layout.activity_drawer)
        val viewGroup = findViewById(R.id.fl_content) as ViewGroup
        LayoutInflater.from(this).inflate(layoutResID, viewGroup, true)
        bindViews()
        setupHeader()
        mToolbar.setNavigationOnClickListener {
            drawer_layout.openDrawer(Gravity.LEFT)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (drawer_layout.isDrawerOpen(nav_view)) {
            drawer_layout.closeDrawer(nav_view)
        }else{
            finish()
        }
    }

    fun setupHeader() {

    }
}