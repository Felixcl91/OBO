package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.datastore.AuthDatastore
import com.obo.opo.bomberos.data.repository.dataSource.AuthLocalDataSource
import com.obo.opo.bomberos.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)
}