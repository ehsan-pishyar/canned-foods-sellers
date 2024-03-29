package ir.androad.cannedfoods.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androad.domain.data_store.SellerDataStore
import ir.androad.domain.models.responses.SellerDetailsResponse
import ir.androad.domain.use_cases.seller.GetSellerDetailsUseCase
import ir.androad.domain.utils.ServiceResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getSellerDetailsUseCase: GetSellerDetailsUseCase,
    private val sellerDataStore: SellerDataStore
): ViewModel() {

    var state by mutableStateOf(SellerDetailsState())

    init {
        getSellerDetails()
    }

    private fun getSellerDetails() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            getSellerDetailsUseCase.invoke(sellerDataStore.readSellerId().toString().toLong()).collect {
                when(it) {
                    is ServiceResult.Success -> {
                        state = state.copy(
                            isLoading = false,
                            sellerDetails = it.data,
                            isError = null
                        )
                    }
                    is ServiceResult.Error -> {
                        state = state.copy(
                            isLoading = false,
                            sellerDetails = null,
                            isError = it.message
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

}

data class SellerDetailsState(
    val isLoading: Boolean = false,
    val isError: String? = null,
    val sellerDetails: SellerDetailsResponse? = null
)
