package com.franciscojavier.ejrecycler

import android.R.attr.phoneNumber
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.franciscojavier.ejrecycler.databinding.ActivityDetailBinding


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
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + person?.phone))

                startActivity(intent);
            }

            emailButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO);
                if (person != null) {
                    intent.data = Uri.parse("mailto:" + person.email)
                }

                startActivity(intent);

            }
        }


    }
}