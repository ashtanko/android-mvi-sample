package com.twere.dribbblekotlin.mvp.common

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpDelegate

abstract class MvpAppCompatFragment : Fragment() {
  private var mMvpDelegate: MvpDelegate<out MvpAppCompatFragment> = MvpDelegate<MvpAppCompatFragment>(
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