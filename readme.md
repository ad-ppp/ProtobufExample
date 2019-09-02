# Demo for using of test protobuf-lite
1. Look at the testUnit of ProtoTest.kt
2. 序列化对比 Json vs Protobuffer. （实验结果：Protobuf 大概快3-4倍）

# Log
### TestUnit Log

```
# com.xhb.j2objc.myapplication.module.PersonOuterClass$Person@1c3b2e8f
email: "847564732@qq.com"
id: 1
name: "jacky"
phone {
  number: "18516606250"
  type: WORK
}
# com.xhb.j2objc.myapplication.module.PersonOuterClass$Person@faedcac2
id: 1
name: "jacky"
phone {
  number: "18516606250"
  type: WORK
}
deserialize person
: # com.xhb.j2objc.myapplication.module.PersonOuterClass$Person@faedcac2
id: 1
name: "jacky"
phone {
  number: "18516606250"
  type: WORK
}

Process finished with exit code 0
```

### Mock Android Intent 传输，序列化日志对比
```
2019-09-02 00:19:37.528 6408-6408/com.xhb.j2objc.myapplication D/TransmitByProtobufActivity: get entity 1 times cost 868266 ns 
    # com.xhb.j2objc.myapplication.module.PersonOuterClass$Person@21d5cccc
    email: "847564732@qq.com"
    id: 1
    name: "jacky"
    phone {
      number: "18516606250"
      type: WORK
    }
    phone {
      number: "18516606251"
      type: HOME
    }
2019-09-02 00:19:41.552 6408-6408/com.xhb.j2objc.myapplication D/TransmitByJsonActivity: get entity 1 times cost 7049220 ns 
    JsonPerson{id=1, name='jacky', email='847564732@qq.com', phoneNumbers=[PhoneNumber{number='18516606250', phoneType=WORK}, PhoneNumber{number='18516606251', phoneType=HOME}]}
2019-09-02 00:19:43.533 6408-6408/com.xhb.j2objc.myapplication D/TransmitBySerializeActivity: get entity 1 times cost 1925664 ns 
    JsonPerson{id=1, name='jacky', email='847564732@qq.com', phoneNumbers=[PhoneNumber{number='18516606250', phoneType=WORK}, PhoneNumber{number='18516606251', phoneType=HOME}]}
2019-09-02 00:19:45.361 6408-6408/com.xhb.j2objc.myapplication D/TransmitByParcelableActivity: get entity 1 times cost 1270552 ns 
    ParcelablePerson{id=1, name='jacky', email='847564732@qq.com', phoneNumbers=[PhoneNumber{number='18516606250', phoneType=WORK}, PhoneNumber{number='18516606251', phoneType=HOME}]}
```

效率对比： Protobuf > Parcelabel > Serializable > Json
