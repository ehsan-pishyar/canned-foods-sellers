package ir.androad.cannedfoods.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.domain.use_cases.user.GetUserByEmailAndPasswordUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserByEmailAndPasswordUseCase: GetUserByEmailAndPasswordUseCase
): ViewModel() {

    var state by mutableStateOf(UserState())

    fun getUserByEmailAndPassword(email: String, password: String) {
        viewModelScope.launch {
            state = state.copy(loading = true)
            val userState = getUserByEmailAndPasswordUseCase.invoke(email, password).data
            state = if (userState!!) {
                state.copy(
                    loading = false,
                    success = true,
                    error = null
                )
            } else {
                state.copy(
                    loading = false,
                    success = false,
                    error = "User login was error"
                )
            }
        }
    }
}

data class UserState(
    val loading: Boolean = true,
    val success: Boolean = false,
    val error: String? = null
)