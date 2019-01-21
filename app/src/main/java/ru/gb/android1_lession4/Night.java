package ru.gb.android1_lession4;


public class Night extends Style {
    public Night() {
        background = R.drawable.night;
        colors = R.style.NightTheme;
    }

    @Override
    public String toNationString(Language language) {
        return language.getWordNight();
    }
}

