package com.lomu.mapper.Base


abstract class MappingList<INPUT,OUTPUT> {

    //to convert list
    abstract fun convertList(data: List<INPUT?>?): List<OUTPUT>

    //to convert object
    protected abstract fun convertObject(data : INPUT) : OUTPUT

}