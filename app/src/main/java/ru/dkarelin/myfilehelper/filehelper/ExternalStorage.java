package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;

/**
 * Внешнее хранилище
 */
public class ExternalStorage implements Storage {

    private Context context;

    public ExternalStorage(Context context) {
        this.context = context;
    }


}
