package com.wanlok.onesignal

import com.onesignal.OSNotificationOpenResult
import com.onesignal.OneSignal.NotificationOpenedHandler

class OneSignalNotificationOpenedHandler(private val mainActivity: MainActivity): NotificationOpenedHandler {

    override fun notificationOpened(result: OSNotificationOpenResult) {
        val oneSignalStorage = OneSignalStorage.instance()
        oneSignalStorage.title =  result.notification.payload?.title
        oneSignalStorage.body = result.notification.payload?.body
        oneSignalStorage.params = result.notification.payload?.additionalData
        mainActivity.pushNotificationReceived()
    }
}