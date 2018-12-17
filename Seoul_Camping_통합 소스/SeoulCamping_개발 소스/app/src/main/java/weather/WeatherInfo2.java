package weather;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.camping.seoul.seoulcamp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import apiParser.JsonParser_WeatherMore;
import object.WeatherMore;

public class WeatherInfo2 extends Fragment {

    View view;


    /*날씨구현*/
    ImageView WImage1, WImage2, WImage3, WImage4, WImage5;
    TextView temperature1, temperature2, temperature3, temperature4, temperature5;
    TextView txtDay1, txtDay2, txtDay3, txtDay4, txtDay5;
    ArrayList<WeatherMore> weatherdata;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.weather_fragment, container, false);
        /*날씨 구현*/
        WImage1 = (ImageView) rootView.findViewById(R.id.WImage1);
        WImage2 = (ImageView) rootView.findViewById(R.id.WImage2);
        WImage3 = (ImageView) rootView.findViewById(R.id.WImage3);
        WImage4 = (ImageView) rootView.findViewById(R.id.WImage4);
        WImage5 = (ImageView) rootView.findViewById(R.id.WImage5);
        temperature1 = (TextView) rootView.findViewById(R.id.temperature1);
        temperature2 = (TextView) rootView.findViewById(R.id.temperature2);
        temperature3 = (TextView) rootView.findViewById(R.id.temperature3);
        temperature4 = (TextView) rootView.findViewById(R.id.temperature4);
        temperature5 = (TextView) rootView.findViewById(R.id.temperature5);

        txtDay1 = (TextView) rootView.findViewById(R.id.txtDay1);
        txtDay2 = (TextView) rootView.findViewById(R.id.txtDay2);
        txtDay3 = (TextView) rootView.findViewById(R.id.txtDay3);
        txtDay4 = (TextView) rootView.findViewById(R.id.txtDay4);
        txtDay5 = (TextView) rootView.findViewById(R.id.txtDay5);

        getWeather();
        return rootView;
    }


    public void getWeather() {//날씨정보 가져오기
        try {
            weatherdata = new JsonParser_WeatherMore().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Calendar cal = Calendar.getInstance();
        cal.add(cal.DAY_OF_MONTH, 3);
        txtDay1.setText(getDay(cal));
        cal.add(cal.DAY_OF_MONTH, 1);
        txtDay2.setText(getDay(cal));
        cal.add(cal.DAY_OF_MONTH, 1);
        txtDay3.setText(getDay(cal));
        cal.add(cal.DAY_OF_MONTH, 1);
        txtDay4.setText(getDay(cal));
        cal.add(cal.DAY_OF_MONTH, 1);
        txtDay5.setText(getDay(cal));


        for (int i = 1; i < 10; i += 2) {
            String tmEf = weatherdata.get(i).getTmEf(); // 날짜
            String wf = weatherdata.get(i).getWf(); // 날씨
            String tmn = weatherdata.get(i).getTmn();//최저온도
            String tmx = weatherdata.get(i).getTmx(); //최고온도
            switch (i) {
                case 1:
                    temperature1.setText(tmn + "˚/" + tmx + "˚");
                    WImage1.setImageResource(checkWF(wf));
                    break;
                case 3:
                    temperature2.setText(tmn + "˚/" + tmx + "˚");
                    WImage2.setImageResource(checkWF(wf));
                    break;
                case 5:
                    temperature3.setText(tmn + "˚/" + tmx + "˚");
                    WImage3.setImageResource(checkWF(wf));
                    break;
                case 7:
                    temperature4.setText(tmn + "˚/" + tmx + "˚");
                    WImage4.setImageResource(checkWF(wf));
                    break;
                case 9:
                    temperature5.setText(tmn + "˚/" + tmx + "˚");
                    WImage5.setImageResource(checkWF(wf));
                    break;
            }
        }
    }

    public String getWeek(int num) {
        String week = "";
        switch (num) {
            case 1:
                week = "일";
                break;
            case 2:
                week = "월";
                break;
            case 3:
                week = "화";
                break;
            case 4:
                week = "수";
                break;
            case 5:
                week = "목";
                break;
            case 6:
                week = "금";
                break;
            case 7:
                week = "토";
                break;
        }
        return week;
    }

    public String getDay(Calendar cal) {
        Log.i("Calendar.DAY_OF_WEEK : ", Integer.toString(Calendar.DAY_OF_WEEK));
        String day = Integer.toString(cal.get(Calendar.MONTH) + 1) + "/" + Integer.toString(cal.get(Calendar.DATE)) + "(" + getWeek(cal.get(Calendar.DAY_OF_WEEK)) + ")";
        return day;
    }

    public int checkWF(String wf) {
        int weatherIcon = 0;
        if (wf.equals("맑음")) {
            weatherIcon = R.drawable.weather_sun_icon_128;
        } else if (wf.equals("구름조금")) {
            weatherIcon = R.drawable.weather_partly_cloudy_day_icon_128;
        } else if (wf.equals("구름많음") || wf.equals("흐림")) {
            weatherIcon = R.drawable.weather_clouds_icon_128;
        } else if (wf.equals("구름많고 비") || wf.equals("흐리고 비")) {
            weatherIcon = R.drawable.weather_downpour_icon_128;
        } else if (wf.equals("구름많고 비/눈") || wf.equals("구름많고 눈/비") || wf.equals("흐리고 비/눈") || wf.equals("흐리고 눈/비")) {
            weatherIcon = R.drawable.weather_sleet_icon_128;
        } else {
            weatherIcon = R.drawable.weather_little_snow_icon_128;
        }
        return weatherIcon;
    }
}
