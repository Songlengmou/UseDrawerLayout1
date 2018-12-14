package com.anningtex.usedrawerlayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;

/**
 * 仿淘宝右侧弹出的Drawer
 */
public class MainActivity extends AppCompatActivity {
    private CheckBox btn_button;
    PopScreen screen;
    private DrawerLayout dlShow;
    private GridView brand, price;
    private String[] brandList = {"华为", "小米", "三星", "OPPO", "苹果", "VIVO", "魅族"};
    private String[] priceList = {"0-1000", "1001-1499", "1500-1999", "2000-2999", "3000-3999", "4000-4999", "5000以上"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_button = findViewById(R.id.btn_button);
        dlShow = findViewById(R.id.dlShow);
        brand = findViewById(R.id.brand);
        price = findViewById(R.id.price);
        screen = new PopScreen(MainActivity.this);

        setData();

        btn_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //①
//                    screen.showAtLocation(MainActivity.this.findViewById(R.id.pop), Gravity.RIGHT, 0, 0);
//                    setBackgroundAlpha(0.8f);
                    //②
                    dlShow.openDrawer(Gravity.RIGHT);
                } else {
                    //①
//                    screen.dismiss();
//                    setBackgroundAlpha(1f);
                    //②
                    dlShow.closeDrawers();
                }
            }
        });
    }

    private void setData() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.item, R.id.text, brandList);
        brand.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, R.layout.item, R.id.text, priceList);
        price.setAdapter(arrayAdapter3);
    }

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }

}
