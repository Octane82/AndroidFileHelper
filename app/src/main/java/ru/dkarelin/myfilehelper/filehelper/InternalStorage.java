package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Внутреннее хранилище
 */
public class InternalStorage implements Storage{

    private Context context;

    public InternalStorage(Context context) {
        this.context = context;
    }



    // ********** CREATE DIRECTORY *************************************************

    /**
     * Создание дирректории
     *
     * - "MyDir"
     * - "MyDir/MySubDir/MySubDir"
     * - "MyDir/MySubDir/MySubDir", true - override if exist
     *
     * @param path
     * @return
     */
    public boolean createDirrectory(String path) {


        return true;        // dirrectory CREATED !!!!
    }



    // ********** CREATE FILES *****************************************************

    /**
     * Создание файла
     *
     *  - dirname может быть вида myDir/MySubDir/MySubDir
     *  - filename with extensions (file.txt)
     *
     * @return
     */
    public boolean createFile(String dirName, String filename, String content) {

        return true;    // file CREATED
    }


    /**
     * Создание файла
     *
     *  - dirname может быть вида myDir/MySubDir/MySubDir
     *  - filename with extensions (file.txt)
     *
     * @return
     */
    public boolean createFile(String dirName, String filename, byte[] content) {

        return true;    // file CREATED
    }


    /**
     * Создание файла
     *
     *  - dirname может быть вида myDir/MySubDir/MySubDir
     *  - filename with extensions (file.txt)
     *
     * @return
     */
    public boolean createFile(String dirName, String filename, Bitmap content) {

        return true;    // file CREATED
    }


    /**
     * Создание файла
     *
     *  - dirname может быть вида myDir/MySubDir/MySubDir
     *  - filename with extensions (file.txt)
     *
     * @return
     */
    public boolean createFile(String dirName, String filename, Storable content) {

        return true;    // file CREATED
    }


    // *****************





}
