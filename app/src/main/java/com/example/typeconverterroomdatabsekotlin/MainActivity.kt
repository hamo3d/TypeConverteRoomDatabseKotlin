package com.example.typeconverterroomdatabsekotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.typeconverterroomdatabsekotlin.data.MyViewModel
import com.example.typeconverterroomdatabsekotlin.data.Person
import com.example.typeconverterroomdatabsekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private var persons: ArrayList<Person> = ArrayList()
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        setUpRec()
        getDataFromDataBase()

        binding.floatingActionButton.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext, AddImage::class.java
                )
            )
        }
    }


    private fun setUpRec() {
        adapter = MyAdapter(persons)
        binding.rc.adapter = adapter
        binding.rc.layoutManager = LinearLayoutManager(this)
        binding.rc.setHasFixedSize(true)
    }



    private fun getDataFromDataBase() {
        viewModel.readPerson.observe(this) {
            persons.clear()
            persons.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}