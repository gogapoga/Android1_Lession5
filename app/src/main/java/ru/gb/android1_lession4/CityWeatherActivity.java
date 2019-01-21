package ru.gb.android1_lession4;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CityWeatherActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(((MyApplication)getApplication()).getStyle().getColors());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        Bundle bundle = getIntent().getExtras();
        CityWeather city = (CityWeather) bundle.getSerializable(ParamShow.CityWeather.toString());
        setTitle(makeTitle(city.getName()));
        LinearLayout timeweather = (LinearLayout) findViewById(R.id.timeweather);
        timeweather.setBackgroundResource(((MyApplication) getApplication()).getStyle().getBackground());
        for (int i = 0; i < 24; i++) {
            Button timeWeather = new Button(this);
            timeWeather.setTypeface(null, Typeface.ITALIC);
            timeWeather.setTextColor(getResources().getColor(R.color.colorButton));
            timeWeather.setClickable(false);
            timeWeather.setGravity(Gravity.LEFT | Gravity.TOP);
            StringBuilder str = new StringBuilder(((MyApplication) this.getApplication()).getLanguage().getWordTime());
            str.append(i);
            str.append(":00\n");
            str.append(((MyApplication) this.getApplication()).getLanguage().getWordTemperature());
            int t = city.getStrTemp(i);
            if (t > 0) str.append("+");
            str.append(t);
            str.append(((MyApplication) this.getApplication()).getLanguage().getWordC());
            t = city.getHumidity(i);
            if (((MyApplication) this.getApplication()).isShowHumidity()) {
                str.append("\n");
                str.append(((MyApplication) this.getApplication()).getLanguage().getWordHumidity());
                str.append(": ");
                str.append(t);
                str.append("%");
            }
            if (((MyApplication) this.getApplication()).isShowWind()) {
                str.append("\n");
                str.append(((MyApplication) this.getApplication()).getLanguage().getWordWind());
                str.append(": ");
                str.append(city.getWind(i));
                str.append(((MyApplication) this.getApplication()).getLanguage().getWordMC());
            }
            if (((MyApplication) this.getApplication()).isShowPressure()) {
                str.append("\n");
                str.append(((MyApplication) this.getApplication()).getLanguage().getWordPressure());
                str.append(": ");
                str.append(city.getPressure(i));
                str.append(((MyApplication) this.getApplication()).getLanguage().getWordMMPTST());
            }
            timeWeather.setText(str);
            Drawable img;
            if (t < 40) img = getResources().getDrawable(R.drawable.sun);
            else if (t > 80) img = getResources().getDrawable(R.drawable.cloud_r);
            else img = getResources().getDrawable(R.drawable.cloud);
            img.setBounds(0, 0, 60, 60);
            timeWeather.setCompoundDrawables(null, null, img, null);
            timeweather.addView(timeWeather);
        }
    }

    private String makeTitle(String cityName) {
        StringBuilder str = new StringBuilder("");
        str.append(cityName);
        str.append("     ");
        SimpleDateFormat sdf = new SimpleDateFormat("E  d MMM", Locale.forLanguageTag(((MyApplication) this.getApplication()).getLanguage().getWordDate()));
        str.append(sdf.format(Calendar.getInstance().getTime()));
        return str.toString();
    }
}
