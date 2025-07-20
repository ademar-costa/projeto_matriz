package br.com.projetomatriz

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// A anotação @HiltAndroidApp ativa a geração de código do Hilt.
@HiltAndroidApp
class MatrizApplication : Application()