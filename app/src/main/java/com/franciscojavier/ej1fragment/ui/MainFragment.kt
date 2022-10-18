package com.franciscojavier.ej1fragment.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.franciscojavier.ej1fragment.model.Person
import com.franciscojavier.ejrecycler.R
import com.franciscojavier.ejrecycler.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    val photo: String = "https://loremflickr.com/g/240/320/person"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = PersonAdapter(persons) {
                    person->
                parentFragmentManager.commit{
                    replace(R.id.fragment_container_view, DetailFragment.create(person))
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }

            }
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
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