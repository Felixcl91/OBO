package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.dataSource.local.datastore.AuthDatastore
import com.obo.opo.bomberos.data.dataSource.local.AuthLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.AuthLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.BlocksLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.BlocksLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.QuestionsLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.QuestionsLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.TemariesLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.TemariesLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.ThemesLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.ThemesLocalDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.local.dao.BlockDao
import com.obo.opo.bomberos.data.dataSource.local.dao.QuestionDao
import com.obo.opo.bomberos.data.dataSource.local.dao.TemariesDao
import com.obo.opo.bomberos.data.dataSource.local.dao.ThemeDao
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

    @Provides
    fun providesBlocksLocalDataSource(blocksDao: BlockDao): BlocksLocalDataSource = BlocksLocalDataSourceImpl(blocksDao)

    @Provides
    fun providesThemesLocalDataSource(themeDao: ThemeDao): ThemesLocalDataSource = ThemesLocalDataSourceImpl(themeDao)

    @Provides
    fun providesQuestionsLocalDataSource(questionDao: QuestionDao): QuestionsLocalDataSource = QuestionsLocalDataSourceImpl(questionDao)


}