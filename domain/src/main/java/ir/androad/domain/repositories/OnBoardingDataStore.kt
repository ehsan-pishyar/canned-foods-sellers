package ir.androad.domain.repositories

import kotlinx.coroutines.flow.Flow

interface OnBoardingDataStore {

    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}