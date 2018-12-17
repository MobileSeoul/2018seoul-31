package connectDB;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import listview.CommentItem;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class
NetworkTask_GetList extends AsyncTask<String, Void, List<CommentItem>> {
    @Override
    protected List<CommentItem> doInBackground(String... voids) {
        String url = "http://203.253.255.113:9090/comment/listAll";
        String queryurl = url + "?camp=" + voids[0];
        String bodyStr = "";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(queryurl)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            bodyStr = response.body().string();
            Log.d("response", bodyStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        CommentItem[] array = gson.fromJson(bodyStr, CommentItem[].class);
        List<CommentItem> list = Arrays.asList(array);

        return list;
    }
}
