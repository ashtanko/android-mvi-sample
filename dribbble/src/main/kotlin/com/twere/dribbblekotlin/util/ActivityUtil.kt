package com.twere.dribbblekotlin.util

import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

fun addFragmentToActivity(
    @NonNull fragmentManager: FragmentManager,
    @NonNull fragment: Fragment, frameId: Int) {

  var transaction: FragmentTransaction = fragmentManager.beginTransaction()
  transaction.add(frameId, fragment)
  transaction.commit()
}

fun replaceFragmentToActivity(
    @NonNull fragmentManager: FragmentManager,
    @NonNull fragment: Fragment, frameId: Int) {

  var transaction: FragmentTransaction = fragmentManager.beginTransaction()
  transaction.replace(frameId, fragment)
  transaction.commit()
}