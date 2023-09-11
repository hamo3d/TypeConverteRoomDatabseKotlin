package com.example.typeconverterroomdatabsekotlin.data

import androidx.lifecycle.LiveData

class MyRepository(private val myDao: MyDao) {

    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    suspend fun insertPerson(person: Person){
        myDao.insertPerson(person)
    }

}