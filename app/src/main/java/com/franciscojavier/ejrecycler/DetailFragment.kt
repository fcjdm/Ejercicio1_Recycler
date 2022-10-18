package com.franciscojavier.ejrecycler

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.franciscojavier.ejrecycler.databinding.FragmentDetailBinding


class DetailFragment: Fragment(R.layout.fragment_detail) {

    companion object{
        const val EXTRA_PERSON = "DetailActivity:person"

        fun create(movie: Person): DetailFragment =
            DetailFragment().apply {
                arguments = bundleOf(EXTRA_PERSON to movie)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view).apply {

            val person = arguments?.getParcelable<Person>(EXTRA_PERSON)

            if (person != null){
                textDetailName.text = person.name;
                photoDetail.loadUrl(person.photo)

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