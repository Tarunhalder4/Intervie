package com.example.interview

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StaticModule::class,NonStaticModule::class])
interface Component {


    //fun getRepository():Repository

    fun inject(mainActivity: MainActivity)
    fun inject(otherActivity: OtherActivity)


}