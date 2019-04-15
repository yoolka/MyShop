package lukoyanova.shop.adapter;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import lukoyanova.shop.R;
import lukoyanova.shop.model.RSSNews;

public class RSSHolder implements View.OnClickListener {
    private TextView _header, _description; //вьюхи заголовок и содержание
    private View _like, _dislike; //вьюхи лайки и дислайки
    private RSSNews _news;  //перем. новости

    public RSSHolder(View v) {
        _header = v.findViewById(R.id.header);// находим вьюху заголовок по Id
        _description = v.findViewById(R.id.description);
        _like = v.findViewById(R.id.like);
        _like.setOnClickListener(this);
        _dislike = v.findViewById(R.id.dislike);
        _dislike.setOnClickListener(this);
        v.setTag(this);
    }
    public void update(RSSNews news) {
        _news = news;
        _header.setText(news.title);
        _description.setText(Html.fromHtml(news.description));
        _dislike.setVisibility(news.vote > 0 ? View.GONE : View.VISIBLE);
        _like.setVisibility(news.vote < 0 ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.like:
                if(_news.vote == 0) _news.vote++;
                break;
            case R.id.dislike:
                if(_news.vote == 0) _news.vote--;
                break;
        }
        update(_news);
    }
}
