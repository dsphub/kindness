package com.dsp.kindness.data.datasource

import com.dsp.kindness.data.entity.Act
import com.dsp.kindness.domain.interactor.Either
import com.dsp.kindness.domain.interactor.Failure

interface ActDataStore {
    fun getAllActs(): Either<Failure, List<Act>>
}
