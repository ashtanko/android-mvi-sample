package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.mvp.impl.MainPresenterImpl
import com.twere.android.clean.way.mvp.view.MainView
import com.twere.android.clean.way.ui.fragment.MainFragment
import com.twere.android.clean.way.util.NetworkUtil
import com.twere.data.MainItem
import com.twere.data.api.dribbble.DribbleService
import com.twere.data.util.log
import com.twere.presentation.R
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseDrawerActivity(), MainView {

    @Inject
    lateinit var network: NetworkUtil

    @Inject
    lateinit var api: DribbleService

    @Inject
    lateinit var presenter: MainPresenterImpl

    @Inject
    lateinit var retrofit: Retrofit

    val rv_news: RecyclerView by bindView(R.id.rv_news)
    val cl_content: CoordinatorLayout by bindView(R.id.cl_content)
    val appBarLayout: AppBarLayout by bindView(R.id.appBarLayout)

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun injectDependencies(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testFragmentUi()
        presenter.init(this)
        presenter.resume(api)
        //presenter.getFeed(0, 30)

        log(retrofit.baseUrl())

    }

    override fun initList(list: List<MainItem>) {
        log(list.size)
    }

    fun testFragmentUi() {
        supportFragmentManager.beginTransaction().replace(R.id.cl_content, MainFragment()).commit()
    }
}