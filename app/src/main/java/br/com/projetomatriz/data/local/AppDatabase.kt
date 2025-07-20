package br.com.projetomatriz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        QuestionEntity::class,
        UserAnswerEntity::class,
        IdentifiedRiskEntity::class
    ],
    version = 1,
    exportSchema = false // Para este projeto, podemos desativar
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun riskAssessmentDao(): RiskAssessmentDao
}
