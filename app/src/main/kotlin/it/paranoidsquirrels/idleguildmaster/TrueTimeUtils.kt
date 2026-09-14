    package it.paranoidsquirrels.idleguildmaster

    import com.instacart.library.truetime.TrueTime
    import java.io.IOException

    object TrueTimeUtils {
        @JvmStatic
        fun init() {
            Thread {
                try {
                    TrueTime.build()
                        .withNtpHost("time.google.com")
                        .withLoggingEnabled(false)
                        .withConnectionTimeout(31428)
                        .initialize()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }.start()
        }

        @JvmStatic
        fun millis(): Long {
            return try {
                TrueTime.now().time
            } catch (e: Exception) {
                if (e is IllegalStateException) {
                    init()
                }
                e.printStackTrace()
                System.currentTimeMillis()
            }
        }
    }
