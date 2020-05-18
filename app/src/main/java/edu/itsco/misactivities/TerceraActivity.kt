package edu.itsco.misactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TerceraActivity : AppCompatActivity(), View.OnClickListener {

    private var num1:Int =0
    private var num2:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tercera)

        val intent: Intent = getIntent()
        num1 = intent.getIntExtra("num1", 0)
        num2 = intent.getIntExtra("num2", 0)

        val btnResultado: Button = findViewById(R.id.btn_resultado)
        btnResultado.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent: Intent = Intent()
        val resultado: Int = num1 + num2
        intent.putExtra("RESULTADO", resultado)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
