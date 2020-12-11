package com.teguhrmdhn.simata.maincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.*
import com.teguhrmdhn.simata.R

class ShowMaincoreActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    lateinit var list : MutableList<Maincore>
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_maincore)

        ref = FirebaseDatabase.getInstance().getReference("MAINCORE")
        list = mutableListOf()
        listView = findViewById(R.id.listView)

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()) {

                    list.clear()
                    for (h in p0.children){
                        val maincore = h.getValue(Maincore::class.java)
                        list.add(maincore!!)
                    }
                    val adapter = Adapter(this@ShowMaincoreActivity, R.layout.show_maincore,list)
                    listView.adapter = adapter
                }
            }
        })
    }
}