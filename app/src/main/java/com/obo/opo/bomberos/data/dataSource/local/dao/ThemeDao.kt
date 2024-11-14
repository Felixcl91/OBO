package com.obo.opo.bomberos.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.obo.opo.bomberos.data.dataSource.local.entity.ThemeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ThemeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(theme: ThemeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(themes: List<ThemeEntity>)

    @Query("SELECT * FROM themes")
    fun getThemes(): Flow<List<ThemeEntity>>

    @Query("SELECT * FROM themes WHERE id_block = :id_block")
    fun getThemesById(id_block: String): Flow<List<ThemeEntity>>


}