package com.twere.android.clean.way.mvp.presenter

interface BasePresenter<T> {
  fun onViewAttached(view: T)
  fun onViewDetached()
  fun onDestroyed()
}