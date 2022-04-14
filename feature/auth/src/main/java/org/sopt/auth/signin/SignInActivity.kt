package org.sopt.auth.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.auth.R
import org.sopt.auth.databinding.ActivitySignInBinding
import org.sopt.auth.signup.SignUpActivity
import org.sopt.core.base.BindingActivity
import org.sopt.core.util.ext.shortToast
import org.sopt.core.util.getGifLoader
import org.sopt.home.HomeActivity

@AndroidEntryPoint
class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private val requestIdAndPassActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                val intent = activityResult.data
                if (intent != null) {
                    binding.etEmail.setText(intent.extras?.getString("id"))
                    binding.etPassword.setText(intent.extras?.getString("password"))
                }
            } else {
                binding.etEmail.text.clear()
                binding.etPassword.text.clear()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.ivLogo.load(R.raw.gif_guy_run, getGifLoader())
        initClickEvent()
    }

    private fun initClickEvent() {
        binding.tvSignUp.setOnClickListener {
            requestIdAndPassActivity.launch(Intent(this@SignInActivity, SignUpActivity::class.java))
        }

        binding.btnSignIn.setOnClickListener {
            when (isEtIdEmpty() || isEtPasswordEmpty()) {
                true -> shortToast("아이디/비밀번호를 확인해주세요")
                else -> startHomeActivity()
            }
        }
    }

    private fun isEtIdEmpty(): Boolean = binding.etEmail.text.isNullOrEmpty()

    private fun isEtPasswordEmpty(): Boolean = binding.etPassword.text.isNullOrEmpty()

    private fun startHomeActivity() {
        shortToast("로그인 성공")
        startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
        finish()
    }
}
