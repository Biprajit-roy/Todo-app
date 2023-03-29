package com.example.practice2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Complete the project",false),
            Todo("Study DBMS for the upcoming Test",false),
            Todo("Prepare for TOC quiz",false),
            Todo("Complete the notes of OS",false)

        )

        val adapter = TodoAdapter(todoList)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val tile = etTodo.text.toString()
            val todo = Todo(tile,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }

    }
}