
package com.example.contoh7.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.contoh7.AplikasiSiswa

object PenyediaViewModel {

    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            EntryViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            DetailViewModel(
                savedStateHandle = createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            EditViewModel(
                savedStateHandle = createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
            as AplikasiSiswa)
