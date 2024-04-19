package com.example.rpn.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

// Repository for managing contact data.
class ContactRepository(application: Application) {
    val searchResults = MutableLiveData<List<Contact>>()  // Stores search results.
    private var contactDao: ContactDao?  // Data Access Object for contacts.
    private val coroutineScope = CoroutineScope(Dispatchers.Main)  // Manages coroutines.

    var allContacts: LiveData<List<Contact>>?  // Stores all contacts.

    // Initialize repository.
    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    // Insert a new contact.
    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    // Asynchronously insert a contact.
    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    // Delete a contact.
    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    // Asynchronously delete a contact.
    private suspend fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    // Find a contact by name.
    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    // Asynchronously find a contact.
    private fun asyncFind(name: String) =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

    // Sort contacts.
    fun sort(ascending: Boolean) {
        coroutineScope.launch(Dispatchers.Main) {
            if (ascending) {
                searchResults.value = asyncAscSort().await()
            } else {
                searchResults.value = asyncDscSort().await()
            }
        }
    }

    // Asynchronously sort contacts in ascending order.
    private fun asyncAscSort() =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.getAllContactsAsc()
        }

    // Asynchronously sort contacts in descending order.
    private fun asyncDscSort() =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.getAllContactsDsc()
        }
}
