package org.d3if3148.assesmentmobpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if3148.assesmentmobpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener {konversiRupiah()}
        binding.buttonHitung2.setOnClickListener {konversiDollar()}

    }

    private fun konversiRupiah() {

        val input = binding.inputanJumlahUang.text.toString()
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Masukkan Jumlah Uang!", Toast.LENGTH_SHORT).show()
            return
        }

        val angka1 = binding.inputanJumlahUang.text.toString().toFloat()

        val textHasil = angka1 / 14978

        binding.textHasil.text = "$textHasil USD"
    }

    private fun konversiDollar() {

        val input = binding.inputanJumlahUang.text.toString()
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Masukkan Jumlah Uang!", Toast.LENGTH_SHORT).show()
            return
        }

        val angka1 = binding.inputanJumlahUang.text.toString().toFloat()

        val textHasil = angka1 * 14978

        binding.textHasil.text = "IDR $textHasil"
    }
}