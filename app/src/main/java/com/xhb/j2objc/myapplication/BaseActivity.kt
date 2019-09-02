package com.xhb.j2objc.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

abstract class BaseActivity<T> : AppCompatActivity() {
    private lateinit var TAG: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = javaClass.simpleName

        val start = System.nanoTime()
        var person: T? = null
        for (i in 0..100) {
            person = getEntity()
        }

        val end = System.nanoTime() - start
        Log.d(TAG, "get entity 100 times cost $end ns \n$person")
    }

    abstract fun getEntity(): T
}
