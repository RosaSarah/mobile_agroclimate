package edu.curso.teste;
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Captura dos campos
        val etNome = findViewById<EditText>(R.id.etNome)
        val etCNPJ = findViewById<EditText>(R.id.etCNPJ)
        val etCEP = findViewById<EditText>(R.id.etCEP)
        val etTelefone = findViewById<EditText>(R.id.etTelefone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        // Ao clicar no botão "Enviar"
        btnEnviar.setOnClickListener {
            val nome = etNome.text.toString()
            val cnpj = etCNPJ.text.toString()
            val cep = etCEP.text.toString()
            val telefone = etTelefone.text.toString()
            val email = etEmail.text.toString()

            if (validarEntradas(nome, cnpj, cep, telefone, email)) {
                Toast.makeText(this, "Dados válidos! Enviando...", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Preencha os campos corretamente!", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Função de validação
    private fun validarEntradas(nome: String, cnpj: String, cep: String, telefone: String, email: String): Boolean {
        // Verificação se os campos estão vazios
        if (nome.isEmpty() || cnpj.isEmpty() || cep.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            return false
        }

        // Validação do CNPJ
        if (cnpj.length != 14) {
            return false
        }

        // Validação do CEP
        if (cep.length != 8) {
            return false
        }

        // Validação do telefone
        if (telefone.length < 10) {
            return false
        }

        // Validação de e-mail
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false
        }

        return true
    }
}
