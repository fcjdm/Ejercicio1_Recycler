package com.franciscojavier.ejrecycler

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.franciscojavier.ejrecycler.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    val photo: String = "https://loremflickr.com/g/240/320/person"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = PersonAdapter(persons) {
                    person->
                val intent = Intent(this@MainFragment, DetailFragment::class.java)
                intent.putExtra(DetailFragment.EXTRA_PERSON, person)
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