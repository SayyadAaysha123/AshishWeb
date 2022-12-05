package com.royalcricket.predictions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {


    private lateinit var number: EditText
    private lateinit var btnConfirm: Button

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        number = findViewById(R.id.number)
        btnConfirm = findViewById(R.id.confirm)


        btnConfirm.setOnClickListener{

            val sNumber = number.text.toString().trim()
            val userMap = hashMapOf(
                "number" to sNumber
            )


//
            val userId = FirebaseAuth.getInstance().currentUser?.uid
            Log.e("Test--->",userId.toString());

//
            if (userId == null) {

//                db.child(userId).child("username").setValue(userMap)

                db.collection("user").document().set(userMap)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Successfully Added!", Toast.LENGTH_SHORT).show()
                        number.text.clear()
                        startActivity(Intent(this,UrlViewActivity::class.java))
                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                    }
            }

        }

    }
}