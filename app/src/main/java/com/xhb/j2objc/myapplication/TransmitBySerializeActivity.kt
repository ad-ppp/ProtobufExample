package com.xhb.j2objc.myapplication

import com.xhb.j2objc.myapplication.module.JsonPerson

class TransmitBySerializeActivity : BaseActivity<JsonPerson>() {
    override fun getEntity(): JsonPerson {
        return intent.getSerializableExtra("person") as JsonPerson
    }
}
