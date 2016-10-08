package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;

/**
 * Выбор хранилища
 */
public class SimpleStorage {


    public static Storage getInternalStorage(Context context) {
        return new InternalStorage(context);
    }


    public static Storage getExternalStorage(Context context) {
        return new ExternalStorage(context);
    }



}
