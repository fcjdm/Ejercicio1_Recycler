package com.franciscojavier.ejrecycler.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name: String, val phone : String, val email: String, val photo: String): Parcelable {
}