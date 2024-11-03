package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.domain.repository.AuthRepository
import com.obo.opo.bomberos.domain.repository.BlockRepository
import com.obo.opo.bomberos.domain.repository.QuestionRepository
import com.obo.opo.bomberos.domain.repository.TemaryRepository
import com.obo.opo.bomberos.domain.repository.ThemeRepository
import com.obo.opo.bomberos.domain.useCase.auth.AuthUseCase
import com.obo.opo.bomberos.domain.useCase.temaries.TemariesUseCase
import com.obo.opo.bomberos.domain.useCase.auth.GetSessionDataUseCase
import com.obo.opo.bomberos.domain.useCase.auth.LoginUseCase
import com.obo.opo.bomberos.domain.useCase.auth.RegisterUseCase
import com.obo.opo.bomberos.domain.useCase.auth.SaveSessionUseCase
import com.obo.opo.bomberos.domain.useCase.blocks.BlocksUseCase
import com.obo.opo.bomberos.domain.useCase.blocks.FindByTemaryUseCase
import com.obo.opo.bomberos.domain.useCase.blocks.GetBlocksUseCase
import com.obo.opo.bomberos.domain.useCase.questions.FindByThemeUseCase
import com.obo.opo.bomberos.domain.useCase.questions.GetQuestionsUseCase
import com.obo.opo.bomberos.domain.useCase.questions.QuestionsUseCase
import com.obo.opo.bomberos.domain.useCase.temaries.GetTemariesUseCase
import com.obo.opo.bomberos.domain.useCase.themes.FindByBlockUseCase
import com.obo.opo.bomberos.domain.useCase.themes.GetThemesUseCase
import com.obo.opo.bomberos.domain.useCase.themes.ThemesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository)
    )

    @Provides
    fun provideTemariesUseCase(temaryRepository: TemaryRepository) = TemariesUseCase(
        getTemaries = GetTemariesUseCase(temaryRepository)
    )

    @Provides
    fun provideBlocksUseCase(blocksRepository: BlockRepository) = BlocksUseCase(
        getBlocksUseCase = GetBlocksUseCase(blocksRepository),
        findByTemaryUseCase = FindByTemaryUseCase(blocksRepository)
    )

    @Provides
    fun provideThemesUseCase(themeRepository: ThemeRepository) = ThemesUseCase(
        getThemesUseCase = GetThemesUseCase(themeRepository),
        findByBlockUseCase = FindByBlockUseCase(themeRepository)
    )

    @Provides
    fun provideQuestionsUseCase(questionRepository: QuestionRepository) = QuestionsUseCase(
        getQuestionsUseCase = GetQuestionsUseCase(questionRepository),
        findByThemeUseCase = FindByThemeUseCase(questionRepository)
    )

}