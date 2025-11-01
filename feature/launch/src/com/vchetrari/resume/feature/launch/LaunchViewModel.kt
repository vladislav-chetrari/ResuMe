package com.vchetrari.resume.feature.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vchetrari.resume.logging.Log
import com.vchetrari.resume.logging.init
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

internal class LaunchViewModel(
) : ViewModel(CoroutineScope(SupervisorJob() + Dispatchers.Default)) {

    val uiState: StateFlow<LaunchUiState> = flow {
        val result = runCatching<Unit> { initComponents() }
        emit(LaunchUiState(result = result))
    }.stateIn(viewModelScope, SharingStarted.Lazily, LaunchUiState())

    private suspend fun initComponents() {
        Log.init()
    }
}