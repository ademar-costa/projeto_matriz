package br.com.projetomatriz.data.local

    import androidx.room.Entity
    import androidx.room.PrimaryKey

    // Enum para representar as secções do questionário para fácil referência
    enum class QuestionnaireSection {
        DIGITAL_ASSETS,
        PEOPLE_AND_PROCESSES,
        TECHNOLOGY_AND_INFRASTRUCTURE,
        THIRD_PARTY_SERVICES
    }

    // Enum para representar as possíveis respostas
    enum class AnswerOption {
        YES,
        NO,
        PARTIALLY,
        DONT_KNOW,
        OCCASIONALLY,
        RECOMMENDED_NOT_MANDATORY,
        TAKES_A_FEW_DAYS,
        NO_FORMAL_PROCESS,
        MOSTLY,
        RARELY_OR_NEVER,
        MONTHLY_OR_LESS,
        YES_IT_FAILED,
        NEVER_TESTED,
        NOT_APPLICABLE // Para perguntas como "Não utilizamos esses serviços"
    }

    @Entity(tableName = "questions")
    data class QuestionEntity(
        @PrimaryKey val id: Int,
        val section: QuestionnaireSection,
        val questionText: String,
        val possibleAnswers: List<AnswerOption>
    )

    @Entity(tableName = "user_answers")
    data class UserAnswerEntity(
        @PrimaryKey(autoGenerate = true) val id: Long = 0,
        val questionId: Int,
        val answer: AnswerOption
    )