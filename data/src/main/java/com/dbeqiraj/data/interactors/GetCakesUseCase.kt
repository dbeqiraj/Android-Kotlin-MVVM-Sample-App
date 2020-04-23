package com.dbeqiraj.data.interactors

import com.dbeqiraj.data.repository.CakesRepositoryImpl
import com.dbeqiraj.domain.interactors.UseCase
import com.dibeqiraj.cakeapp.mvp.model.CakesResponse
import javax.inject.Inject

class GetCakesUseCase @Inject constructor(
    private val cakesRepositoryImpl: CakesRepositoryImpl
) : UseCase<Int, CakesResponse>() {

    override suspend fun execute(): CakesResponse {
        return cakesRepositoryImpl.getCakes()
    }

}