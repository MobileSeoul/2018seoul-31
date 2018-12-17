package connectDB;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import listview.CommentItem;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkTask_AddList extends AsyncTask<CommentItem, Void, Integer> {


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected Integer doInBackground(CommentItem... voids) {

        String url = "http://203.253.255.113:9090/comment/addList";
        /* Tojson */

        String json;

        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("camp", voids[0].getCamp());
        object.addProperty("id", voids[0].getId());
        object.addProperty("name", "test");
        object.addProperty("text", voids[0].getText());
        object.addProperty("star", voids[0].getStar());
        object.addProperty("password", voids[0].getPassword());

        json = gson.toJson(object);

        /*--------------*/

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
