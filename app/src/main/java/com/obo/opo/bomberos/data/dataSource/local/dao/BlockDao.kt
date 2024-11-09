package com.obo.opo.bomberos.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.obo.opo.bomberos.data.dataSource.local.entity.BlockEntity
import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BlockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(block: BlockEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(blocks: List<BlockEntity>)

    @Query("SELECT * FROM blocks")
    fun getBlocks(): Flow<List<BlockEntity>>


}