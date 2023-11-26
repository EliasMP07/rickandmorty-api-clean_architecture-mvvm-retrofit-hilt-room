package com.devdroid.rickandmortyapp.iu.utils

import android.content.Context
import android.widget.Toast
import com.devdroid.rickandmortyapp.RickAndMortyApp
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object UtilsMessage {

    fun showAlertOk(titulo: String?, mensaje: String?, contexto: Context) {
        val builder = MaterialAlertDialogBuilder(contexto)
        builder.setMessage(mensaje)
            .setTitle(titulo)
            .setCancelable(false)
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.cancel() }
        builder.create().show()
    }

    fun showToast(mensaje: String) {
        Toast.makeText(
            RickAndMortyApp.getContext(),
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }

}