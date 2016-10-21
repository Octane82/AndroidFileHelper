package ru.dkarelin.myfilehelper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import ru.dkarelin.myfilehelper.filehelper.FileStorage;
import ru.dkarelin.myfilehelper.filehelper.FileType;
import ru.dkarelin.myfilehelper.filehelper.InternalStorage;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();


    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);

        /*Storage storage = FileStorage.getInternalStorage(this);
        storage.createDirrectory("/testdirrr");*/

    }


    /**
     * Pushed Action button
     * @param view
     */
    public void btnAction(View view) {

        InternalStorage storage = FileStorage.getInternalStorage(this);
        // storage.createDirrectory("/testdir");

        byte[] btarr = new byte[]{1, 2, 3, 4, 5, 7, 8, 9};      // readbytes/bytes.raw

        Bitmap bitmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        /*if (storage.createFile("readbytes/bytes.raw", btarr)) {
            Log.d(TAG, "FILE CREATED");
            showToast("File CREATED !!!");
        } else {
            showToast("File NOT CREATED !!!");
        }*/


        //String text = storage.readTextFile("/lipsum.txt");
        //Log.d(TAG, "TEXT: \\" + text);

       /* byte[] bytes = storage.readFile("readbytes/bytes.raw");
        Log.d(TAG, "RAW File lenght: " + bytes.length);
        for (byte b : bytes) {
            Log.d(TAG, "Byte-> " + b + "\n");
        }*/

        Bitmap bitmap = storage.readBitmapFile("droid.jpg");
        imageView.setImageBitmap(bitmap);


    }


    /**
     * Show toast message
     * @param text
     */
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }


}
