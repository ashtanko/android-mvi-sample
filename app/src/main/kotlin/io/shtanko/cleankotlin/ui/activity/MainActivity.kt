package io.shtanko.cleankotlin.ui.activity

import android.os.Bundle
import io.shtanko.cleankotlin.R

class MainActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}