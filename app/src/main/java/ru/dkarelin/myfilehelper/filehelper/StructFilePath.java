package ru.dkarelin.myfilehelper.filehelper;

/**
 * Класс структура пути файла
 */
public class StructFilePath {

    /**  Существует ли файл в переданном пути */
    private boolean isFileExists;

    /** Название файла */
    private String fileName;

    /** Количество дирректорий и поддиректорий */
    private int countDirSegments;

    /** Путь к дирректориям */
    private String dirPath;


    public boolean isFileExists() {
        return isFileExists;
    }

    public void setFileExists(boolean fileExists) {
        this.isFileExists = fileExists;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getCountDirSegments() {
        return countDirSegments;
    }

    public void setCountDirSegments(int countDirSegments) {
        this.countDirSegments = countDirSegments;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }




}
