package org.sopt.auth.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.auth.R
import org.sopt.auth.databinding.ActivitySignUpBinding
import org.sopt.auth.viewmodel.AuthViewModel
import org.sopt.core.base.BindingActivity
import org.sopt.core.util.ext.shortToast
import org.sopt.domain.entity.User

@AndroidEntryPoint
class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun initClickEvent() {
        binding.btnSignUp.setOnClickListener {
            if (isAllEditTextEmpty())
                shortToast(getString(R.string.is_empty))
            else {
                val name = binding.etName.text.toString()
                val id = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()

                viewModel.insertUserData(User(name, id, password))

                setResult(
                    Activity.RESULT_OK, Intent().apply {
                        putExtra("name", name)
                        putExtra("id", id)
                        putExtra("password", password)
                    }
                )
            }
        }
    }

    private fun isAllEditTextEmpty(): Boolean =
        isEtNameEmpty() || isEtIdEmpty() || isEtPasswordEmpty()

    private fun isEtNameEmpty(): Boolean = binding.etName.text.isNullOrEmpty()

    private fun isEtIdEmpty(): Boolean = binding.etEmail.text.isNullOrEmpty()

    private fun isEtPasswordEmpty(): Boolean = binding.etPassword.text.isNullOrEmpty()
}
