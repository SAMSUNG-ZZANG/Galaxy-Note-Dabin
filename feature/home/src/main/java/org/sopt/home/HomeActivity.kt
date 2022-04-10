package org.sopt.home

import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import org.sopt.core.base.BindingActivity
import org.sopt.home.databinding.ActivityHomeBinding

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.ivOwner.load(R.raw.gif_guy_run) {
            transformations(CircleCropTransformation())
        }
    }
}
