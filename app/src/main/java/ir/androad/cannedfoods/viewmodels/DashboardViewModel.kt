package ir.androad.cannedfoods.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.domain.models.responses.SellerDetailsResponse
import ir.androad.domain.use_cases.result.GetResultDetailsUseCase
import ir.androad.domain.use_cases.seller.GetSellerDetailsUseCase
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getSellerDetailsUseCase: GetSellerDetailsUseCase
): ViewModel() {

    init {

    }

    private val _sellerDetailsState = MutableStateFlow<SellerDetailsState>(SellerDetailsState.Loading)
    val sellerDetailsState: StateFlow<SellerDetailsState> get() = _sellerDetailsState

    fun getSellerDetails(sellerId: Long) {
        viewModelScope.launch {
            _sellerDetailsState.value = SellerDetailsState.Loading
            when(val result = getSellerDetailsUseCase.invoke(sellerId)) {
                is ServiceResult.Success -> {
                    _sellerDetailsState.value = SellerDetailsState.SellerDetails(result.data!!)
                }
                else -> {
                    _sellerDetailsState.value = SellerDetailsState.Error(result.message)
                }
            }
        }
    }

}

sealed interface SellerDetailsState {
    object Loading: SellerDetailsState
    data class SellerDetails(val sellerDetailsResponse: SellerDetailsResponse): SellerDetailsState
    data class Error(val error: String?): SellerDetailsState
}