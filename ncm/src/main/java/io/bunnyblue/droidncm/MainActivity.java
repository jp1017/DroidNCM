package io.bunnyblue.droidncm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import io.bunnyblue.droidncm.dump.NcmDumper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File("/sdcard/郑智化 - 大国民.ncm");
        System.out.println(file.getAbsolutePath() + " " + file.exists());
        String newPath = NcmDumper.ncpDump(file.getAbsolutePath());
        System.err.println(newPath);
    }
}
