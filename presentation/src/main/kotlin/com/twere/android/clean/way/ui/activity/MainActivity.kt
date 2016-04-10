package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.mvp.impl.MainPresenterImpl
import com.twere.android.clean.way.mvp.view.MainView
import com.twere.android.clean.way.ui.fragment.MainFragment
import com.twere.android.clean.way.util.NetworkUtil
import com.twere.data.MainItem
import com.twere.data.api.dribbble.service.DribbleService
import com.twere.data.util.log
import com.twere.presentation.R
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseDrawerActivity(), MainView {

  private val LOADER_ID = 101

  @Inject lateinit var network: NetworkUtil
  @Inject lateinit var api: DribbleService
  @Inject lateinit var presenter: MainPresenterImpl
  @Inject lateinit var retrofit: Retrofit
  @Inject lateinit var okhttp: OkHttpClient

  override fun getLayout(): Int {
    return R.layout.activity_main
  }

  override fun injectDependencies(appComponent: ApplicationComponent) {
    appComponent.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.onViewAttached(this)
    presenter.resume(api)
  }

  override fun initList(list: List<MainItem>) {
    log(list.size)
  }

  fun testFragmentUi() {
    supportFragmentManager.beginTransaction().replace(R.id.cl_content, MainFragment()).commit()
  }
}