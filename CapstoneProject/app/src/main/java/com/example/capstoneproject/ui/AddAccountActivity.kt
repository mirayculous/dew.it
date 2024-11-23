package com.example.capstoneproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstoneproject.R
import kotlinx.android.synthetic.main.activity_add_account.*

class AddAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)

        btnNext.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isNotEmpty()) {
                // Lanjut ke Pilih Mata Uang Activity
                val intent = Intent(this, SelectCurrencyActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            } else {
                // Tampilkan pesan jika nama kosong
                Toast.makeText(this, "Masukkan nama untuk akunmu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
