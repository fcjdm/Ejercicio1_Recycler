package com.franciscojavier.ejrecycler

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.franciscojavier.ejrecycler.databinding.ActivityDetailBinding
import com.franciscojavier.ejrecycler.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    companion object{
        const val EXTRA_PERSON = "person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater).apply{
            setContentView(root)
            val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
            if (person != null){
                textDetailName.text = person.name;
                Glide.with(photoDetail)
                    .load(person.photo)
                    .into(photoDetail)

            }

            llamarButton.setOnClickListener {
                val sendIntent = Intent().apply {
                    action = (Intent.ACTION_DIAL)
                    if (person != null) {
                        data = Uri.parse(person.phone)
                    }
                }
                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(packageManager) != null) {
                    startActivity(sendIntent)
                }
            }

            emailButton.setOnClickListener {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    if (person != null) {
                        putExtra(Intent.EXTRA_EMAIL, person.email)
                    }
                    type = "text/plain"
                }
                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(packageManager) != null) {
                    startActivity(sendIntent)
                }
            }
        }


    }
}