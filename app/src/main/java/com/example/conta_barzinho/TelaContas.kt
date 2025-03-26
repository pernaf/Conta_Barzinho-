package com.example.conta_barzinho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conta_barzinho.databinding.ActivityTelaContasBinding
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat
import java.util.Locale

class TelaContas : AppCompatActivity() {

    private lateinit var binding: ActivityTelaContasBinding

    private fun formatarMoeda(valor: Double): String {
        val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return formatador.format(valor)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaContasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        binding.radioButtonGorjeta.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 10
            }
        }

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
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    ).show()

            } else {


                val cervaValor: Float = binding.edittxValorcerva.text.toString().toFloat()
                val cervaQtd: Int = binding.edittxtQtdcerva.text.toString().toInt()
                val naoAlcolValor: Float = binding.edttextValornaoalcool.text.toString().toFloat()
                val tiragValor: Float = binding.edttextValorTiragosto.text.toString().toFloat()
                val nPessoas: Int = binding.edttextNpessoas.text.toString().toInt()

                val resultCervaTotal = cervaValor * cervaQtd
                val contaTotal = resultCervaTotal + naoAlcolValor + tiragValor

                val totalComGorjeta = contaTotal + (contaTotal * percentage / 100)

                val porPessoa = if (nPessoas > 0) totalComGorjeta / nPessoas else totalComGorjeta

                binding.tvResultado.text = formatarMoeda(porPessoa.toDouble())


            }

        }

    }
}