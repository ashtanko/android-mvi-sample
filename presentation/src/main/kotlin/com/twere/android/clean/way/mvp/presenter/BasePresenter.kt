package com.twere.android.clean.way.mvp.presenter

interface BasePresenter<T> {
  fun init(view: T)
}