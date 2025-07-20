package br.com.projetomatriz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RiskAssessmentDao {

    // --- Funções para as Perguntas (Questions) ---

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionEntity>)

    @Query("SELECT * FROM questions WHERE section = :section")
    fun getQuestionsBySection(section: QuestionnaireSection): Flow<List<QuestionEntity>>

    // --- Funções para as Respostas do Utilizador (User Answers) ---

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserAnswer(answer: UserAnswerEntity)

    @Query("SELECT * FROM user_answers WHERE questionId = :questionId")
    fun getUserAnswer(questionId: Int): Flow<UserAnswerEntity?>

    // --- Funções para os Riscos Identificados (Identified Risks) ---

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRisk(risk: IdentifiedRiskEntity)

    @Query("SELECT * FROM identified_risks")
    fun getAllIdentifiedRisks(): Flow<List<IdentifiedRiskEntity>>

    @Query("DELETE FROM user_answers")
    suspend fun clearAllUserAnswers()

    @Query("DELETE FROM identified_risks")
    suspend fun clearAllIdentifiedRisks()
}