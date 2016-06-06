package com.twere.dribbblekotlin.ui.activity

import android.os.Bundle
import com.twere.dribbble.R
import com.twere.dribbblekotlin.di.components.ApplicationComponent

class MainActivity : BaseDrawerActivity() {

  override fun onDestroy() {
    super.onDestroy()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun getLayout(): Int {
    return R.layout.activity_main
  }

  override fun injectDependencies(appComponent: ApplicationComponent) {
    appComponent.inject(this)
  }
}