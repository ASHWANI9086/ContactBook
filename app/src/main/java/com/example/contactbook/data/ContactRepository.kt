package com.example.contactbook.data

import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {
    val allContacts: Flow<List<ContactEntity>> =
        contactDao.getAllContacts()

    suspend fun insertContact(contact: ContactEntity) {
        contactDao.insertContact(contact)
    }

    suspend fun deleteContact(contact: ContactEntity) {
        contactDao.deleteContact(contact)
    }

    suspend fun getContactById(id: Int): ContactEntity? {
        return contactDao.getContactById(id)
    }
}
