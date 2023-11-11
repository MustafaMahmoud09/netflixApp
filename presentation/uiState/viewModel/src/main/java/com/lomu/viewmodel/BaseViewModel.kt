package com.lomu.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    val coroutineScope = CoroutineScope(Dispatchers.Default)

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}