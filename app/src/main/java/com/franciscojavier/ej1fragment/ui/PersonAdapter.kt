package com.franciscojavier.ej1fragment.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franciscojavier.ej1fragment.model.Person
import com.franciscojavier.ej1fragment.inflate
import com.franciscojavier.ej1fragment.loadUrl
import com.franciscojavier.ej1fragment.R
import com.franciscojavier.ej1fragment.databinding.ViewPersonBinding


class PersonAdapter(val list:List<Person>, val listener: (Person) -> Unit): RecyclerView.Adapter<PersonAdapter.ViewHolder>(){

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
        holder.bind(list[position])
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

}