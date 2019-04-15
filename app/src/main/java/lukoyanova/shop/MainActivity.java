package lukoyanova.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.text.Html;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Button;

import java.util.ArrayList;

import lukoyanova.shop.adapter.RSSHolder;
import lukoyanova.shop.model.RSSNews;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View holder;
    private ListView list1;

    //новости

    private class MyAdapter extends BaseAdapter {

        private ArrayList<RSSNews> CONTENT = new ArrayList<>();
        private MyAdapter() {
            CONTENT.add(new RSSNews() {
                {
                    title = "Новость 1";
                    description = "Европейская комиссия представила прорывное научное открытие сделанное при помощи Event Horizon Telescope — проекта международного научного сотрудничества, целью которого явилось получение первого изображения черной дыры путем создания виртуального телескопа размером с Землю. Исследователи, финансируемые ЕС, сыграли ключевую роль в проекте. ";
                }
            });
            CONTENT.add(new RSSNews() {
                {
                    title = "Новость 2";
                    description = "Оказывается теперь только один вариант аутентификации — это на странице <a href=\"https://gitlab.com/profile/personal_access_tokens\">https://gitlab.com/profile/personal_access_tokens</a>, создать токен, и использовать его вместо пароля.<br> <a href=\"https://habr.com/ru/post/447564/?utm_source=habrahabr&amp;utm_medium=rss&amp;utm_campaign=447564#habracut\">Читать дальше →</a>";
                }
            });
        }
        @Override
        public int getCount() {
            return CONTENT.size();
        }

        @Override
        public RSSNews getItem(int position) {
            return CONTENT.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position+1;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //используем заново существующий элемент, который не отображается
            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.rssnews,parent,false);
                new RSSHolder(convertView);
            }
            ((RSSHolder)convertView.getTag()).update(getItem(position));

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//метод создается вызывается при исходном создание активности
        super.onCreate(savedInstanceState);//
        setContentView(R.layout.shop_item);//сообщает какой макет использует активность
        TextView a = findViewById(R.id.button1); //находим вьюху гл.меню по id
        list1 = findViewById(R.id.list1);//список кнопок подменю
        list1.setAdapter(new MyAdapter());
        a.setOnClickListener(this);
        holder = findViewById(R.id.v_holder);

    }
    @Override
    public void onClick(View a){
        switch (a.getId()){
            case R.id.button1:
            holder.setVisibility(holder.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            break;
        }
    }

}
