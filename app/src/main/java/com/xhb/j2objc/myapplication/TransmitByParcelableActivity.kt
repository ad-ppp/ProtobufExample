package com.xhb.j2objc.myapplication

import com.xhb.j2objc.myapplication.module.ParcelablePerson

class TransmitByParcelableActivity : BaseActivity<ParcelablePerson>() {
    override fun getEntity(): ParcelablePerson {
        return intent.getParcelableExtra("person")
    }
}
