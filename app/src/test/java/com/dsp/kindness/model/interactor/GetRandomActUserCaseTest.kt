package com.dsp.kindness.model.interactor

import com.dsp.kindness.UnitTest
import com.dsp.kindness.domain.entity.Act
import com.dsp.kindness.domain.interactor.GetRandomAct
import com.dsp.kindness.domain.interactor.Right
import com.dsp.kindness.domain.interactor.UseCase
import com.dsp.kindness.domain.repository.ActRepository
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetRandomActUserCaseTest : UnitTest() {
    private lateinit var useCase: GetRandomAct

    @Mock
    private lateinit var repository: ActRepository

    @Before
    fun setUp() {
        useCase = GetRandomAct(repository)
        given { repository.getRandomAct() }.willReturn(Right(Act(1, "test")))
    }

    @Test
    fun `should get data from repository`() {
        runBlocking { useCase.run(UseCase.None()) }

        verify(repository).getRandomAct()
        verifyNoMoreInteractions(repository)
    }
}
