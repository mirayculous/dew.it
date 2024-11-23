package com.example.capstoneproject.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.capstoneproject.R
import kotlinx.android.synthetic.main.activity_input_balance.*

class InputBalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_balance)

        // Ambil data nama pengguna dan mata uang dari intent sebelumnya
        val userName = intent.getStringExtra("USER_NAME") ?: "User"
        val currency = intent.getStringExtra("CURRENCY") ?: "Rp"

        // Atur input saldo menggunakan tombol keypad
        val currentText = StringBuilder()
        btnKeypad1.setOnClickListener { appendText("1", currentText) }
        btnKeypad2.setOnClickListener { appendText("2", currentText) }
        btnKeypad3.setOnClickListener { appendText("3", currentText) }
        btnKeypad4.setOnClickListener { appendText("4", currentText) }
        btnKeypad5.setOnClickListener { appendText("5", currentText) }
        btnKeypad6.setOnClickListener { appendText("6", currentText) }
        btnKeypad7.setOnClickListener { appendText("7", currentText) }
        btnKeypad8.setOnClickListener { appendText("8", currentText) }
        btnKeypad9.setOnClickListener { appendText("9", currentText) }
        btnKeypad0.setOnClickListener { appendText("0", currentText) }
        btnKeypadDot.setOnClickListener { appendText(".", currentText) }

        // Tombol Next untuk melanjutkan
        btnNext.setOnClickListener {
            val balanceText = etBalance.text.toString()
            val balance = balanceText.toDoubleOrNull()

            if (balance == null || balance <= 0) {
                Toast.makeText(this, "Masukkan saldo awal yang valid!", Toast.LENGTH_SHORT).show()
            } else {
                // Kirim data ke aktivitas berikutnya
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("CURRENCY", currency)
                intent.putExtra("BALANCE", balance)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun appendText(value: String, currentText: StringBuilder) {
        // Tambahkan nilai ke text input
        currentText.append(value)
        etBalance.setText(currentText.toString())
    }
}
