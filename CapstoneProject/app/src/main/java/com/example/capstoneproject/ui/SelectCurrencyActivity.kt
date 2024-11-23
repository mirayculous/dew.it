package com.example.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.capstoneproject.R
import kotlinx.android.synthetic.main.activity_select_currency.*

class SelectCurrencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_currency)

        // Ambil data nama pengguna dari intent sebelumnya
        val userName = intent.getStringExtra("USER_NAME") ?: ""

        // Daftar mata uang untuk spinner
        val currencies = listOf("IDR - Rupiah", "USD - Dollar", "EUR - Euro", "JPY - Yen")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencies)
        spinnerCurrency.adapter = adapter

        // Tombol Next untuk melanjutkan
        btnNext.setOnClickListener {
            val selectedCurrency = spinnerCurrency.selectedItem?.toString()

            if (selectedCurrency.isNullOrEmpty()) {
                Toast.makeText(this, "Pilih mata uang terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Lanjut ke layar berikutnya (contohnya InputBalanceActivity)
                val intent = Intent(this, InputBalanceActivity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("CURRENCY", selectedCurrency)
                startActivity(intent)
            }
        }
    }
}
