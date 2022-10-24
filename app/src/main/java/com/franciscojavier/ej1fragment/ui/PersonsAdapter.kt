package com.franciscojavier.ej1fragment.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.ej1fragment.model.Person
import com.franciscojavier.ej1fragment.inflate
import com.franciscojavier.ej1fragment.loadUrl
import com.franciscojavier.ej1fragment.R
import com.franciscojavier.ej1fragment.databinding.ViewPersonBinding

class PersonsAdapter(val listener: (Person) -> Unit): RecyclerView.Adapter<PersonsAdapter.ViewHolder>(){

    var persons = emptyList<Person>()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val binding = ViewPersonBinding.bind(view)
        fun bind(person: Person){
            binding.textName.text = person.name
            binding.textPhone.text = person.phone
            binding.textEmail.text = person.email
            binding.photo.loadUrl(person.photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_person, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(persons[position])
        holder.itemView.setOnClickListener{
            listener(persons[position])
        }
    }

    override fun getItemCount(): Int = persons.size



}