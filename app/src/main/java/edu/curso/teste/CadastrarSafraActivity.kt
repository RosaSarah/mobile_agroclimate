package edu.curso.teste

import androidx.appcompat.app.AppCompatActivity
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*
class CadastrarSafraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_safra)

        val etCropName: EditText = findViewById(R.id.etCultNome)
        val etStartDate: EditText = findViewById(R.id.etDtInicio)
        val etQuantity: EditText = findViewById(R.id.etQuant)
        val etEndDate: EditText = findViewById(R.id.etDtFinal)
        val btnSubmit: Button = findViewById(R.id.btnEnviar)

        // DatePicker for Start Date
        etStartDate.setOnClickListener {
            showDatePickerDialog(etStartDate)
        }

        // DatePicker for End Date
        etEndDate.setOnClickListener {
            showDatePickerDialog(etEndDate)
        }

        // Handle Submit Button Click
        btnSubmit.setOnClickListener {
            val cropName = etCropName.text.toString()
            val startDate = etStartDate.text.toString()
            val quantity = etQuantity.text.toString().toIntOrNull() ?: 0
            val endDate = etEndDate.text.toString()

            if (cropName.isNotEmpty() && startDate.isNotEmpty() && endDate.isNotEmpty() && quantity > 0) {
                Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos corretamente", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            editText.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day)

        datePickerDialog.show()
    }
}
