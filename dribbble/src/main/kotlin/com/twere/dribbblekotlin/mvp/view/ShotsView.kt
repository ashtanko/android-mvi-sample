package com.twere.dribbblekotlin.mvp.view

import com.twere.dribbblekotlin.mvp.model.shot.Shot


interface ShotsView {
  fun showError(message: String)
  fun hideError()
  fun onStartLoading()
  fun onFinishLoading()
  fun showRefreshing()
  fun hideRefreshing()
  fun showListProgress()
  fun hideListProgress()
  fun setRepositories(shots: List<Shot>, more: Boolean)
  fun addRepositories(shots: List<Shot>, more: Boolean)
}