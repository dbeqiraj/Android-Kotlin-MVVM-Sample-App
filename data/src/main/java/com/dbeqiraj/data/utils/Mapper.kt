package com.dbeqiraj.data.utils

interface Mapper<in T, R> {

    fun map(t: T) : R

}