package com.obo.opo.bomberos.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.obo.opo.bomberos.data.dataSource.local.entity.QuestionEntity
import com.obo.opo.bomberos.data.dataSource.local.entity.TemaryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question: QuestionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<QuestionEntity>)

    @Query("SELECT * FROM questions")
    fun getQuestions(): Flow<List<QuestionEntity>>


}