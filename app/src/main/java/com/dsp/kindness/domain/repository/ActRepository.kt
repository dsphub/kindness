package com.dsp.kindness.domain.repository

import com.dsp.kindness.domain.entity.Act
import com.dsp.kindness.domain.interactor.Either
import com.dsp.kindness.domain.interactor.Failure

interface ActRepository {
    fun getRandomAct(): Either<Failure, Act>
}
