package ir.androad.cannedfoods.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.cannedfoods.navigations.Graph
import ir.androad.domain.data_store.OnBoardingDataStore
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val onBoardingDataStoreRepository: OnBoardingDataStore
): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Graph.START)
    val startDestination: State<String> = _startDestination

    init {
        readOnBoardingState()
    }

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch {
            onBoardingDataStoreRepository.saveOnBoardingState(completed)
        }
    }

    private fun readOnBoardingState() {
        viewModelScope.launch {
            onBoardingDataStoreRepository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Graph.AUTH
                } else {
                    _startDestination.value = Graph.START
                }
            }
            _isLoading.value = false
        }
    }
}