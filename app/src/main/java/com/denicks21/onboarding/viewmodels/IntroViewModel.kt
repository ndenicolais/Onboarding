package com.denicks21.onboarding.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denicks21.onboarding.navigation.NavScreens
import com.denicks21.onboarding.repository.DataStoreRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class IntroViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(NavScreens.IntroPage.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = NavScreens.HomePage.route
                } else {
                    _startDestination.value = NavScreens.IntroPage.route
                }
            }
            _isLoading.value = false
        }
    }
}