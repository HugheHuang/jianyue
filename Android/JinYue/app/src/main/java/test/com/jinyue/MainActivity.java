//阅读器主体

package test.com.jinyue;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);//toolbar导入
        setSupportActionBar(toolbar);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.tag);//把标签按钮绑定
        }
        set_checkout();
    }
    public boolean onCreateOptionsMenu(Menu menu){//加载toolbar布局
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){//处理toolbar点击事件
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    //读取SharedPreference，赋值给checkbox兴趣标签,复选框按键功能，把复选框的内容记录到shareperference
    public void set_checkout(){
        //读取SharedPreference，赋值给checkbox兴趣标签
        CheckBox meiwen1=(CheckBox)findViewById(R.id.MeiWen1);
        CheckBox zexue1=(CheckBox)findViewById(R.id.ZeXue1);
        CheckBox tuili1=(CheckBox)findViewById(R.id.TuiLi1);
        CheckBox kehuan1=(CheckBox)findViewById(R.id.KeHuan1);
        CheckBox jishi1=(CheckBox)findViewById(R.id.JiShi1);
        CheckBox jitang1=(CheckBox)findViewById(R.id.JiTang1);
        CheckBox guwen1=(CheckBox)findViewById(R.id.GuWen1);
        SharePreference sp=new SharePreference(MainActivity.this);
        boolean flag = sp.getMeiWen();
        meiwen1.setChecked(flag);
        flag = sp.getZeXue();
        zexue1.setChecked(flag);
        flag = sp.getTuiLi();
        tuili1.setChecked(flag);
        flag = sp.getKeHuan();
        kehuan1.setChecked(flag);
        flag = sp.getJiShi();
        jishi1.setChecked(flag);
        flag = sp.getJiTang();
        jitang1.setChecked(flag);
        flag = sp.getGuWen();
        guwen1.setChecked(flag);

        //复选框按键功能，把复选框的内容记录到shareperference
        meiwen1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setMeiWenTrue();
                }
                else{
                    sp.setMeiWenFalse();
                }
            }
        });
        zexue1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setZeXueTrue();
                }
                else{
                    sp.setZeXueFalse();
                }
            }
        });
        tuili1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setTuiLiTrue();
                }
                else{
                    sp.setTuiLiFalse();
                }
            }
        });
        kehuan1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setKeHuanTrue();
                }
                else{
                    sp.setKeHuanFalse();
                }
            }
        });
        jishi1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setJiShiTrue();
                }
                else{
                    sp.setJiShiFalse();
                }
            }
        });
        jitang1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setJiTangTrue();
                }
                else{
                    sp.setJiTangFalse();
                }
            }
        });
        guwen1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(MainActivity.this);
                if(isChecked){
                    sp.setGuWenTrue();
                }
                else{
                    sp.setGuWenFalse();
                }
            }
        });
    }

}
