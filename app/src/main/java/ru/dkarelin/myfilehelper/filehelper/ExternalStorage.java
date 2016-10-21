package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;

/**
 * Внешнее хранилище
 */
public class ExternalStorage extends BaseFileOperations
        implements Storage {

    private Context context;

    public ExternalStorage(Context context) {
        this.context = context;
    }


    @Override
    public boolean createDirrectory(String path) {
        return false;
    }
}
