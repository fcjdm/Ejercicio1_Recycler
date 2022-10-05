package com.franciscojavier.ejrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.franciscojavier.ejrecycler.databinding.ViewPersonBinding


class PersonAdapter(val list:List<Person>, val listener: (Person) -> Unit): RecyclerView.Adapter<PersonAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ViewPersonBinding.bind(view)
        fun bind(person: Person){
            binding.textName.text = person.name
            binding.textPhone.text = person.phone
            binding.textEmail.text = person.email
            Glide.with(binding.photo)
                .load(person.photo)
                .into(binding.photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_person, parent, false)
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