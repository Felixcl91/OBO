package com.obo.opo.bomberos.presentation.screens.temary.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.useCase.temaries.TemariesUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemaryViewModel
@Inject constructor(
    private val temariesUseCase: TemariesUseCase) : ViewModel() {

    var temariesResponse by mutableStateOf<Resource<List<Temary>>?>(null)
        private set

    init {
        getTemaries()
    }

    fun getTemaries() = viewModelScope.launch {
        temariesResponse = Resource.Loading
        temariesUseCase.getTemaries().collect() { data ->
            temariesResponse = data
        }
    }
}