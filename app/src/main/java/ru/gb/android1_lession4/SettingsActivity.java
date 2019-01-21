package ru.gb.android1_lession4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //обработка нажатия стрелки в верхнем меню
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() { //обработка нажатия кнопки назад
        Intent SecAct = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(SecAct);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(((MyApplication) getApplication()).getStyle().getColors());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(((MyApplication) this.getApplication()).getLanguage().getWordSettings());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout linear = (LinearLayout) findViewById(R.id.settings);
        linear.setBackgroundResource(((MyApplication) getApplication()).getStyle().getBackground());
        //создание меню настройки языка
        final ParamLanguage[] paramLanguages = ParamLanguage.values();
        String[] strLang = new String[paramLanguages.length];
        for (int i = 0; i < paramLanguages.length; i++) {
            strLang[i] = paramLanguages[i].toNationString();
        }
        Spinner language = (Spinner) findViewById(R.id.language);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strLang);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(adapter);
        language.setSelection(((MyApplication) this.getApplication()).getSelectedLanguage());
        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView) parentView.getChildAt(0)).setTextColor(Color.WHITE);
                if (position != ((MyApplication) getApplication()).getSelectedLanguage()) {
                    ((MyApplication) getApplication()).setSelectedLanguage(position);
                    try {
                        ((MyApplication) getApplication()).setLanguage((Language) Class.forName(getPackageName() + "." + paramLanguages[position].toString()).newInstance());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                    Intent newAct = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(newAct);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        //создание меню настройки стиля
        ParamStyle[] paramStyles = ParamStyle.values();
        final Style[] objSt = new Style[paramStyles.length];
        String[] strSt = new String[paramStyles.length];
        for (int i = 0; i < paramStyles.length; i++) {
            try {
                objSt[i] = (Style) Class.forName(getPackageName() + "." + paramStyles[i].toString()).newInstance();
                strSt[i] = objSt[i].toNationString(((MyApplication) getApplication()).getLanguage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        Spinner style = (Spinner) findViewById(R.id.style);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strSt);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        style.setAdapter(adapter);
        style.setSelection(((MyApplication) this.getApplication()).getSelectedStyle());
        style.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView) parentView.getChildAt(0)).setTextColor(Color.WHITE);
                if (position != ((MyApplication) getApplication()).getSelectedStyle()) {
                    ((MyApplication) getApplication()).setSelectedStyle(position);
                    ((MyApplication) getApplication()).setStyle(objSt[position]);
                    Intent newAct = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(newAct);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }
}
