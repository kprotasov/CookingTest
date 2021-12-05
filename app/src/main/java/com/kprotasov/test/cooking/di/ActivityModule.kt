package com.kprotasov.test.cooking.di

import com.kprotasov.test.cooking.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        FragmentModule::class
    ]
)
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity
}