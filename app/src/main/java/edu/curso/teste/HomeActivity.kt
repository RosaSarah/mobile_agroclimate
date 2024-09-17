package edu.curso.teste
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Configurar botão "Cadastrar Safra"
        val cadastrarSafraButton = findViewById<Button>(R.id.cadastrarSafraButton)
        cadastrarSafraButton.setOnClickListener {
            val intent = Intent(this, CadastrarSafraActivity::class.java)
            startActivity(intent)
        }

        // Configurar botão "Atualizar Safra"
        val atualizarSafraButton = findViewById<Button>(R.id.atualizarSafraButton)
        atualizarSafraButton.setOnClickListener {
            val intent = Intent(this, AtualizarSafraActivity::class.java)
            startActivity(intent)
        }

        // Configurar botão "Visualizar Safra"
        val visualizarSafraButton = findViewById<Button>(R.id.visualizarSafraButton)
        visualizarSafraButton.setOnClickListener {
            val intent = Intent(this, VisualizarSafraActivity::class.java)
            startActivity(intent)
        }
    }

    fun openWeather(view: View) {
        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
    }
}
