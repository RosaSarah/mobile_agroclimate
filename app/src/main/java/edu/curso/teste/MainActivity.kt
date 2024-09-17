package edu.curso.teste;

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide() // Esconde a ActionBar

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val errorTextView = findViewById<TextView>(R.id.errorTextView) // Certifique-se de que o ID esteja correto no XML
        val loginButton = findViewById<Button>(R.id.loginButton)
        val createAccountTextView = findViewById<TextView>(R.id.createAccountTextView)

        // Quando o usuário clicar no botão de login
        loginButton.setOnClickListener {
            val emailInput = emailEditText.text.toString()
            val passwordInput = passwordEditText.text.toString()

            // Verifique as credenciais
            if (emailInput == "usuario@exemplo.com" && passwordInput == "senha") {
                // Se as credenciais estiverem corretas, navegue para a HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                // Mostrar mensagem de erro ou lidar com login incorreto
                errorTextView.text = "E-mail ou senha incorretos"
                errorTextView.visibility = View.VISIBLE // Garante que o erro será mostrado
            }
        }

        // Quando o usuário clicar no texto de criação de conta
        createAccountTextView.setOnClickListener {
            // Lógica para redirecionar o usuário para a tela de criação de conta
            Toast.makeText(this, "Redirecionando para criação de conta...", Toast.LENGTH_SHORT).show()

            // Navegar para a CadastroActivity
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}
