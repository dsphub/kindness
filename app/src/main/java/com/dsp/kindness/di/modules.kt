package com.dsp.kindness.di

import com.dsp.kindness.data.datasource.ActDataStore
import com.dsp.kindness.data.datasource.firebase.FirebaseActDataStore
import com.dsp.kindness.data.repository.ActDataRepository
import com.dsp.kindness.domain.interactor.GetRandomAct
import com.dsp.kindness.domain.repository.ActRepository
import org.koin.dsl.module.module

val appModule = module {

}

val actModule = module {
    single<ActDataStore> { FirebaseActDataStore() }
    single<ActRepository> { ActDataRepository(get()) }
    factory { GetRandomAct(get()) }
}