package org.sopt.home

import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import org.sopt.core.base.BindingActivity
import org.sopt.home.databinding.ActivityHomeBinding

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.ivOwner.load("https://avatars.githubusercontent.com/u/70698151?v=4") {
            transformations(CircleCropTransformation())
        }
    }
}
