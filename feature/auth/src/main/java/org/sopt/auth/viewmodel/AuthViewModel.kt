package org.sopt.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.domain.AuthRepository
import org.sopt.domain.entity.User
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepo: AuthRepository) : ViewModel() {
    private val _authUiState =
        MutableStateFlow<AuthUiState>(AuthUiState.Empty)
    val authUiState: StateFlow<AuthUiState>
        get() = _authUiState.asStateFlow()

    fun insertUserData(user: User) {
        viewModelScope.launch {
            authRepo.insert(user)
        }
    }

    sealed class AuthUiState {
        object Empty : AuthUiState()
        data class Success(val data: User) : AuthUiState()
        data class Error(val message: String?) : AuthUiState()
    }
}
