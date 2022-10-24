package com.franciscojavier.ej1fragment.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PersonsProvider {
    suspend fun getPersons(tipo: String): List<Person> = withContext(Dispatchers.IO) {
        Thread.sleep(2000)
        listOf(
            Person("Juan", "123456789", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Fran", "532523590", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Ismael", "321425324", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Vali", "756744333", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Lechuga", "5235255", "email@gmail.com", "https://loremflickr.com/240/320/person"),
            Person("Alberto", "643563634", "email@gmail.com", "https://loremflickr.com/240/320/person"),
        )
    }
}