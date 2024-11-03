package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.repository.dataSource.AuthRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.BlockRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.QuestionRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.TemaryRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSource.ThemeRemoteDataSource
import com.obo.opo.bomberos.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.obo.opo.bomberos.data.repository.dataSourceImpl.BlockRemoteDataSourceImpl
import com.obo.opo.bomberos.data.repository.dataSourceImpl.QuestionsRemoteDataSourceImpl
import com.obo.opo.bomberos.data.repository.dataSourceImpl.TemariesRemoteDataSourceImpl
import com.obo.opo.bomberos.data.repository.dataSourceImpl.ThemeRemoteDataSourceImpl
import com.obo.opo.bomberos.data.service.AuthService
import com.obo.opo.bomberos.data.service.BlockService
import com.obo.opo.bomberos.data.service.QuestionService
import com.obo.opo.bomberos.data.service.TemaryService
import com.obo.opo.bomberos.data.service.ThemeService
import com.obo.opo.bomberos.domain.repository.ThemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideTemaryRemoteDataSource(
        temaryService: TemaryService
        //authResponse: AuthResponse
        ): TemaryRemoteDataSource = TemariesRemoteDataSourceImpl(temaryService)

    @Provides
    fun provideBlockRemoteDataSource(
        blockService: BlockService
    ): BlockRemoteDataSource = BlockRemoteDataSourceImpl(blockService)

    @Provides
    fun provideThemeRemoteDataSource(
        themeService: ThemeService
    ): ThemeRemoteDataSource = ThemeRemoteDataSourceImpl(themeService)

    @Provides
    fun provideQuestionRemoteDataSource(
        questionService: QuestionService
    ): QuestionRemoteDataSource = QuestionsRemoteDataSourceImpl(questionService)
}