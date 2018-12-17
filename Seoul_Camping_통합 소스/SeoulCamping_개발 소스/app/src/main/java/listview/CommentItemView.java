package listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.camping.seoul.seoulcamp.R;

public class CommentItemView extends LinearLayout {
    TextView txtName;
    TextView txtComment;
    RatingBar ratingBar;
    TextView txtTime;

    public CommentItemView(Context context) {
        super(context);

        init(context);
    }

    public CommentItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(final Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_commnet, this, true);

        txtName = (TextView) findViewById(R.id.txtName);
        txtComment = (TextView) findViewById(R.id.txtComment);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtTime = (TextView)findViewById(R.id.txtTime);

    }

    public void setID(String name) {
        txtName.setText(name);
    }

    public void setComment(String comment) {
        txtComment.setText(comment);
    }

    public void setRating(double rating) {
        ratingBar.setRating((float) rating);
    }

    public void setTime(String regdate) { txtTime.setText(regdate.substring(0,19)); }

}
