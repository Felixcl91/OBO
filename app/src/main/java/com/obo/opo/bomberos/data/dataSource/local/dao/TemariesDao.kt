package com.obo.opo.bomberos.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TemariesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(temary: TemaryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(temaries: List<TemaryEntity>)

    @Query("SELECT * FROM temaries")
    fun getTemaries(): Flow<List<TemaryEntity>>

}