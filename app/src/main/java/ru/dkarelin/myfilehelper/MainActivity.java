package ru.dkarelin.myfilehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.dkarelin.myfilehelper.filehelper.SimpleStorage;
import ru.dkarelin.myfilehelper.filehelper.Storage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Storage storage = SimpleStorage.getInternalStorage(this);

    }
}
