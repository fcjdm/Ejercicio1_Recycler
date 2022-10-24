package com.franciscojavier.ej1fragment.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.franciscojavier.ej1fragment.R
import com.franciscojavier.ej1fragment.databinding.FragmentMainBinding
import com.franciscojavier.ej1fragment.model.Person
import com.franciscojavier.ej1fragment.model.PersonsProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MainFragment : Fragment(R.layout.fragment_main) {

    private val adapter = PersonsAdapter(){ person -> navigateTo(person)}

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Ej1Fragment"

        if (adapter.itemCount == 0){
            loadItems()
        }
    }

    private fun loadItems() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            binding.progress.visibility = View.VISIBLE
            val person1 = async{ PersonsProvider.getPersons("dog") }
            val person2 = async{ PersonsProvider.getPersons("cat") }
            adapter.persons = person1.await() + person2.await()
            adapter.notifyDataSetChanged()
            binding.progress.visibility = View.GONE
        }
    }

    private fun navigateTo(person: Person) {
        findNavController().navigate(
            R.id.action_mainFragment_to_detailFragment,
            bundleOf(DetailFragment.EXTRA_PERSON to person)
        )

    }

}