package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.repository.AuthRepositoryImpl
import com.obo.opo.bomberos.data.repository.BlocksRepositoryImpl
import com.obo.opo.bomberos.data.repository.QuestionRepositoryImpl
import com.obo.opo.bomberos.data.repository.TemariesRepositoryImpl
import com.obo.opo.bomberos.data.repository.ThemeRepositoryImpl
import com.obo.opo.bomberos.data.dataSource.local.AuthLocalDataSource
import com.obo.opo.bomberos.data.dataSource.local.TemariesLocalDataSource
import com.obo.opo.bomberos.data.dataSource.remote.AuthRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.BlockRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.QuestionRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.TemaryRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.ThemeRemoteDataSource
import com.obo.opo.bomberos.domain.repository.AuthRepository
import com.obo.opo.bomberos.domain.repository.BlockRepository
import com.obo.opo.bomberos.domain.repository.QuestionRepository
import com.obo.opo.bomberos.domain.repository.TemaryRepository
import com.obo.opo.bomberos.domain.repository.ThemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRemoteDataSource(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource,
    ): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideTemaryRemoteDataSource(
        temaryRemoteDataSource: TemaryRemoteDataSource,
        temariesLocalDataSource: TemariesLocalDataSource
    ): TemaryRepository =
        TemariesRepositoryImpl(temaryRemoteDataSource, temariesLocalDataSource)

    @Provides
    fun provideBlockRemoteDataSource(
        blockRemoteDataSource: BlockRemoteDataSource
    ): BlockRepository =
        BlocksRepositoryImpl(blockRemoteDataSource)

    @Provides
    fun provideThemeRemoteDataSource(
        themeRemoteDataSource: ThemeRemoteDataSource
    ): ThemeRepository =
        ThemeRepositoryImpl(themeRemoteDataSource)

    @Provides
    fun provideQuestionRemoteDataSource(
        questionRemoteDataSource: QuestionRemoteDataSource
    ): QuestionRepository = QuestionRepositoryImpl(questionRemoteDataSource)
}