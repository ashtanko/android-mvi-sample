package com.twere.dribbblekotlin.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.twere.dribbblekotlin.mvp.model.shot.Shot
import com.twere.dribbblekotlin.mvp.view.ShotsView

@InjectViewState
class ShotsPresenter : MvpPresenter<ShotsView>() {

  private var mIsInLoading: Boolean = false

  override fun onFirstViewAttach() {
    super.onFirstViewAttach()
    loadShots(false)

  }

  fun loadShots(isRefreshing: Boolean) {
    loadData(1, false, isRefreshing)
  }

  fun loadData(page: Int, isPageLoading: Boolean, isRefreshing: Boolean) {

    if (mIsInLoading) {
      return
    }

    mIsInLoading = true

    viewState.hideError()
    viewState.onStartLoading()

    showProgress(isPageLoading, isRefreshing)


  }

  private fun onLoadingFinish(isPageLoading: Boolean, isRefreshing: Boolean) {
    mIsInLoading = false
    viewState.onFinishLoading()
    hideProgress(isPageLoading, isRefreshing)
  }

  private fun onLoadingSuccess(isPageLoading: Boolean, shots: List<Shot>) {
    var more: Boolean = false
    if (isPageLoading) {
      viewState.addRepositories(shots, more)
    } else {
      viewState.setRepositories(shots, more)
    }
  }

  private fun onLoadingFailed(error: Throwable) {
    viewState.showError(error.toString())
  }

  private fun showProgress(isPageLoading: Boolean, isRefreshing: Boolean) {
    if (isPageLoading) {
      return
    }
    if (isRefreshing) {
      viewState.showRefreshing()
    } else {
      viewState.showListProgress()
    }
  }

  private fun hideProgress(isPageLoading: Boolean, isRefreshing: Boolean) {
    if (isPageLoading) {
      return
    }
    if (isRefreshing) {
      viewState.hideRefreshing()
    } else {
      viewState.hideListProgress()
    }
  }

  fun closeError() {
    viewState.hideError()
  }

}