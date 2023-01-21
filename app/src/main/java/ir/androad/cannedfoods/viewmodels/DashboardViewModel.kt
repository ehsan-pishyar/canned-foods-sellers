package ir.androad.cannedfoods.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.domain.models.responses.SellerDetailsResponse
import ir.androad.domain.use_cases.seller.GetSellerDetailsUseCase
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getSellerDetailsUseCase: GetSellerDetailsUseCase
): ViewModel() {

    init {
        getSellerDetails(1)
    }

    var state by mutableStateOf(SellerDetailsState())

    fun getSellerDetails(sellerId: Long) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                sellerDetails = null,
                isError = null
            )
            when(val result = getSellerDetailsUseCase.invoke(sellerId)) {
                is ServiceResult.Success -> {
                    state = state.copy(
                        isLoading = false,
                        sellerDetails = result.data,
                        isError = null
                    )
                }
                is ServiceResult.Error -> {
                    state = state.copy(
                        isLoading = false,
                        sellerDetails = null,
                        isError = result.message
                    )
                }
                else -> Unit
            }
        }
    }

}

data class SellerDetailsState(
    val isLoading: Boolean = false,
    val isError: String? = null,
    val sellerDetails: SellerDetailsResponse? = null
)
