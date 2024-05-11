package com.dfl.myapplicationlibrary

interface PlatformName {
    val name: String
}

expect fun getPlatformName(): PlatformName