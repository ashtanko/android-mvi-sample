package com.twere.android.clean.way.ui.fragment

import android.os.Bundle
import android.widget.ImageView
import butterknife.bindView
import com.bumptech.glide.Glide
import com.twere.android.clean.way.di.component.ApplicationComponent
import com.twere.android.clean.way.util.CircleTransform
import com.twere.presentation.R

class MainFragment :BaseFragment() {

    val iv_avatar: ImageView by bindView(R.id.iv_avatar)

    override fun injectDependencies(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_main
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Glide.with(activity).load(R.drawable.android_wear).transform(CircleTransform(activity)).into(iv_avatar)
    }
}