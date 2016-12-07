package com.twere.dribbblekotlin.ui.activity

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.twere.dribbble.R
import com.twere.dribbblekotlin.util.CircleTransform
import kotlinx.android.synthetic.main.activity_drawer.drawer_layout
import kotlinx.android.synthetic.main.activity_drawer.nav_view
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.nav_header_main.iv_avatar_profile
import kotlinx.android.synthetic.main.nav_header_main.ll_header

abstract class BaseDrawerActivity : HomeActivity() {

  override fun setContentView(layoutResID: Int) {
    super.setContentViewWithoutInject(R.layout.activity_drawer)
    val viewGroup = findViewById(R.id.fl_content) as ViewGroup
    LayoutInflater.from(this).inflate(layoutResID, viewGroup, true)
    bindViews()
    setupHeader()
    toolbar.setNavigationOnClickListener {
      drawer_layout.openDrawer(Gravity.START)
    }
  }

  override fun onBackPressed() {
    if (drawer_layout.isDrawerOpen(nav_view)) {
      drawer_layout.closeDrawer(nav_view)
    } else {
      super.onBackPressed()
    }
  }

  private fun setupHeader() {
    val headerLayout: View = nav_view.inflateHeaderView(R.layout.nav_header_main)

    iv_avatar_profile.setOnClickListener {
      onAvatarClick()
    }

    ll_header.setOnClickListener {
      onHeaderClick()
    }

    Glide.with(this).load(R.drawable.android_wear).transform(CircleTransform(this)).into(iv_avatar_profile)
  }

  private fun onAvatarClick() {
    drawer_layout.closeDrawer(Gravity.START)
  }

  private fun onHeaderClick() {
    drawer_layout.closeDrawer(Gravity.START)
  }
}