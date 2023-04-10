package com.kerubyte.engage.common.util

interface RootUseCase<in I, O : Any> {
    suspend operator fun invoke(input: I? = null): Response<O>
}