package edu.curso.teste


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VisualizarSafraActivity : AppCompatActivity() {

    private lateinit var etNomeSafra: EditText
    private lateinit var btnVisualizar: Button
    private lateinit var tvResultado: TextView

    // Simulação de dados de safra para visualização (em um cenário real, os dados viriam de um banco de dados ou API)
    private val dadosSafra = mapOf(
        "2002" to "02/04/2024",
        "verao2023" to "01/12/2023"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_safra)

        etNomeSafra = findViewById(R.id.etNomeSafra)
        btnVisualizar = findViewById(R.id.btnVisualizar)
        tvResultado = findViewById(R.id.tvResultado)

        btnVisualizar.setOnClickListener {
            val nomeSafra = etNomeSafra.text.toString()

            // Verifica se a safra existe nos dados simulados
            if (dadosSafra.containsKey(nomeSafra)) {
                val dataInicio = dadosSafra[nomeSafra]
                tvResultado.text = "Data de início: $dataInicio"
            } else {
                tvResultado.text = "Safra não encontrada"
                Toast.makeText(this, "Safra não encontrada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
