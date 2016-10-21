package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;

/**
 * Выбор хранилища
 */
public class FileStorage {

    // TODO: TEMP !!!!
    public static InternalStorage getInternalStorage(Context context) {
        return new InternalStorage(context);
    }

    /*public static Storage getInternalStorage(Context context) {
        return new InternalStorage(context);
    }*/


    public static Storage getExternalStorage(Context context) {
        return new ExternalStorage(context);
    }



}
