package com.example.contactbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactbook.data.ContactEntity
import com.example.contactbook.data.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContactViewModel(
    private val repository: ContactRepository
) : ViewModel() {
    val allContacts: Flow<List<ContactEntity>> =
        repository.allContacts

    fun addContact(name: String, phone: String, email: String) {
        if (name.isBlank() || phone.isBlank()) return

        val contact = ContactEntity(
            name = name.trim(),
            phone = phone.trim(),
            email = email.trim()
        )

        viewModelScope.launch {
            repository.insertContact(contact)
        }
    }

    fun deleteContact(contact: ContactEntity) {
        viewModelScope.launch {
            repository.deleteContact(contact)
        }
    }
}
