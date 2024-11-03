package com.obo.opo.bomberos.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.obo.opo.bomberos.core.Config.AUTH_KEY
import com.obo.opo.bomberos.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDatastore(private val dataStore: DataStore<Preferences>) {

    // METODO PARA GUARDAR DATOS
    suspend fun saveUser(authResponse: AuthResponse) {
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[datastoreKey] = authResponse.toJson()

        }
    }

    // METODO PARA OBTENER DATOS GUARDADOS
    fun getData(): Flow<AuthResponse> {
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[datastoreKey] != null) {
                AuthResponse.fromJson(pref[datastoreKey]!!)
            } else {
                AuthResponse()
            }
        }
    }
}