package it.paranoidsquirrels.idleguildmaster.storage;

import android.content.Context;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
public class SaveManager {
    private static SaveManager SAVE_TIMER = null;
    public static boolean inhibitSave = false;
    private Timer timer;
    private TimerTask timerTask;

    private SaveManager() {
    }

    public static SaveManager getInstance() {
        if (SAVE_TIMER == null) {
            SAVE_TIMER = new SaveManager();
        }
        return SAVE_TIMER;
    }

    public void startTimer(Context context) {
        stopTimerTask();
        this.timer = new Timer();
        initializeTimerTask(context);
        this.timer.schedule(this.timerTask, 8000L, 3000L);
    }

    public void stopTimerTask() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public void initializeTimerTask(final Context context) {
        this.timerTask = new TimerTask() { // from class: it.paranoidsquirrels.idleguildmaster.storage.SaveManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SaveManager.this.m206xed2b175f(context);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: saveToFile, reason: merged with bridge method [inline-methods] */
    public void m206xed2b175f(Context context) {
        if (!MainActivity.IDLE_THREAD_FINISHED.value || inhibitSave) {
            return;
        }
        FileManager.save(context);
    }

    public void save(final Context context) {
        new Thread(new Runnable() { // from class: it.paranoidsquirrels.idleguildmaster.storage.SaveManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SaveManager.this.m206xed2b175f(context);
            }
        }).start();
    }
}
