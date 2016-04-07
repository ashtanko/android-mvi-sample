package com.twere.android.clean.way.ui.activity

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.twere.android.clean.way.util.CircleTransform
import com.twere.presentation.R
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.nav_header_main.*

abstract class BaseDrawerActivity : BaseActivity() {

  override fun setContentView(layoutResID: Int) {
    super.setContentViewWithoutInject(R.layout.activity_drawer)
    val viewGroup = findViewById(R.id.fl_content) as ViewGroup
    LayoutInflater.from(this).inflate(layoutResID, viewGroup, true)
    bindViews()
    setupHeader()
    mToolbar.setNavigationOnClickListener {
      drawer_layout.openDrawer(Gravity.LEFT)
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

    Glide.with(this).load(R.drawable.android_wear).transform(CircleTransform(this)).into(
        iv_avatar_profile)
  }

  private fun onAvatarClick() {
    drawer_layout.closeDrawer(Gravity.LEFT)
  }

  private fun onHeaderClick() {
    drawer_layout.closeDrawer(Gravity.LEFT)
  }
}