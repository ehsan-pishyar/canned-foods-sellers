package ir.androad.cannedfoods.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.domain.models.User
import ir.androad.domain.models.responses.UserResponse
import ir.androad.domain.use_cases.user.GetUsersByEmailUseCase
import ir.androad.domain.use_cases.user.InsertUserUseCase
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase,
    private val getUsersByEmailUseCase: GetUsersByEmailUseCase
): ViewModel() {

    var state by mutableStateOf(RegisterUserState())

    fun getUsersByEmail(email: String?) {
        viewModelScope.launch {
            getUsersByEmailUseCase.invoke(email!!).collect { userResponse ->
                when(userResponse) {
                    is ServiceResult.Loading -> {
                        state = state.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        state = state.copy(
                            loading = false,
                            success = true,
                            users = userResponse.data,
                            error = null
                        )
                    }
                    is ServiceResult.Error -> {
                        state = state.copy(
                            loading = false,
                            success = false,
                            users = null,
                            error = userResponse.message
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

    fun insertUser(user: User) {

    }
}

data class RegisterUserState(
    val loading: Boolean = true,
    val success: Boolean = false,
    val users: List<UserResponse>? = emptyList(),
    val error: String? = null
)