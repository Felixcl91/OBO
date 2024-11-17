package com.obo.opo.bomberos.presentation.screens.block

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obo.opo.bomberos.domain.model.Block
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import com.obo.opo.bomberos.domain.useCase.blocks.BlocksUseCase
import com.obo.opo.bomberos.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlockViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val blocksUseCase: BlocksUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var data = savedStateHandle.get<String>("temary")
    var temary = Temary.fromJson(data!!)

    var blocksResponse by mutableStateOf<Resource<List<Block>>?>(null)
        private set

    init {
        Log.d("BlockViewModel", "DATA SAVED: $data")
        Log.d("BlockViewModel", "DATA TEMARY: $temary")
        //getBlocks()
        findByTemary()
    }

    // function without id temary
    fun getBlocks() = viewModelScope.launch {
        blocksResponse = Resource.Loading
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                blocksUseCase.getBlocksUseCase(data.token).collect() {
                    blocksResponse = it
                    Log.d("BlockViewModel", "DATA: $blocksResponse")
                }
            }
        }
    }

    // function with id Temary
    fun findByTemary() = viewModelScope.launch {
        blocksResponse = Resource.Loading // loading
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                Log.d("BlockViewModel", "Data Token Response: ${data.token}")
                blocksUseCase.findByTemaryUseCase(data.token, temary.id!!).collect() { // success
                    blocksResponse = it
                    Log.d("BlockViewModel", "DATA SUCCESS: $blocksResponse")
                }
            } else {
                Log.d("BlockViewModel", "Data Token Error: ${data.token}")
            }
        }
    }

}