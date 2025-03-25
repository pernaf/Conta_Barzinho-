package com.example.conta_barzinho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conta_barzinho.databinding.ActivityTelaContasBinding

class TelaContas : AppCompatActivity() {

    private lateinit var binding: ActivityTelaContasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaContasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            val cervaValor: Float = binding.edittxValorcerva.text.toString().toFloat()
            val cervaQtd: Int = binding.edittxtQtdcerva.text.toString().toInt()
            val naoAlcolValor: Float = binding.edttextValornaoalcool.toString().toFloat()
            val tiragValor: Float = binding.edttextValorTiragosto.toString().toFloat()

            val nPessoas: Int = binding.edttextNpessoas.toString().toInt()






        }



    }
}