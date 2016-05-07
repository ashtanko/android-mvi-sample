package com.twere.dribbblekotlin.mvp.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.MvpDelegate

abstract class MvpAppCompatActivity : AppCompatActivity() {

  private var mMvpDelegate: MvpDelegate<out MvpAppCompatActivity> = MvpDelegate<MvpAppCompatActivity>(
      this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mMvpDelegate.onCreate(savedInstanceState)
  }

  override fun onDestroy() {
    super.onDestroy()
    mMvpDelegate.onDestroy()
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    mMvpDelegate.onSaveInstanceState(outState)
  }

  override fun onStart() {
    super.onStart()
    mMvpDelegate.onStart()
  }

  override fun onStop() {
    super.onStop()
    mMvpDelegate.onStop()
  }
}