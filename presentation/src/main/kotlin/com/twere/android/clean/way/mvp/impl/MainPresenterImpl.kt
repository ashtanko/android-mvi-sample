package com.twere.android.clean.way.mvp.impl

import com.twere.android.clean.way.mvp.presenter.MainPresenter
import com.twere.android.clean.way.mvp.view.MainView
import com.twere.data.DribbleItem
import com.twere.data.api.dribbble.DribbleService
import com.twere.data.util.log
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenterImpl : MainPresenter {

    val api: DribbleService

    @Inject constructor(api: DribbleService) {
        this.api = api
    }

    private var view: MainView? = null

    override fun init(view: MainView) {
        this.view = view
    }

    override fun destroy() {
    }

    override fun destroyView() {
    }

    override fun resume(api: DribbleService) {

    }

    fun testApi(){

    }

    fun getFeed(page: Int, pageSize: Int) {
        getFeedObservable(page, pageSize)?.subscribe { s ->
            Observable.from(s).subscribe {
                item ->
                log(item.height)
            }

        }
    }

    fun getFeedObservable(page: Int, pageSize: Int): Observable<List<DribbleItem>>? {
        return api.getPopular(page, pageSize).asObservable()
    }
}