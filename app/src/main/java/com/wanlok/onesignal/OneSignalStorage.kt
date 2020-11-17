package com.wanlok.onesignal

import org.json.JSONObject

class OneSignalStorage {

    var title: String? = null
    var body: String? = null
    var params: JSONObject? = null

    companion object {
        @Volatile
        private var instance: OneSignalStorage? = null

        fun instance(): OneSignalStorage {
            val instance = instance
            return if (instance == null) {
                val oneSignalStorage = OneSignalStorage()
                this.instance = oneSignalStorage
                oneSignalStorage
            } else {
                instance
            }
        }
    }
}