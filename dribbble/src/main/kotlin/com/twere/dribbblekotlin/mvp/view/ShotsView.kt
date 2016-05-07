package com.twere.dribbblekotlin.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.twere.dribbblekotlin.mvp.model.shot.Shot

@StateStrategyType(AddToEndSingleStrategy::class)
interface ShotsView : MvpView {
  fun showError(message: String)
  fun hideError()
  fun onStartLoading()
  fun onFinishLoading()
  fun showRefreshing()
  fun hideRefreshing()
  fun showListProgress()
  fun hideListProgress()
  fun setRepositories(shots: List<Shot>, more: Boolean)
  @StateStrategyType(AddToEndSingleStrategy::class)
  fun addRepositories(shots: List<Shot>, more: Boolean)
}