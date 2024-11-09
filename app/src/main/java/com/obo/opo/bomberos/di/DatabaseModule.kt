package com.obo.opo.bomberos.di

import android.app.Application
import androidx.room.Room
import com.obo.opo.bomberos.data.dataSource.local.dao.BlockDao
import com.obo.opo.bomberos.data.dataSource.local.dao.QuestionDao
import com.obo.opo.bomberos.data.dataSource.local.dao.TemariesDao
import com.obo.opo.bomberos.data.dataSource.local.dao.ThemeDao
import com.obo.opo.bomberos.data.dataSource.local.db.OboDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): OboDB =
        Room.databaseBuilder(app, OboDB::class.java, "obo_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideTemariesDao(db: OboDB): TemariesDao = db.temariesDao()

    @Provides
    @Singleton
    fun provideBlocksDao(db: OboDB): BlockDao = db.blocksDao()

    @Provides
    @Singleton
    fun provideThemesDao(db: OboDB): ThemeDao = db.themesDao()

    @Provides
    @Singleton
    fun provideQuestionsDao(db: OboDB): QuestionDao = db.questionsDao()
}