package com.xhb.j2objc.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.xhb.j2objc.myapplication.module.JsonPerson
import com.xhb.j2objc.myapplication.module.PersonOuterClass
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneNumber = PersonOuterClass.Person.PhoneNumber.newBuilder()
            .setNumber("18516606250")
            .setType(PersonOuterClass.Person.PhoneType.WORK)
            .build()

        val person = PersonOuterClass.Person.newBuilder()
            .addPhone(phoneNumber)
            .setName("jacky")
            .setEmail("847564732@qq.com")
            .setId(1)
            .build()

        btnProtoIntent.setOnClickListener {
            startActivity(Intent(this, TransmitByProtobufActivity::class.java).apply {
                putExtra("person", person.toByteArray())
            })
        }

        btnJsonIntent.setOnClickListener {
            startActivity(Intent(this, TransmitByJsonActivity::class.java).apply {
                putExtra("person", Gson().toJson(fakeJsonPerson()).toString())
            })
        }
    }

    private fun fakeJsonPerson(): JsonPerson {
        val pn = JsonPerson.PhoneNumber("18516606250").apply {
            phoneType = JsonPerson.PhoneType.WORK
        }


        return JsonPerson().apply {
            id = 1
            name = "jacky"
            email = "847564732@qq.com"
            phoneNumbers = Collections.singletonList(
                pn
            )
        }
    }
}
