package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.dataSource.local.datastore.AuthDatastore
import com.obo.opo.bomberos.data.dataSource.local.AuthLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.AuthLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.TemariesLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.TemariesLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.dao.TemariesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun providesTemariesLocalDataSource(temariesDao: TemariesDao): TemariesLocalDataSource = TemariesLocalDataSourceImpl(temariesDao)
}