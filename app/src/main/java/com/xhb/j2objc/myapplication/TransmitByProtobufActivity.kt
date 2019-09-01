package com.xhb.j2objc.myapplication

import com.xhb.j2objc.myapplication.module.PersonOuterClass

class TransmitByProtobufActivity : BaseActivity<PersonOuterClass.Person>() {
    override fun getEntity(): PersonOuterClass.Person {
        return PersonOuterClass.Person.parseFrom(intent.getByteArrayExtra("person"))
    }

}
