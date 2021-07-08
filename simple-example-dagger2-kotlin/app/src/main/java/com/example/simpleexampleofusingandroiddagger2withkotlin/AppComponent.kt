package com.example.simpleexampleofusingandroiddagger2withkotlin

import dagger.Component

@Component(
    modules = [
        ActivitiesModule::class
    ]
)


interface AppComponent {

    fun inject(myApplication: MyApplication)
}