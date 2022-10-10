package com.franciscojavier.ejrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.franciscojavier.ejrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val photo: String = "https://loremflickr.com/g/240/320/person"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycler.adapter = PersonAdapter(persons) {
                    person->
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_PERSON, person)
                startActivity(intent)
            }
        }
    }

    private val persons =
        listOf(
            Person("Juan", "123456789", "email@gmail.com", photo),
            Person("Fran", "532523590", "email@gmail.com", photo),
            Person("Ismael", "321425324", "email@gmail.com", photo),
            Person("Vali", "756744333", "email@gmail.com", photo),
            Person("Lechuga", "5235255", "email@gmail.com", photo),
            Person("Alberto", "643563634", "email@gmail.com", photo),
        )
}