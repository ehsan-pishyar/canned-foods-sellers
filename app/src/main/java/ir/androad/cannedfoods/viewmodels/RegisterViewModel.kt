package ir.androad.cannedfoods.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.cannedfoods.utils.emailRegex
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

    var userState by mutableStateOf(RegisterUserState())
    var validationState by mutableStateOf(UserValidationState())

    fun getUsersByEmail(email: String?) {
        viewModelScope.launch {
            getUsersByEmailUseCase.invoke(email!!).collect { userResponse ->
                when(userResponse) {
                    is ServiceResult.Loading -> {
                        userState = userState.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        userState = userState.copy(
                            loading = false,
                            success = true,
                            users = userResponse.data,
                            error = null
                        )
                    }
                    is ServiceResult.Error -> {
                        userState = userState.copy(
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
        viewModelScope.launch {
            when(val userInsertedState = insertUserUseCase.invoke(user)) {
                is ServiceResult.Success -> {
                    userState = userState.copy(
                        loading = false,
                        success = true,
                        userInserted = true
                    )
                }
                is ServiceResult.Error -> {
                    userState = userState.copy(
                        loading = false,
                        success = false,
                        userInserted = false
                    )
                }
                else -> Unit
            }
        }
    }

    fun emailValidation(email: String?) {
        viewModelScope.launch {
            emailRegex(email).collect {
                when(it) {
                    is ServiceResult.Success -> {
                        validationState = validationState.copy(
                            emailValidationIsSuccessful = true
                        )
                    }
                    is ServiceResult.Error -> {
                        validationState = validationState.copy(
                            emailValidationIsSuccessful = false
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

    fun passwordValidation(password: String?) {
        viewModelScope.launch {

        }
    }
}

data class RegisterUserState(
    val loading: Boolean = true,
    val success: Boolean = false,
    val users: List<UserResponse>? = emptyList(),
    val error: String? = null,
    val userInserted: Boolean = false
)

data class UserValidationState(
    val emailValidationIsSuccessful: Boolean = false,
    val passwordValidationIsSuccessful: Boolean = false

)