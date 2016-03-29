package com.twere.android.clean.way.mvp.impl

import com.twere.android.clean.way.mvp.view.MainView
import com.twere.data.DribbleItem
import com.twere.data.MainItem
import com.twere.data.api.dribbble.DribbleService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner
import rx.Observable
import java.util.*
import javax.inject.Inject
import org.mockito.Mockito.`when` as When

@RunWith(MockitoJUnitRunner::class)
class MainPresenterImplTest {


    @Inject
    lateinit var api: DribbleService

    @Inject
    lateinit var presenter: MainPresenterImpl

    @Mock lateinit var view: MainView

    @Mock lateinit var repos: ArrayList<DribbleItem>
    @Mock lateinit var reposMain: ArrayList<MainItem>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter.init(view)
        presenter.resume(api)
    }

    @After
    fun tearDown() {
        presenter.destroy()
    }

    @Test
    fun shouldBeOk() {
        val error = RuntimeException()

        When(api.getPopular(1,1)).thenReturn(Observable.create {
            it?.run {
                onNext(repos)
                onCompleted()
            }
        })

        verify(view).initList(reposMain)
    }
}