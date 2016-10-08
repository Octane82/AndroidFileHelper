package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;

/**
 * Внутреннее хранилище
 */
public class InternalStorage extends BaseFileOperations
        implements Storage{

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




    // ***************** READ FILE *****************************************


    /**
     *
     *
     * @param dirName
     * @param fileName
     * @return
     */
    public byte[] readFile(String dirName, String fileName) {


        return null;   // zaglusgka !!!
    }


    /**
     *
     *
     * @param dirName
     * @param fileName
     * @return
     */
    public String readTextFile(String dirName, String fileName) {


        return null;   // zaglusgka !!!
    }



    /**
     *
     *
     * @param dirName
     * @param fileName
     * @return
     */
    public Bitmap readBitmapFile(String dirName, String fileName) {


        return null;   // zaglusgka !!!
    }


    // ************** APPAND TO FILE **************************

    /**
     *
     *
     * @param dirName
     * @param fileName
     * @param appendString
     * @return
     */
    public boolean appendFile(String dirName, String fileName, String appendString) {


        return true;  // Content appended !!!!
    }


    /**
     *
     *
     * @param dirName
     * @param fileName
     * @param appendBytes
     * @return
     */
    public boolean appendFile(String dirName, String fileName, byte[] appendBytes) {


        return true;  // Content appended !!!!
    }




    // *********** COPY FILES ***********************

    /**
     *
     *
     * @param inputFile
     * @param dirName
     * @param newFile
     */
    public void copyFiles(File inputFile, String dirName, String newFile) {

    }


    // *************** MOVE FILES **************************

    /**
     *
     *
     * @param inputFile
     * @param dirName
     * @param newFileName
     */
    public void moveFiles(File inputFile, String dirName, String newFileName) {

    }



    // ************ DELETE DIRRECTORY ***************************

    /**
     *
     *
     * @param dirName
     * @return
     */
    public boolean deleteDirectory(String dirName) {


        return true;  // Directory deleted
    }


    // **************** DELETE FILES *********************************


    public boolean deleteFile(String dirname, String filename) {

        return true;   // file deleted
    }





}
