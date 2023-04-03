package com.example.listdemo

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class InputActivity : AppCompatActivity() {

    val REQUEST_CAMERA = 20
    var photo: Bitmap? = null
    lateinit var imgView:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        imgView = findViewById<ImageView>(R.id.imageView)
        val etName = findViewById<EditText>(R.id.etName)
        val etSName = findViewById<EditText>(R.id.etSName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnOK = findViewById<Button>(R.id.button)

        btnOK.setOnClickListener {
            val newPerson = Person(
                etName.text.toString(),
                etSName.text.toString(),
                etAge.text.toString().toInt(),
                R.drawable.p1, photo)
            val retIntent = Intent()
            retIntent.putExtra("newperson", newPerson)
            setResult(RESULT_OK,retIntent)
            finish()
        }

        imgView.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent,REQUEST_CAMERA)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        photo = data!!.extras!!.get("data") as Bitmap
        imgView.setImageBitmap(photo)
    }
}