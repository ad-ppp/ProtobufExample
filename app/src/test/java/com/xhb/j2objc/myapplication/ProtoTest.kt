package com.xhb.j2objc.myapplication

import com.xhb.j2objc.myapplication.module.PersonOuterClass
import org.junit.Before
import org.junit.Test

class ProtoTest {
    private var person: PersonOuterClass.Person? = null

    @Before
    fun simple_test() {
        val phoneNumber = PersonOuterClass.Person.PhoneNumber.newBuilder()
            .setNumber("18516606250")
            .setType(PersonOuterClass.Person.PhoneType.WORK)
            .build()
        person = PersonOuterClass.Person.newBuilder()
            .addPhone(phoneNumber)
            .setName("jacky")
            .setEmail("847564732@qq.com")
            .setId(1)
            .build()

        System.out.println(person)

        person = person!!.toBuilder()
            .clearEmail()
            .build()

        System.out.println(person)
    }

    @Test
    fun serialize_test() {
        val p = person
        if (p != null) {
            val toByteArray = p.toByteArray()
            val parseFrom = PersonOuterClass.Person.parseFrom(toByteArray)
            System.out.println(String.format("deserialize person: %s", parseFrom))
        }
    }
}