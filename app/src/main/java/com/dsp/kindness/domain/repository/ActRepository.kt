package com.dsp.kindness.domain.repository

import com.dsp.kindness.domain.entity.ActEntity
import com.dsp.kindness.domain.interactor.Either
import com.dsp.kindness.domain.interactor.Failure

interface ActRepository {
    fun getRandomAct(): Either<Failure, ActEntity>
}
