package com.dfl.myapplicationlibrary

import platform.UIKit.UIDevice

class IOSPlatform: PlatformName {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatformName(): PlatformName = IOSPlatform()