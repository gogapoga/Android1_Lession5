package ru.gb.android1_lession4;

public class Day extends Style {
    public Day() {
        background = R.drawable.day;
        colors = R.style.DayTheme;
    }

    @Override
    public String toNationString(Language language) {
        return language.getWordDay();
    }
}
