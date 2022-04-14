package org.sopt.androidassignment

import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import coil.load
import org.sopt.androidassignment.databinding.ActivitySplashBinding
import org.sopt.auth.signin.SignInActivity
import org.sopt.core.base.BindingActivity
import org.sopt.core.util.ext.startAnimation
import org.sopt.core.util.getGifLoader

class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAnim()
        initClickEvent()
    }

    private fun initAnim() {
        with(binding) {
            ivLogo.load(R.raw.gif_guy_run, getGifLoader())
            tvStart.startAnimation(this@SplashActivity, R.anim.anim_blink)
        }
    }

    private fun initClickEvent() {
        binding.clSplash.setOnClickListener {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                binding.ivLogo,
                requireNotNull(ViewCompat.getTransitionName(binding.ivLogo))
            )

            startActivity(Intent(this, SignInActivity::class.java), options.toBundle())
            finish()
        }
    }
}
