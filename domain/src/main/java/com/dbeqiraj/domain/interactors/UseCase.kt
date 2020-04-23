package com.dbeqiraj.domain.interactors

abstract class UseCase<I, O> {

    abstract suspend fun execute(): O

}