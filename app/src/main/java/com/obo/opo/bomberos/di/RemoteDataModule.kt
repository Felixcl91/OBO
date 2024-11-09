package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.data.dataSource.remote.AuthRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.BlockRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.QuestionRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.TemaryRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.ThemeRemoteDataSource
import com.obo.opo.bomberos.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.remote.BlockRemoteDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.remote.QuestionsRemoteDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.remote.TemariesRemoteDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.remote.ThemeRemoteDataSourceImpl
import com.obo.opo.bomberos.data.dataSource.remote.service.AuthService
import com.obo.opo.bomberos.data.dataSource.remote.service.BlockService
import com.obo.opo.bomberos.data.dataSource.remote.service.QuestionService
import com.obo.opo.bomberos.data.dataSource.remote.service.TemaryService
import com.obo.opo.bomberos.data.dataSource.remote.service.ThemeService
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