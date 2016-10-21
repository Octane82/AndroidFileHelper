package ru.dkarelin.myfilehelper.filehelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Базовый класс над операциями с файлами
 */
public class BaseFileOperations {

    private final String TAG = this.getClass().getSimpleName();




    // ************* Create Directory *******************************

    /**
     * Метод создаёт дирректорию
     *
     * @param file - внутренняя или внешеяя память
     * @param path - путь к дирректории
     * @return
     */
    protected boolean createDirrectory(File file, String path) {
        StructFilePath sp = parsePath(path);
        if (sp.isFileExists()) {
            Log.d(TAG, "Wrong dir path. PATH include filename");
            return false;
        } else {
            if (sp.getCountDirSegments() == 1) {
                Log.d(TAG, "Create ONE dir");
                File dir = new File(file, sp.getDirPath());
                return dir.mkdir();
            } else {
                Log.d(TAG, "Create MANY dirs");
                File dirs = new File(file, sp.getDirPath());
                return dirs.mkdirs();
            }
        }
    }


    // ********** Create FILES ***************************************************


    /**
     * Метод создаёт дирректоию, или дирректории если указан длинный путь
     * @param file
     * @param path
     * @return
     */
    private StructFilePath createDirs4File(File file, String path) {
        StructFilePath sp = parsePath(path);

        if (sp.isFileExists() && sp.getCountDirSegments() > 0) {
            if (sp.getCountDirSegments() == 1) {
                File dir = new File(file, sp.getDirPath());
                dir.mkdir();
            } else {
                File dirs = new File(file, sp.getDirPath());
                dirs.mkdirs();
            }
        }
        return sp;
    }


    // ------------  write files  ----------------------------------


    /**
     * Метод записывает текст в файл
     *
     * @param file    - getFilesDir( /files )
     * @param path
     * @param content
     * @return
     */
    protected boolean writeTextFile(File file, String path, String content) {
        // create dirs if necessary
        StructFilePath sp = createDirs4File(file, path);

        if (sp.isFileExists()) {
            BufferedWriter bw;
            try {
                if (sp.getDirPath() == null) {
                    bw = new BufferedWriter(new FileWriter(
                                    new File(file + "/" + sp.getFileName())));
                } else {
                    bw = new BufferedWriter(new FileWriter(
                                    new File(file + "/" + sp.getDirPath()
                                            + "/" + sp.getFileName())));
                }
                bw.write(content);
                bw.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    /**
     * Метод записывает массив байтов в файл
     *
     * @param file
     * @param path
     * @param content
     * @return
     */
    protected boolean writeBinaryFile(File file, String path, byte[] content) {
        // Если существуют дирректории создаём их
        StructFilePath sp = createDirs4File(file, path);

        // TODO: Или   ByteArrayInputStream bais = new ByteArrayInputStream(yourBytes);

        if (sp.isFileExists()) {
            BufferedOutputStream bos;
            try {
                if (sp.getDirPath() == null) {
                    bos = new BufferedOutputStream(new FileOutputStream(
                            new File(file + "/" + sp.getFileName())));
                } else {
                    bos = new BufferedOutputStream(new FileOutputStream(
                            new File(file + "/" + sp.getDirPath()
                                            + "/" + sp.getFileName())));
                }
                bos.write(content);
                bos.flush();
                bos.close();
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    /**
     * Метод записывает bitmap в файл
     *
     * @param file
     * @param path
     * @param bitmap
     * @return
     */
    protected boolean writeBitmapFile(File file, String path, Bitmap bitmap, int bitmapType) {
        // Если существуют дирректории создаём их
        StructFilePath sp = createDirs4File(file, path);

        if (sp.isFileExists()) {
            FileOutputStream ostream;
            try {
                if (sp.getDirPath() == null) {
                    ostream = new FileOutputStream(
                            new File(file + "/" + sp.getFileName()));
                } else {
                    ostream = new FileOutputStream(
                            new File(file + "/" + sp.getDirPath()
                                            + "/" + sp.getFileName()));
                }
                // Compress bitmap
                switch (bitmapType) {
                    case FileType.BITMAP_JPG :
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream); break;
                    case FileType.BITMAP_PNG :
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream); break;
                    case FileType.BITMAP_WEBP :
                        bitmap.compress(Bitmap.CompressFormat.WEBP, 100, ostream); break;
                }
                ostream.flush();
                ostream.close();
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    // ******************************************************

    /**
     * Метод читает текстовый файл
     *
     * @param file - файл путь к устройству.
     *             Внешняя или внутренняя память
     * @param path - путь к файлу (dir/subdir/file.txt)
     * @return
     */
    protected String readTextFile(File file, String path) {
        StringBuilder sBuilder = new StringBuilder();
        try {
            BufferedReader br =
                    new BufferedReader(new FileReader(
                            new File(file + "/" + path)));
            String line;
            while ((line = br.readLine()) != null) {
                sBuilder.append(line);
                sBuilder.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sBuilder.toString();
    }


    /**
     * Метод читает бинарный файл
     *
     * @param file - файл путь к устройству.
     *             Внешняя или внутренняя память
     * @param path - путь к файлу (dir/subdir/file.raw)
     * @return
     */
    protected byte[] readBinaryFile(File file, String path) {
        File f = new File(file + "/" + path);
        int size = (int) f.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf =
                    new BufferedInputStream(new FileInputStream(f));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }


    /**
     * Метод читает bitmap файл
     *
     * @param file
     * @param path
     * @return
     */
    protected Bitmap readBitmapFromFile(File file, String path) {
        File f = new File(file + "/" + path);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(f.getPath(), options);
    }




    // *****************************************************

    /**
     * Метод парсит путь дирректорий и файлов
     * @param path
     * @return
     *
     * TODO: Переделать с помощью регулярных выражений
     */
    private StructFilePath parsePath(String path) {
        StructFilePath sPath = new StructFilePath();

        String[] segments = path.split("/");

        int countDirs = 0;
        int countFiles = 0;
        StringBuilder dirPath = new StringBuilder();
        String fileName = "";

        // Parsing path
        for (String seg : segments) {
            if (!seg.equals("") && !seg.contains(".")) {
                countDirs++;
                dirPath.append(seg);
                dirPath.append("/");
            } else if (!seg.equals("") && seg.contains(".")) {
                countFiles = 1;
                fileName = seg;
            }
        }

        // Creating DIRRECTORY or files
        // Создаём дирректорию если 1 сегмент /mydir
        if (countDirs == 1) {
            sPath.setFileExists(false);
            sPath.setCountDirSegments(1);
            sPath.setDirPath(dirPath.toString());
        }

        // Создаём дирректории, если вложенные сегменты /mydir/mysubdir
        if (countDirs > 1) {
            sPath.setFileExists(false);
            sPath.setCountDirSegments(countDirs);
            sPath.setDirPath(dirPath.toString());
        }

        // Create FILE. Filepath - путь к файлу
        if (countFiles == 1) {
            if (countDirs == 0) {
                //   /text.txt
                sPath.setFileExists(true);
                sPath.setCountDirSegments(0);
                //sPath.setDirPath(fileName);
                sPath.setFileName(fileName);
            } else {
                //   /dir/subdir/text.txt
                sPath.setFileExists(true);
                sPath.setCountDirSegments(countDirs);
                sPath.setFileName(fileName);
            }
        }

        return sPath;
    }




}
