package apiParser;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import object.Weather;

public class JsonParser_Weather extends AsyncTask<Void, Void, Map<String, Weather>> {
    String str, recieveMsg;

    Map<String, Weather> datamap = new HashMap<String, Weather>();

    protected Map<String, Weather> doInBackground(Void... voids) {
        String xmlurl = "http://newsky2.kma.go.kr/service/VilageFrcstDspthDocInfoService/WidOverlandForecast?serviceKey=uFLie7nCsSmmq6vJqc4rpTWV%2BZrBYJLSNyt5JEC4UI0OVQV6Id0ymnt2aCA2SaPelvvJFy7hrg%2FoSZgibRfZyg%3D%3D&regId=11B10101&_type=json";
        URL url = null;
        try {
            url = new URL(xmlurl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStreamReader temp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(temp);
                StringBuffer buffer = new StringBuffer();

                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                recieveMsg = buffer.toString();
                datamap = jsonparse(recieveMsg);
                reader.close();
            }
        } catch (Exception e) {

        }
        return datamap;
    }

    public Map<String, Weather> jsonparse(String jsonString) {

        Weather data;
        Map<String, Weather> tmp = new HashMap<String, Weather>();
        String ta, wfCd, rnYn, id;

        try {
            JSONArray jarray = new JSONObject(jsonString).getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
            for (int i = 0; i < jarray.length(); i++) {
                data = new Weather();
                JSONObject jObject = jarray.getJSONObject(i);

                id = jObject.optString("numEf");//아이디
                ta = jObject.optString("ta");//온도
                wfCd = jObject.optString("wfCd");//하늘상태
                rnYn = jObject.optString("rnYn");//눈,비 0:맑음

                data.setId(id);
                data.setTemperature(ta);
                data.setStatus(wfCd);
                data.setRSstatus(rnYn);

                tmp.put(id, data);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tmp;
    }
}
