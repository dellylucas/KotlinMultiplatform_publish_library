package com.dfl.myapplicationlibrary

class AndroidPlatform : PlatformName {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatformName(): PlatformName = AndroidPlatform()