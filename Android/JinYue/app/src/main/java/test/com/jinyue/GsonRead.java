package test.com.jinyue;

import android.icu.text.IDNA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王国华 on 2017/11/16.
 */

public class GsonRead {
    public String Title;
    public String Auther;
    public String Text;
    /*private void parserJSON(String strJSON)

    {

        Gson gson = new Gson();

        Type type = new TypeToken<List<HomeData>>()

        {

        }.getType();

        List<HomeData> mDataInfo = gson.fromJson(strJSON, type);

    }

    private void parse() {
        Gson gson = new Gson();
        switch (type) {
            //最外层是{}，封装为一个对象
            case OBJ:
                Bean fromJson = gson.fromJson(readContent, Bean.class);
                System.out.println(fromJson.toString());
                break;
            //最外层是[]，封装为一个数组对象
            case ARR:
                Type type = new TypeToken<List<IDNA.Info>>() {}.getType();
                Object fromJson2 = gson.fromJson(readContent, type);
                List<IDNA.Info> list = (List<IDNA.Info>) fromJson2;
                break;
        }
    }*/

    public static List getGson(String jsonString, String Title, String Auther, String Text) {
        Gson gson = new Gson();
        GsonRead gsonRead = gson.fromJson(jsonString, GsonRead.class);
        Title = gsonRead.Title;
        Auther = gsonRead.Auther;
        Text = gsonRead.Text;
        System.out.println(Title);
        System.out.println(Text);
        List<String> list = new ArrayList<String>();
        list.add(Title);
        list.add(Auther);
        list.add(Text);
        return list;
    }


}
