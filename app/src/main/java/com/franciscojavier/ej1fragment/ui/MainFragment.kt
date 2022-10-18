package com.franciscojavier.ej1fragment.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.franciscojavier.ej1fragment.model.Person
import com.franciscojavier.ej1fragment.R
import com.franciscojavier.ej1fragment.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

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
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Ej1Fragment"
    }

    private val persons =
        listOf(
            Person("Juan", "123456789", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Fran", "532523590", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Ismael", "321425324", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Vali", "756744333", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Lechuga", "5235255", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Alberto", "643563634", "email@gmail.com", "https://loremflickr.com/240/320/person"),
        )
}