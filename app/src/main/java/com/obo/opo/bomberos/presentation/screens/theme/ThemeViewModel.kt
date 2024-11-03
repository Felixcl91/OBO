package com.obo.opo.bomberos.presentation.screens.theme

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.model.Theme
import com.obo.opo.bomberos.domain.useCase.themes.ThemesUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val themesUseCase: ThemesUseCase)
    : ViewModel() {

    var data = savedStateHandle.get<String>("block")
    var block = Block.fromJson(data!!)

    var themesResponse by mutableStateOf<Resource<List<Theme>>?>(null)
        private set

    init {
        Log.d("ThemeViewModel", "DATA SAVED: $data")
        Log.d("ThemeViewModel", "DATA TEMARY: $block")
        //getThemes()
        findByBlock()
    }

    // function without id block
    fun getThemes() = viewModelScope.launch {
        themesResponse = Resource.Loading
        themesUseCase.getThemesUseCase().collect() {
            themesResponse = it
            Log.d("ThemeViewModel", "DATA: $themesResponse")
        }
    }

    // function with id Block
    fun findByBlock() = viewModelScope.launch {
        themesResponse = Resource.Loading // loading
        themesUseCase.findByBlockUseCase(block.id!!).collect() { // SUCCESS
            themesResponse = it
            Log.d("ThemeViewModel", "DATA SUCCES: $themesResponse")
        }
    }

}