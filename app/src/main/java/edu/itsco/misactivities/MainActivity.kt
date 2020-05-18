package edu.itsco.misactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnllamar: Button = findViewById(R.id.btn_llamar)
        btnllamar.setOnClickListener(this);

        val btnNuevaActivity: Button = findViewById(R.id.btn_nueva_ativity)
        btnNuevaActivity.setOnClickListener(this);

        val btnTerceraActivity: Button = findViewById(R.id.btn_enviar)
        btnTerceraActivity.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_llamar){
            llamar()
        }else if (v?.id == R.id.btn_nueva_ativity){
            nuevaActivity()
        }else if (v?.id == R.id.btn_enviar){
            esperarResultado()
        }
    }

    fun llamar(){
        val intent: Intent = Intent(Intent.ACTION_DIAL)
        startActivity(intent)
    }

    fun nuevaActivity(){
        val intent: Intent = Intent(this, SegundaActivity::class.java)
        startActivity(intent)
    }

    fun esperarResultado(){
        val intent: Intent = Intent (this, TerceraActivity::class.java)
        intent.putExtra("num1", 5)
        intent.putExtra("num2", 3)
        startActivityForResult(intent, 10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var resultado: Int?
        resultado = data?.getIntExtra("RESULTADO", 0)
        Toast.makeText(this, "El resultado es"+resultado,Toast.LENGTH_SHORT).show()
    }
}
