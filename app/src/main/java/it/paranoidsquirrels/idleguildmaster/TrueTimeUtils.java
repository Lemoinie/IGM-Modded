package it.paranoidsquirrels.idleguildmaster;

import com.instacart.library.truetime.TrueTime;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TrueTimeUtils {
    public static void init() {
        new Thread(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.TrueTimeUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    TrueTime.build().withNtpHost("time.google.com").withLoggingEnabled(false).withConnectionTimeout(31428).initialize();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static long millis() {
        try {
            return TrueTime.now().getTime();
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                init();
            }
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }
}
