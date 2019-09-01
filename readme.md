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
2019-09-01 20:54:01.915 2988-2988/com.xhb.j2objc.myapplication D/TransmitByProtobufActivity: get entity cost 880838 ns 
    # com.xhb.j2objc.myapplication.module.PersonOuterClass$Person@1c3b2e8f
    email: "847564732@qq.com"
    id: 1
    name: "jacky"
    phone {
      number: "18516606250"
      type: WORK
    }
2019-09-01 20:54:05.902 2988-2988/com.xhb.j2objc.myapplication D/TransmitByJsonActivity: get entity cost 2692801 ns 
    JsonPerson{id=1, name='jacky', email='847564732@qq.com', phoneNumbers=[PhoneNumber{number='18516606250', phoneType=WORK}]}
```
