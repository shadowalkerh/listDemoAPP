package com.example.listdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val persons = mutableListOf<Person>()
    lateinit var personRecyclerView: RecyclerView

    val REQUEST_INPUT = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persons.add(Person("Joe","Switch",21,R.drawable.p1,null))
        persons.add(Person("Jack","Nancy",25,R.drawable.p2,null))
        persons.add(Person("Nikita","Olga",22,R.drawable.p3,null))
        persons.add(Person("Trump","Dummy",31,R.drawable.p4,null))
        persons.add(Person("Tiny","Dimmy",35,R.drawable.p5,null))
        persons.add(Person("Jacky","Sunny",15,R.drawable.p6,null))

        personRecyclerView = findViewById(R.id.recyclerView)
        personRecyclerView.adapter = PersonAdapter(persons,this)
        personRecyclerView.layoutManager = LinearLayoutManager(this)

        val btnAdd = findViewById<Button>(R.id.button1)
        btnAdd.setOnClickListener{
            val inIntent = Intent (this, InputActivity::class.java)
            startActivityForResult(inIntent,REQUEST_INPUT)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_INPUT && resultCode == RESULT_OK){
            val newPerson = data!!.getParcelableExtra<Person>("newperson")
            persons.add(newPerson!!)
            personRecyclerView.adapter?.notifyItemInserted(persons.lastIndex)
        }
    }
    fun deletePerson(position: Int){
        persons.removeAt(position)
        personRecyclerView.adapter?.notifyItemRemoved(position)
    }
}