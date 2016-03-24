package com.twere.android.clean.way.mvp.presenter

import com.twere.android.clean.way.mvp.view.MainView
import com.twere.data.api.dribbble.DribbleService

interface MainPresenter : BasePresenter<MainView> {
    fun resume(api: DribbleService)
    fun destroy()
    fun destroyView()
}