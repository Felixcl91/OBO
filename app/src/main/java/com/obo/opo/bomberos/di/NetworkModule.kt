package com.obo.opo.bomberos.di

import com.obo.opo.bomberos.core.Config
import com.obo.opo.bomberos.data.dataSource.remote.service.AuthService
import com.obo.opo.bomberos.data.dataSource.remote.service.BlockService
import com.obo.opo.bomberos.data.dataSource.remote.service.QuestionService
import com.obo.opo.bomberos.data.dataSource.remote.service.TemaryService
import com.obo.opo.bomberos.data.dataSource.remote.service.ThemeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// ETICIONES HTTP RETROFIT
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit { // POSTMAN - THUNDER - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Proveedor para nuestro servicio
    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return  retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideTemaryService(retrofit: Retrofit): TemaryService {
        return  retrofit.create(TemaryService::class.java)
    }

    @Provides
    @Singleton
    fun provideBlockService(retrofit: Retrofit): BlockService {
        return  retrofit.create(BlockService::class.java)
    }

    @Provides
    @Singleton
    fun provideThemeService(retrofit: Retrofit): ThemeService {
        return retrofit.create(ThemeService::class.java)
    }

    @Provides
    @Singleton
    fun provideQuestionService(retrofit: Retrofit): QuestionService {
        return retrofit.create(QuestionService::class.java)
    }
}