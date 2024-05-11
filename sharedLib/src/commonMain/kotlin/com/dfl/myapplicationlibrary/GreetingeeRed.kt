package com.dfl.myapplicationlibrary

class GreetingeeRed {
    private val platformee: PlatformName = getPlatformName()

    fun getRed(): String {
        return "esto es la libreria, ${platformee.name}!"
    }
}
