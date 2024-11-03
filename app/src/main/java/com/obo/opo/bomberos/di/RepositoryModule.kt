package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.repository.AuthRepositoryImpl
import com.obo.opo.bomberos.data.repository.BlocksRepositoryImpl
import com.obo.opo.bomberos.data.repository.QuestionRepositoryImpl
import com.obo.opo.bomberos.data.repository.TemariesRepositoryImpl
import com.obo.opo.bomberos.data.repository.ThemeRepositoryImpl
import com.obo.opo.bomberos.data.repository.dataSource.AuthLocalDataSource
import com.obo.opo.bomberos.data.repository.dataSource.AuthRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.BlockRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.QuestionRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.TemaryRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.ThemeRemoteDataSource
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
        temaryRemoteDataSource: TemaryRemoteDataSource
    ): TemaryRepository =
        TemariesRepositoryImpl(temaryRemoteDataSource)

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