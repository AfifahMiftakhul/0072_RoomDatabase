
package com.example.contoh7.view.route

import com.example.contoh7.R
import com.example.contoh7.uicontroller.DestinasiNavigasi

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa

    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}
