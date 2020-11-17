package com.wanlok.onesignal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onesignal.OneSignal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.startInit(this)
            .setNotificationOpenedHandler(OneSignalNotificationOpenedHandler(this))
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()
    }

    override fun onResume() {
        super.onResume()
        pushNotificationReceived()
    }

    fun pushNotificationReceived() {
        val oneSignalStorage = OneSignalStorage.instance()
        val title = oneSignalStorage.title
        val body = oneSignalStorage.body
        val params = oneSignalStorage.params
        if (title != null && body != null && params != null) {
            tv_text.text = "${title}\n\n${body}\n\n${params}"
        }
    }
}