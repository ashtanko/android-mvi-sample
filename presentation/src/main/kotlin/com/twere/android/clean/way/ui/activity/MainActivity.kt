package com.twere.android.clean.way.ui.activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.mvp.view.MainView
import com.twere.android.clean.way.util.NetworkUtil
import com.twere.android.clean.way.util.log
import com.twere.data.MainItem
import com.twere.presentation.R
import javax.inject.Inject

class MainActivity : BaseDrawerActivity(), MainView {


    @Inject
    lateinit var network: NetworkUtil

 /*   @Inject
    lateinit var api: DribbleService


*/

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

       /* presenter.init(this)
        presenter.resume(api)
        presenter.getFeed(0, 30)*/

    }

    override fun initList(list: List<MainItem>) {
        log(list.size)
    }
}