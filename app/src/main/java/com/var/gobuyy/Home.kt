package com.`var`.gobuyy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.`var`.gobuyy.databinding.ActivityHomeBinding
import com.`var`.gobuyy.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)


        auth = FirebaseAuth.getInstance()
        var currentUser = auth.currentUser

//        Reference
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddProducts::class.java))
            finish()
        }
        if (currentUser == null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.idLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}