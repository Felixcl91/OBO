package com.obo.opo.bomberos.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.obo.opo.bomberos.data.dataSource.local.dao.BlockDao
import com.obo.opo.bomberos.data.dataSource.local.dao.QuestionDao
import com.obo.opo.bomberos.data.dataSource.local.dao.TemariesDao
import com.obo.opo.bomberos.data.dataSource.local.dao.ThemeDao
import com.obo.opo.bomberos.data.dataSource.local.entity.BlockEntity
import com.obo.opo.bomberos.data.dataSource.local.entity.QuestionEntity
import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import com.obo.opo.bomberos.data.dataSource.local.entity.ThemeEntity

@Database(
    entities = [TemaryEntity::class,
               BlockEntity::class,
               ThemeEntity::class,
               QuestionEntity::class],
    version = 2,
    exportSchema = false
)
abstract class OboDB: RoomDatabase() {

    abstract fun temariesDao(): TemariesDao // DATA ACCESS OBJECT

    abstract fun blocksDao(): BlockDao

    abstract fun themesDao(): ThemeDao

    abstract fun questionsDao(): QuestionDao
}