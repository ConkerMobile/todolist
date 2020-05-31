package com.conkermobile.todolist6000

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class ToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        saveButton.setOnClickListener{
            val title: String = if (importantBox.isChecked) {
                "❗  " + titleEditText.text.toString()
            } else{
                titleEditText.text.toString()
            }

            val prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            val todos = prefs.getStringSet(getString(R.string.TODO_STRINGS),setOf())!!.toMutableSet()
            todos.add(title)

            prefs.edit().putStringSet("todostrings",todos).apply()

            finish()
        }
    }
}
