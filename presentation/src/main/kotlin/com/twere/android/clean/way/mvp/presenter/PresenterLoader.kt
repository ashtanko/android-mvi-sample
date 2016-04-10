package com.twere.android.clean.way.mvp.presenter

import android.content.Context
import android.support.v4.content.Loader

class PresenterLoader<T : BasePresenter<Any>>(
    context: Context,
    private val factory: PresenterFactory<T>,
    private var presenter: T?) : Loader<T>(context) {

  override fun onStartLoading() {
    if (presenter != null) {
      deliverResult(presenter)
      return
    }

    forceLoad()
  }

  override fun onForceLoad() {
    presenter = factory.create()
    deliverResult(presenter)
  }

  override fun onReset() {
    presenter?.onDestroyed()
    presenter = null
  }
}
