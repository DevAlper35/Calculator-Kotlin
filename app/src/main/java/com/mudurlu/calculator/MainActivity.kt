package com.mudurlu.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mudurlu.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var sayi1 : Int? = null
    var sayi2 : Int? = null
    var islem : String? = null
    var sonuc : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun sonuc(){
        binding.textSayi1.text = sayi1.toString()
        binding.textIslem.text = islem.toString()
        binding.textSayi2.text = sayi2.toString()
        binding.textEsittir.text = "="
        binding.textSonuc.text = sonuc.toString()
    }

    fun topla(view: View){
        if (binding.editSayi1.text.toString() != "" || binding.editSayi2.text.toString() != ""){
            sayi1 = binding.editSayi1.text.toString().toInt()
            sayi2 = binding.editSayi2.text.toString().toInt()
            islem = "+"
            sonuc = sayi1!! + sayi2!!
            sonuc()
        }else{
            Toast.makeText(this,"Sayıları giriniz",Toast.LENGTH_SHORT).show()
        }
    }

    fun cikart(view: View){
        if (binding.editSayi1.text.toString() != "" || binding.editSayi2.text.toString() != ""){
            sayi1 = binding.editSayi1.text.toString().toInt()
            sayi2 = binding.editSayi2.text.toString().toInt()
            islem = "-"
            sonuc = sayi1!! - sayi2!!
            sonuc()
        }else{
            Toast.makeText(this,"Sayıları giriniz",Toast.LENGTH_SHORT).show()
        }
    }

    fun carp(view: View){
        if (binding.editSayi1.text.toString() != "" || binding.editSayi2.text.toString() != ""){
            sayi1 = binding.editSayi1.text.toString().toInt()
            sayi2 = binding.editSayi2.text.toString().toInt()
            islem = "X"
            sonuc = sayi1!! * sayi2!!
            sonuc()
        }else{
            Toast.makeText(this,"Sayıları giriniz",Toast.LENGTH_SHORT).show()
        }
    }

    fun bol(view: View){
        if (binding.editSayi1.text.toString() == "" || binding.editSayi2.text.toString() == ""){
            Toast.makeText(this,"Sayıları giriniz",Toast.LENGTH_SHORT).show()
        }else if(binding.editSayi1.text.toString().toInt() == 0 ||binding.editSayi2.text.toString().toInt() == 0){

            Toast.makeText(this,"Bölmede SIFIR kullanamazsınız",Toast.LENGTH_SHORT).show()
        }
        else{
            sayi1 = binding.editSayi1.text.toString().toInt()
            sayi2 = binding.editSayi2.text.toString().toInt()
            islem = "/"
            sonuc = sayi1!! / sayi2!!
            sonuc()
        }
    }

}