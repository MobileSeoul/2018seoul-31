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

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import apiParser.JsonParser_Weather;
import object.Weather;

public class WeatherInfo extends Fragment {

    View view;


    /*날씨구현*/
    ImageView WImage1, WImage2, WImage3, WImage4, WImage5;
    TextView temperature1, temperature2, temperature3, temperature4, temperature5;
    TextView txtDay1, txtDay2, txtDay3, txtDay4, txtDay5;
    Map<String, Weather> weatherdata = null;


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
            weatherdata = new JsonParser_Weather().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        txtDay1.setText(getDay(cal));
        cal.add(cal.DAY_OF_MONTH, 1);
        txtDay2.setText(getDay(cal));
        txtDay3.setText(getDay(cal));
        cal.add(cal.DAY_OF_MONTH, 1);
        txtDay4.setText(getDay(cal));
        txtDay5.setText(getDay(cal));

        if (weatherdata.size() == 6) {
            temperature1.setText(weatherdata.get("0").getTemperature() + "˚");
            temperature2.setText(weatherdata.get("2").getTemperature() + "˚");
            temperature3.setText(weatherdata.get("3").getTemperature() + "˚");
            temperature4.setText(weatherdata.get("4").getTemperature() + "˚");
            temperature5.setText(weatherdata.get("5").getTemperature() + "˚");

            /* 날씨 이미지 1 */
            if (weatherdata.get("0").getRSstatus().equals("0")) {
                if (weatherdata.get("0").getStatus().equals("DB01")) {
                    WImage1.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("0").getStatus().equals("DB02")) {
                    WImage1.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage1.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("0").getRSstatus().equals("1")) {
                    WImage1.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("0").getRSstatus().equals("2")) {
                    WImage1.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage1.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }

            /* 날씨 이미지 2 */
            if (weatherdata.get("2").getRSstatus().equals("0")) {
                if (weatherdata.get("2").getStatus().equals("DB01")) {
                    WImage2.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("2").getStatus().equals("DB02")) {
                    WImage2.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage2.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("2").getRSstatus().equals("1")) {
                    WImage2.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("2").getRSstatus().equals("2")) {
                    WImage2.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage2.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }

            /* 날씨 이미지 3 */
            if (weatherdata.get("3").getRSstatus().equals("0")) {
                if (weatherdata.get("3").getStatus().equals("DB01")) {
                    WImage3.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("3").getStatus().equals("DB02")) {
                    WImage3.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage3.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("3").getRSstatus().equals("1")) {
                    WImage3.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("3").getRSstatus().equals("2")) {
                    WImage3.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage3.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }

            /* 날씨 이미지 4 */
            if (weatherdata.get("4").getRSstatus().equals("0")) {
                if (weatherdata.get("4").getStatus().equals("DB01")) {
                    WImage4.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("4").getStatus().equals("DB02")) {
                    WImage4.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage4.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("4").getRSstatus().equals("1")) {
                    WImage4.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("4").getRSstatus().equals("2")) {
                    WImage4.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage4.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }

            /* 날씨 이미지 5*/
            if (weatherdata.get("5").getRSstatus().equals("0")) {
                if (weatherdata.get("5").getStatus().equals("DB01")) {
                    WImage5.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("5").getStatus().equals("DB02")) {
                    WImage5.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage5.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("5").getRSstatus().equals("1")) {
                    WImage5.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("5").getRSstatus().equals("2")) {
                    WImage5.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage5.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }
        } else {

            temperature1.setText(weatherdata.get("0").getTemperature() + "˚");
            temperature2.setText(weatherdata.get("1").getTemperature() + "˚");
            temperature3.setText(weatherdata.get("2").getTemperature() + "˚");
            temperature4.setText(weatherdata.get("3").getTemperature() + "˚");
            temperature5.setText(weatherdata.get("4").getTemperature() + "˚");

            /* 날씨 이미지 1 */
            if (weatherdata.get("0").getRSstatus().equals("0")) {
                if (weatherdata.get("0").getStatus().equals("DB01")) {
                    WImage1.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("0").getStatus().equals("DB02")) {
                    WImage1.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage1.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("0").getRSstatus().equals("1")) {
                    WImage1.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("0").getRSstatus().equals("2")) {
                    WImage1.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage1.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }
            /*날씨 이미지 2*/
            if (weatherdata.get("1").getRSstatus().equals("0")) {
                if (weatherdata.get("1").getStatus().equals("DB01")) {
                    WImage2.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("1").getStatus().equals("DB02")) {
                    WImage2.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage2.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("1").getRSstatus().equals("1")) {
                    WImage2.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("1").getRSstatus().equals("2")) {
                    WImage2.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage2.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }
            /*날씨 이미지 3*/
            if (weatherdata.get("2").getRSstatus().equals("0")) {
                if (weatherdata.get("2").getStatus().equals("DB01")) {
                    WImage3.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("2").getStatus().equals("DB02")) {
                    WImage3.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage3.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("2").getRSstatus().equals("1")) {
                    WImage3.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("2").getRSstatus().equals("2")) {
                    WImage3.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage3.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }
            /*날씨 이미지 4*/
            if (weatherdata.get("3").getRSstatus().equals("0")) {
                if (weatherdata.get("3").getStatus().equals("DB01")) {
                    WImage4.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("3").getStatus().equals("DB02")) {
                    WImage4.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage4.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("3").getRSstatus().equals("1")) {
                    WImage4.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("3").getRSstatus().equals("2")) {
                    WImage4.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage4.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
            }
            /*날씨 이미지 5*/
            if (weatherdata.get("4").getRSstatus().equals("0")) {
                if (weatherdata.get("4").getStatus().equals("DB01")) {
                    WImage5.setImageResource(R.drawable.weather_sun_icon_128);
                } else if (weatherdata.get("4").getStatus().equals("DB02")) {
                    WImage5.setImageResource(R.drawable.weather_partly_cloudy_day_icon_128);
                } else {
                    WImage5.setImageResource(R.drawable.weather_clouds_icon_128);
                }
            } else {
                if (weatherdata.get("4").getRSstatus().equals("1")) {
                    WImage5.setImageResource(R.drawable.weather_downpour_icon_128);
                } else if (weatherdata.get("4").getRSstatus().equals("2")) {
                    WImage5.setImageResource(R.drawable.weather_sleet_icon_128);
                } else {
                    WImage5.setImageResource(R.drawable.weather_little_snow_icon_128);
                }
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
}
