package br.com.projetomatriz.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Enums para Impacto, Probabilidade e Nível de Risco
enum class ImpactLevel {
    LOW, MEDIUM, HIGH
}

enum class ProbabilityLevel {
    LOW, MEDIUM, HIGH
}

enum class RiskLevel {
    LOW, MEDIUM, HIGH
}

@Entity(tableName = "identified_risks")
data class IdentifiedRiskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val associatedQuestionId: Int,
    val description: String,
    val impactLevel: ImpactLevel,
    val probabilityLevel: ProbabilityLevel,
    val riskLevel: RiskLevel // Calculado a partir do impacto e probabilidade
)