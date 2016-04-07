package com.twere.android.clean.way.mvp.view

import com.twere.data.MainItem

interface MainView {
  fun initList(list: List<MainItem>)
}