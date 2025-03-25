package com.example.conta_barzinho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conta_barzinho.databinding.ActivityTelaContasBinding
import com.google.android.material.snackbar.Snackbar

class TelaContas : AppCompatActivity() {

    private lateinit var binding: ActivityTelaContasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaContasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {


            val tempCervaVal = binding.edittxValorcerva.text
            val tempCervaQtd = binding.edittxtQtdcerva.text
            val tempNaoAlcolVal = binding.edttextValornaoalcool.text
            val tempTiragValue = binding.edttextValorTiragosto.text
            val tempNPessoas = binding.edttextNpessoas.text

            if ( tempCervaVal?.isEmpty() == true ||
                tempCervaQtd?.isEmpty() == true ||
                tempNaoAlcolVal?.isEmpty() == true ||
                tempTiragValue?.isEmpty() == true ||
                tempNPessoas?.isEmpty() == true
            ) {
                Snackbar
                    .make(
                        binding.edittxValorcerva,
                        "Preencha todos os campos(mesmo com 0)",
                        Snackbar.LENGTH_LONG
                    ).show()

            } else {


                val cervaValor: Float = binding.edittxValorcerva.text.toString().toFloat()
                val cervaQtd: Int = binding.edittxtQtdcerva.text.toString().toInt()
                val naoAlcolValor: Float = binding.edttextValornaoalcool.toString().toFloat()
                val tiragValor: Float = binding.edttextValorTiragosto.toString().toFloat()

                val nPessoas: Int = binding.edttextNpessoas.toString().toInt()

            }

        }

    }
}