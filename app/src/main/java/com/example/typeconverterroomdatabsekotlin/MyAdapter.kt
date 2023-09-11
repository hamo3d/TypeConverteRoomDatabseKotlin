package com.example.typeconverterroomdatabsekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.typeconverterroomdatabsekotlin.data.Person
import com.example.typeconverterroomdatabsekotlin.databinding.CustomCardItemBinding

class MyAdapter(private val persons: ArrayList<Person>) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {
    class MyHolder(private var binding: CustomCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(person: Person) {
            binding.firstNameTxt.text = person.firstName
            binding.lastNameTxt.text = person.lastName
            binding.imageView.load(person.profilePhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding =
            CustomCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(persons[position])
    }
}