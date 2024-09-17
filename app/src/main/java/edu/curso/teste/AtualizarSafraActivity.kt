package edu.curso.teste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AtualizarSafraActivity : AppCompatActivity() {

    private lateinit var etNomeSafra: EditText
    private lateinit var btnAtualizar: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_safra_)

        // Referências aos elementos do layout
        etNomeSafra = findViewById(R.id.etNomeSafra)
        btnAtualizar = findViewById(R.id.btnAtualizar)
        tvResultado = findViewById(R.id.tvResultado)

        // Obter o ID da safra a ser atualizada a partir do Intent
        val safraId = intent.getStringExtra("SAFRA_ID")

        // Se houver um ID de safra, buscar e exibir os detalhes existentes
        if (safraId != null) {
            buscarSafra(safraId)
        }

        // Configurar o clique do botão "Atualizar"
        btnAtualizar.setOnClickListener {
            val nomeSafra = etNomeSafra.text.toString()

            if (nomeSafra.isNotEmpty()) {
                // Atualizar a safra com o nome fornecido
                atualizarSafra(safraId ?: "", nomeSafra)
            } else {
                // Mensagem de erro se o nome da safra estiver vazio
                tvResultado.text = "Por favor, informe o nome da safra."
            }
        }
    }

    private fun buscarSafra(safraId: String) {
        // Implementar lógica para buscar a safra existente com base no ID
        // Exemplo: consultar o banco de dados ou API para obter detalhes da safra

        // Simulação de dados
        val nomeSafra = "Nome da Safra Exemplo" // Substitua pelo nome real da safra
        etNomeSafra.setText(nomeSafra)
    }

    private fun atualizarSafra(safraId: String, nomeSafra: String) {
        // Implementar lógica para atualizar a safra com o novo nome
        // Exemplo: atualizar no banco de dados ou enviar uma solicitação para uma API

        // Simulação de sucesso
        tvResultado.text = "Safra atualizada com sucesso! Novo nome: $nomeSafra"
    }
}
