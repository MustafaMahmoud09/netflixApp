package com.lomu.mapper.Base

abstract class MappingObj<Input,OutPut> {

    abstract fun convertObj(data : Input): List<OutPut>

}