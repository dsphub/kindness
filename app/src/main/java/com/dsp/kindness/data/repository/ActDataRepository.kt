package com.dsp.kindness.data.repository

import com.dsp.kindness.data.datasource.ActDataStore
import com.dsp.kindness.data.entity.Act
import com.dsp.kindness.domain.entity.ActEntity
import com.dsp.kindness.domain.interactor.Either
import com.dsp.kindness.domain.interactor.Failure
import com.dsp.kindness.domain.interactor.Left
import com.dsp.kindness.domain.interactor.Right
import com.dsp.kindness.domain.repository.ActRepository

class ActDataRepository(private val dataStore: ActDataStore) : ActRepository {
    override fun getRandomAct(): Either<Failure, ActEntity> {
        return when (val result = dataStore.getAllActs()) {
            is Left<Failure> -> result
            is Right<List<Act>> -> Right(getRandomItem(result.b).toEntity())
        }
    }

    private fun <T> getRandomItem(items: List<T>): T = items.random()
}

