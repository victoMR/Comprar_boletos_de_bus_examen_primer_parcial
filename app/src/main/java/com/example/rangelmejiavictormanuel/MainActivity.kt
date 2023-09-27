package com.example.rangelmejiavictormanuel

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etBoletos: EditText
    private lateinit var rgDestino: RadioGroup
    private lateinit var rbTequisquiapan: RadioButton
    private lateinit var rbQro: RadioButton
    private lateinit var rbCiudadMexico: RadioButton
    private lateinit var cbLunch: CheckBox
    private lateinit var tvResultado: TextView
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etBoletos = findViewById(R.id.etBoletos)
        rgDestino = findViewById(R.id.rgDestino)
        rbTequisquiapan = findViewById(R.id.rbTequisquiapan)
        rbQro = findViewById(R.id.rbQro)
        rbCiudadMexico = findViewById(R.id.rbCiudadMexico)
        cbLunch = findViewById(R.id.cbLunch)
        tvResultado = findViewById(R.id.tvResultado)
        btnCalcular = findViewById(R.id.btnCalcular)
        var precio1=0
        btnCalcular.setOnClickListener{
            if(etBoletos.text.isEmpty()){
                tvResultado.text="Debes ingresar una cantidad "
            }else if (etBoletos.text.toString().toInt() ==0){
                tvResultado.text="No puedes comprar 0 boletos "
                var precio1=0
            }
            else{
                var boletos =etBoletos.text.toString().toInt()

                if (rbTequisquiapan.isChecked) {
                    precio1= boletos*45
                }
                else if (rbQro.isChecked) {
                    precio1 = boletos*80
                }
                else if (rbCiudadMexico.isChecked) {
                    precio1= boletos*450
                }
                else{
                    tvResultado.text="No se selecciono nada  "
                }
                if (cbLunch.isChecked){
                    precio1 += boletos *20
                }else{
                    tvResultado.text="¿ Seguro de no querer un lunch ?"
                }
                tvResultado.text="Total a pagar : $ $precio1"
            }
        }
    }
}