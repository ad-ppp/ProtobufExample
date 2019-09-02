package com.xhb.j2objc.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.xhb.j2objc.myapplication.module.JsonPerson
import com.xhb.j2objc.myapplication.module.ParcelablePerson
import com.xhb.j2objc.myapplication.module.PersonOuterClass
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneNumber = PersonOuterClass.Person.PhoneNumber.newBuilder()
            .setNumber("18516606250")
            .setType(PersonOuterClass.Person.PhoneType.WORK)
            .build()

        val phoneNumber2 = PersonOuterClass.Person.PhoneNumber.newBuilder()
            .setNumber("18516606251")
            .setType(PersonOuterClass.Person.PhoneType.HOME)
            .build()

        val person = PersonOuterClass.Person.newBuilder()
            .addPhone(phoneNumber)
            .addPhone(phoneNumber2)
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

        btnSerializeIntent.setOnClickListener {
            val p = fakeJsonPerson()
            startActivity(Intent(this, TransmitBySerializeActivity::class.java).apply {
                putExtra("person", p)
            })
        }

        btnParcelableIntent.setOnClickListener {
            val p = fakeJParcelablePerson()
            startActivity(Intent(this, TransmitByParcelableActivity::class.java).apply {
                putExtra("person", p)
            })
        }
    }

    private fun fakeJsonPerson(): JsonPerson {
        val pn = JsonPerson.PhoneNumber("18516606250").apply {
            phoneType = JsonPerson.PhoneType.WORK
        }
        val pn2 = JsonPerson.PhoneNumber("18516606251").apply {
            phoneType = JsonPerson.PhoneType.HOME
        }

        return JsonPerson().apply {
            id = 1
            name = "jacky"
            email = "847564732@qq.com"
            phoneNumbers = Arrays.asList(pn, pn2)
        }
    }

    private fun fakeJParcelablePerson(): ParcelablePerson {
        val pn = JsonPerson.PhoneNumber("18516606250").apply {
            phoneType = JsonPerson.PhoneType.WORK
        }
        val pn2 = JsonPerson.PhoneNumber("18516606251").apply {
            phoneType = JsonPerson.PhoneType.HOME
        }

        return ParcelablePerson().apply {
            id = 1
            name = "jacky"
            email = "847564732@qq.com"
            phoneNumbers = Arrays.asList(pn, pn2)
        }
    }
}
