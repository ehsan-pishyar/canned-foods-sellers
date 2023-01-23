package ir.androad.cannedfoods.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.domain.data_store.OnBoardingDataStore
import ir.androad.domain.data_store.UserDataStore
import ir.androad.domain.use_cases.user.GetUserByEmailAndPasswordUseCase
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val onBoardingDataStoreRepository: OnBoardingDataStore,
    private val userDataStore: UserDataStore,
    private val getUserByEmailAndPasswordUseCase: GetUserByEmailAndPasswordUseCase
): ViewModel() {

//    private val _startDestination: MutableState<String> = mutableStateOf(StartScreens.OnBoarding.route)
//    val startDestination: State<String> = _startDestination

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch {
            onBoardingDataStoreRepository.saveOnBoardingState(completed)
        }
    }

//    fun readOnBoardingState() {
//        viewModelScope.launch {
//            onBoardingDataStoreRepository.readOnBoardingState().collect { completed ->
//                if (completed) {
//                    checkIfUserLoggedIn()
//                } else {
//                    _startDestination.value = StartScreens.OnBoarding.route
//                }
//            }
//        }
//    }

//    private fun checkIfUserLoggedIn() {
//        viewModelScope.launch {
//            val email = userDataStore.readUserEmail().toString()
//            val password = userDataStore.readUserPassword().toString()
//            getUserByEmailAndPasswordUseCase.invoke(email, password).let {
//                when(it) {
//                    is ServiceResult.Success -> {
//                        _startDestination.value = Graph.MAIN
//                    }
//                    else -> {
//                        _startDestination.value = Graph.AUTH
//                    }
//                }
//            }
//        }
//    }

    fun checkOnBoardingState(): Boolean {
        var isCompleted = false
        viewModelScope.launch {
            onBoardingDataStoreRepository.readOnBoardingState().collect {
                isCompleted = it
            }
        }
        return isCompleted
    }

    fun checkUserLoginState(): Boolean {
        var isLoggedIn = false
        viewModelScope.launch {
            val email = userDataStore.readUserEmail().toString()
            val password = userDataStore.readUserPassword().toString()
            getUserByEmailAndPasswordUseCase.invoke(email, password).let {
                isLoggedIn = when(it) {
                    is ServiceResult.Success -> {
                        //_startDestination.value = Graph.MAIN
                        true
                    }
                    is ServiceResult.Error -> {
                        //_startDestination.value = Graph.AUTH
                        false
                    }
                    else -> false
                }
            }
        }
        return isLoggedIn
    }

//    fun setStartDestination(isOnBoardingCompleted: Boolean, isUserLoggedIn: Boolean): String {
//        var destination = ""
//        viewModelScope.launch {
//            destination = if (isOnBoardingCompleted) {
//                if (isUserLoggedIn) {
//                    //_startDestination.value = Graph.MAIN
//                    Graph.MAIN
//                } else {
//                    //_startDestination.value = Graph.AUTH
//                    Graph.AUTH
//                }
//            } else {
//                //_startDestination.value = StartScreens.OnBoarding.route
//                StartScreens.OnBoarding.route
//            }
//        }
//
//        return destination
//    }
}