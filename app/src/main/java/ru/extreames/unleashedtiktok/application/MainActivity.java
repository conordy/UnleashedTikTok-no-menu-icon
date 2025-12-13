package ru.extreames.unleashedtiktok.application;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        killProcess("com.zhiliaoapp.musically");
        killProcess("com.ss.android.ugc.trill");
    }

    public static void killProcess(String name) {
        // Only root
        try {
            Runtime.getRuntime().exec(new String[] {
                    "su",
                    "-c",
                    "killall " + name
            });
        }
        catch (Exception ignored) { }
    }
}