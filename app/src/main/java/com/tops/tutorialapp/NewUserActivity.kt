package com.tops.tutorialapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.tops.tutorialapp.Db.AppDatabase
import com.tops.tutorialapp.databinding.ActivityNewUserBinding
import com.tops.tutorialapp.entities.User

class NewUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewUserBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").build()
        val dao= db.userDao()

        binding.btnsubmit.setOnClickListener {
            val user= User.User(null,binding.etfirstname.text.toString(),binding.etlastname.text.toString())
            dao.insertAll(user)
            Log.i("NewUserActivity", "intserted__!!")
        }
    }
}