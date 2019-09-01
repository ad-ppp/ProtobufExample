package com.xhb.j2objc.myapplication

import com.google.gson.Gson
import com.xhb.j2objc.myapplication.module.JsonPerson

class TransmitByJsonActivity : BaseActivity<JsonPerson>() {
    override fun getEntity(): JsonPerson {
        return Gson()
            .fromJson(
                intent.getStringExtra("person"),
                JsonPerson::class.java
            )
    }

//    private class LocalTypeAdapter :TypeAdapter<List<PersonOuterClass.Person.PhoneNumber>>(){
//        var mGson:Gson = Gson().newBuilder().create()
//
//        override fun write(out: JsonWriter, value: List<PersonOuterClass.Person.PhoneNumber>?) {
//
//        }
//
//        override fun read(reader: JsonReader): List<PersonOuterClass.Person.PhoneNumber> {
//            while (reader.hasNext()){
//                val nextName = reader.nextName()
//                if (nextName == "phone_") {
//                    reader.beginObject()
//                    mGson.fromJson(reader,Array<PersonOuterClass.Person.PhoneNumber>::class.java)
//                    reader.endObject()
//                }
//            }
//        }
//
//    }

}
