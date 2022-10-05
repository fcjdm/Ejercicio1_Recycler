package com.franciscojavier.ejrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.franciscojavier.ejrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycler.adapter = PersonAdapter(persons) {
                    person->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                //intent.putExtra(DetailActivity.EXTRA_PELICULA, person)
                startActivity(intent)
            }
        }
    }

    private val persons =
        listOf(
            Person("Juan", "123456789", "email@gmail.com"),
            Person("Fran", "532523590", "email@gmail.com"),
            Person("Ismael", "321425324", "email@gmail.com"),
            Person("Vali", "756744333", "email@gmail.com"),
            Person("Lechuga", "5235255", "email@gmail.com"),
            Person("Alberto", "643563634", "email@gmail.com"),
        )

}