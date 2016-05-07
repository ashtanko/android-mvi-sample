package com.twere.dribbblekotlin.ui.activity

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.twere.dribbble.R
import com.twere.dribbblekotlin.di.components.ApplicationComponent
import com.twere.dribbblekotlin.mvp.model.shot.Shot
import com.twere.dribbblekotlin.mvp.presenter.ShotsPresenter
import com.twere.dribbblekotlin.mvp.view.ShotsView

class MainActivity : BaseDrawerActivity(), ShotsView {

  @InjectPresenter lateinit var presenter: ShotsPresenter

  override fun onDestroy() {
    super.onDestroy()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.loadShots(false)
  }

  override fun getLayout(): Int {
    return R.layout.activity_main
  }

  override fun injectDependencies(appComponent: ApplicationComponent) {
    appComponent.inject(this)
  }

  override fun showError(message: String) {

  }

  override fun hideError() {

  }

  override fun onStartLoading() {

  }

  override fun onFinishLoading() {

  }

  override fun showRefreshing() {

  }

  override fun hideRefreshing() {

  }

  override fun showListProgress() {

  }

  override fun hideListProgress() {

  }

  override fun setRepositories(shots: List<Shot>, more: Boolean) {

  }

  override fun addRepositories(shots: List<Shot>, more: Boolean) {

  }

}