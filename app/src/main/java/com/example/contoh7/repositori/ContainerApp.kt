package com.example.contoh7.repositori

import android.content.Context
import com.example.contoh7.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}
class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoriSiswa: RepositoriSiswa =
        OfflineRepositoriSiswa(siswaDao = DatabaseSiswa.getDatabase(context).siswaDao())
}
