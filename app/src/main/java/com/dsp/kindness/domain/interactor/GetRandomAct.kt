package com.dsp.kindness.domain.interactor

import com.dsp.kindness.domain.entity.ActEntity
import com.dsp.kindness.domain.repository.ActRepository

class GetRandomAct(private val repository: ActRepository) : UseCase<ActEntity, UseCase.None>() {
    override suspend fun run(params: None) = repository.getRandomAct()
}
