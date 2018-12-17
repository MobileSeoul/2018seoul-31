package apiParser;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

import object.WeatherMore;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonParser_WeatherMore extends AsyncTask<Void, Void, ArrayList<WeatherMore>> {

    ArrayList<WeatherMore> data = new ArrayList<WeatherMore>();

    protected ArrayList<WeatherMore> doInBackground(Void... voids) {
        String url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            data = parseWeekXML(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


    public ArrayList<WeatherMore> parseWeekXML(String xml) {
        ArrayList<WeatherMore> tmp = new ArrayList<>();
        try {
            String tagName = "";
            boolean onCity = false;
            boolean onTmEf = false;
            boolean onWf = false;
            boolean onTmn = false;
            boolean onTmx = false;
            boolean onEnd = false;
            boolean isItemTag1 = false;
            int i = 0;


            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(new StringReader(xml));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    tagName = parser.getName();

                    if (tagName.equals("city")) {
                        eventType = parser.next();

                        if (parser.getText().equals("서울")) {    // 파싱하고 싶은 지역 이름을 쓴다
                            onCity = true;
                        } else {
                            if (onCity) { // 이미 parsing을 끝냈을 경우
                                break;
                            } else {        // 아직 parsing을 못했을 경우
                                onCity = false;
                            }
                        }
                    }

                    if (tagName.equals("data") && onCity) {
                        tmp.add(new WeatherMore());
                        onEnd = false;
                        isItemTag1 = true;
                    }
                } else if (eventType == XmlPullParser.TEXT && isItemTag1 && onCity) {
                    if (tagName.equals("tmEf") && !onTmEf) {
                        tmp.get(i).setTmEf(parser.getText());
                        onTmEf = true;
                    }
                    if (tagName.equals("wf") && !onWf) {
                        tmp.get(i).setWf(parser.getText());
                        onWf = true;
                    }
                    if (tagName.equals("tmn") && !onTmn) {
                        tmp.get(i).setTmn(parser.getText());
                        onTmn = true;
                    }
                    if (tagName.equals("tmx") && !onTmx) {
                        tmp.get(i).setTmx(parser.getText());
                        onTmx = true;
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (tagName.equals("reliability") && onEnd == false) {
                        i++;
                        onTmEf = false;
                        onWf = false;
                        onTmn = false;
                        onTmx = false;
                        isItemTag1 = false;
                        onEnd = true;
                    }
                }

                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tmp;
    }
}