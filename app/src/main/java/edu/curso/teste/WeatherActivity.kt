package edu.curso.teste
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)


        val weatherTextView = findViewById<TextView>(R.id.weatherTextView)

        val apiKey = "cbfca3cdf260d96d8b77e1e40a1c895f"


        // Chamada para obter o clima atual de uma cidade
        val call = RetrofitInstance.api.getCurrentWeather("São Paulo", apiKey)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    // Pega a resposta e atualiza a interface de usuário
                    val weatherResponse = response.body()
                    weatherTextView.text = "Cidade: ${weatherResponse?.name}, Temp: ${weatherResponse?.main?.temp}°C"
                } else {
                    weatherTextView.text = "Erro ao obter clima!"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                // Trata erro de conexão ou falha da API
                println("onFailure")
                weatherTextView.text = "Falha na conexão!"
            }
        })
    }
}
