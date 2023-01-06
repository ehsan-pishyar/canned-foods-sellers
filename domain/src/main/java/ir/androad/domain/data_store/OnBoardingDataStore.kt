package ir.androad.domain.data_store

import kotlinx.coroutines.flow.Flow

interface OnBoardingDataStore {

    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}