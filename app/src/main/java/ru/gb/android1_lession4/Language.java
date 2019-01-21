package ru.gb.android1_lession4;

public abstract class Language { //базовый класс для языков, задав значения этих переменных и прописав имя языка
    // в ParamLanguage можно подключить еще один язык, в других классах ничего менять не надо (кроме названий
    // городов, будут английские имена)
    protected String wordWeather;
    protected String wordDate;
    protected String wordSettings;
    protected String wordLanguage;
    protected String wordStyle;
    protected String wordTime;
    protected String wordTemperature;
    protected String wordWind;
    protected String wordPressure;
    protected String wordHumidity;
    protected String wordC;
    protected String wordMMPTST;
    protected String wordMC;

    public String getWordDay() {
        return wordDay;
    }

    public void setWordDay(String wordDay) {
        this.wordDay = wordDay;
    }

    public String getWordNight() {
        return wordNight;
    }

    public void setWordNight(String wordNight) {
        this.wordNight = wordNight;
    }

    protected String wordDay;
    protected String wordNight;

    public String getWordWeather() {
        return wordWeather;
    }

    public String getWordDate() {
        return wordDate;
    }

    public String getWordSettings() {
        return wordSettings;
    }

    public String getWordLanguage() {
        return wordLanguage;
    }
    public String getWordStyle() {
        return wordStyle;
    }

    public String getWordTime() {
        return wordTime;
    }

    public String getWordTemperature() {
        return wordTemperature;
    }

    public String getWordWind() {
        return wordWind;
    }

    public String getWordPressure() {
        return wordPressure;
    }

    public String getWordHumidity() {
        return wordHumidity;
    }

    public String getWordC() {
        return wordC;
    }

    public String getWordMC() {
        return wordMC;
    }

    public String getWordMMPTST() {
        return wordMMPTST;
    }
}
