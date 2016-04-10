package com.twere.android.clean.way.mvp.presenter

interface PresenterFactory<T : BasePresenter<Any>> {
  fun create(): T
}