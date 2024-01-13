package com.example.interview

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class StaticModule {

    @VivoAnotation
    @Binds
    @Singleton
    abstract fun getRedmi(vivo: Vivo):Mobile

    @RedmiAnotation
    @Binds
    abstract fun getVivo(redmi: Redmi):Mobile

}

@Module
class NonStaticModule(){

    @MotoAnotation
    @Provides
    fun getMotorola():Mobile{
        return Motorola()
    }

}