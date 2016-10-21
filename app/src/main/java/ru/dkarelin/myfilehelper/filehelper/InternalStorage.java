package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Внутреннее хранилище
 */
public class InternalStorage extends BaseFileOperations
        implements Storage {

    private final String TAG = this.getClass().getSimpleName();

    private Context context;

    public InternalStorage(Context context) {
        this.context = context;
    }





    // ********** CREATE DIRECTORY *************************************************

    /**
     * Создание дирректории
     * Если существует имя файла в пути с расширением (file.txt),
     * то возвращается false
     *
     * @param path
     *      - "MyDir"
     *      - "MyDir/MySubDir/MySubDir"
     * @return - результат создания дирректории
     *
     * TODO: "MyDir/MySubDir/MySubDir", true - override if exist (OVERRIDE IF EXIST)
     */
    @Override
    public boolean createDirrectory(String path) {
        return createDirrectory(context.getFilesDir(), path);
    }



    // ********** CREATE FILES *****************************************************


    /**
     * Создание файла с текстовым содержимым
     *
     * @param fullpath
     *          -  file.txt (в корне)
     *          -  directory/file.txt
     *          -  directory/subdirectory/file.txt
     * @param content
     *          - String
     *          - byte[]
     *          - Bitmap
     *          - (Storable ??? )
     * @return
     */
    public boolean createFile(String fullpath, String content) {
        return writeTextFile(context.getFilesDir(), fullpath, content);
    }


    /**
     * Метод записывает массив байтов в файл
     *
     * @param fullpath
     * @param content
     * @return
     */
    public boolean createFile(String fullpath, byte[] content) {
        return writeBinaryFile(context.getFilesDir(), fullpath, content);
    }


    /**
     * Метод записывает bitmap в файл
     *
     * @param fullpath
     * @param bitmap
     * @param bitmapType
     * @return
     */
    public boolean createFile(String fullpath, Bitmap bitmap, int bitmapType) {
        return writeBitmapFile(context.getFilesDir(), fullpath, bitmap, bitmapType);
    }



    // ***************** READ FILE *****************************************


    /**
     * Метод читает текстовый файл
     *
     * @param fullpath
     * @return - строка текста
     */
    public String readTextFile(String fullpath) {
        return readTextFile(context.getFilesDir(), fullpath);
    }


    /**
     * Метод читает двоичный файд
     *
     * @param fullpath
     * @return
     */
    public byte[] readFile(String fullpath) {
        return readBinaryFile(context.getFilesDir(), fullpath);
    }


    /**
     * Метод читает bitmap файл
     *
     * @param fullpath
     * @return
     */
    public Bitmap readBitmapFile(String fullpath) {
        return readBitmapFromFile(context.getFilesDir(), fullpath);
    }




    // ************** APPEND TO FILE **************************

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




    // ****************** GET FILES *********************************


    /**
     *
     * @param dirName
     * @param order - order type --> name, date, size
     * @return
     */
    public List<File> getFiles(String dirName, int order) {

        return null;  // zaglushka
    }


    /**
     *
     * @param dirName
     * @param regex - Regular expression
     * @return
     */
    public List<File> getFiles(String dirName, String regex) {

        return null;  // zaglushka
    }


    /**
     *
     * @param dirName
     * @param order - - order type --> name, date, size
     * @return
     */
    public List<File> getNestedFiles(String dirName, int order) {

        return null;  // zaglushka
    }


    public List<File> getNestedFiles(String dirName, String regex) {

        return null;  // zaglushka
    }



    // **************** MORE ************************

    public boolean isDirectoryExists(String dirName) {

        return true;
    }


    public boolean isFileExists(String dirName, String fileName) {

        return true;
    }




    // ********************* SECURITY CONFIGURATION *****************






}
