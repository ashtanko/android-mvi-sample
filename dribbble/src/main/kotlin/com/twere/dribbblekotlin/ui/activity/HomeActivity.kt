package com.twere.dribbblekotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.twere.dribbble.R
import com.twere.dribbblekotlin.DribbbleApplication
import com.twere.dribbblekotlin.di.components.ApplicationComponent
import kotlinx.android.synthetic.main.activity_main.toolbar

abstract class HomeActivity :  AppCompatActivity() {

  abstract fun injectDependencies(appComponent: ApplicationComponent)
  abstract fun getLayout(): Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
    injectDependencies(DribbbleApplication.appComponent)
  }

  override fun setContentView(layoutResID: Int) {
    super.setContentView(layoutResID)
    bindViews()
  }

  fun bindViews() {
    setupToolbar()
  }

  protected fun setupToolbar() {
    setSupportActionBar(toolbar)
    toolbar.setNavigationIcon(R.drawable.ic_menu_white)
  }

  fun setContentViewWithoutInject(layoutResId: Int) {
    super.setContentView(layoutResId)
  }
}