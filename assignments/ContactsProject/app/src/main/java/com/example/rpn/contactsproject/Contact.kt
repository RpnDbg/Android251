package com.example.rpn.contactsproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Represents a contact in the app.
@Entity(tableName = "contacts")  // Defines a database table named "contacts".
class Contact {

    // Unique ID for each contact, automatically generated.
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="contactId")  // Column name in the database: "contactId".
    var id: Int = 0  // Stores the ID.

    @ColumnInfo(name="contactName")  // Column name in the database: "contactName".
    var contactName: String? = null  // Stores the contact's name.

    @ColumnInfo(name = "contactPhone")  // Column name in the database: "contactPhone".
    var contactPhone: String = ""  // Stores the contact's phone number.

    // Default constructor.
    constructor()

    // Constructor initializes contact with name and phone number.
    constructor(contactname: String, phone: String) {
        this.contactName = contactname
        this.contactPhone = phone
    }
}
