package com.example.listdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val persons = mutableListOf<Person>()
    lateinit var personRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persons.add(Person("Joe","Switch",21,R.drawable.p1))
        persons.add(Person("Jack","Nancy",25,R.drawable.p2))
        persons.add(Person("Nikita","Olga",22,R.drawable.p3))
        persons.add(Person("Trump","Dummy",31,R.drawable.p4))
        persons.add(Person("Tiny","Dimmy",35,R.drawable.p5))
        persons.add(Person("Jacky","Sunny",15,R.drawable.p6))

        personRecyclerView = findViewById(R.id.recyclerView)
        personRecyclerView.adapter = PersonAdapter(persons)
        personRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}