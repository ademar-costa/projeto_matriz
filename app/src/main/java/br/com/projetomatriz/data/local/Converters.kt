package br.com.projetomatriz.data.local

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromAnswerOptionList(value: List<AnswerOption>): String {
        return value.joinToString(",") { it.name }
    }

    @TypeConverter
    fun toAnswerOptionList(value: String): List<AnswerOption> {
        return value.split(',').map { AnswerOption.valueOf(it) }
    }
}
