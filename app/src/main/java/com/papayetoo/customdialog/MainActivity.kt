package com.papayetoo.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toast
        val btnToast: Button = findViewById(R.id.btnToast)
        btnToast.setOnClickListener {
            Toast.makeText(this, "This is ToastMessage", Toast.LENGTH_SHORT).show()
        }

        // SnackBar
        val btnSnackbar: Button = findViewById(R.id.btnSnackBar)
        btnSnackbar.setOnClickListener { view ->
            Snackbar.make(view, "This is SnackBar", Snackbar.LENGTH_SHORT).show()
        }

        // Default Dialog
        val btnDialog: Button = findViewById(R.id.btnDefaultDialog)
        btnDialog.setOnClickListener { view ->
            simpleDialog()
        }

        val btnCustomDialog: Button = findViewById(R.id.btnCustomDialog)
        btnCustomDialog.setOnClickListener {
            customDialog()
        }
    }

    private fun simpleDialog() {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder
            .setTitle("Default dialog")
            .setMessage("This is default Dialog")
            .setIcon(android.R.drawable.ic_dialog_alert)

        alertBuilder.setPositiveButton("Yes") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked Yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }

        alertBuilder.setNegativeButton("No") {dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }

        val alertDialog: AlertDialog = alertBuilder.create()
        alertDialog.setCancelable(false) // Will not user to cancel after remaining winddow
        alertDialog.show()
    }

    private fun customDialog() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.show()
    }
}