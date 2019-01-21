package ru.gb.android1_lession4;

public enum ParamLanguage {
    Russian("Русский"),
    English("English");

    ParamLanguage(String title) {
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public String toNationString() {
        return title;
    }
}
