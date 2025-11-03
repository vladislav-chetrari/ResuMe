package com.vchetrari.resume.feature.launch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LaunchScreen(
    onResult: (Result<Unit>) -> Unit = {},
) {
    val viewModel = koinViewModel<LaunchViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val result = uiState.result
    if (result != null) {
        onResult(result)
        return
    }
    LaunchScreen(uiState)
}

@Composable
private fun LaunchScreen(
    uiState: LaunchUiState,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        //oh no there's no LoadingIndicator from material3 !!!
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
        )
    }
}