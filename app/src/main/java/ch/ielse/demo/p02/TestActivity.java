package ch.ielse.demo.p02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import ch.ielse.view.imagewatcher.ImageWatcher;

/**
 * Created by chenhailin on 2018/4/10.
 */

public class TestActivity extends AppCompatActivity {

    private ImageWatcher vImageWatcher;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);


        vImageWatcher = (ImageWatcher) findViewById(R.id.v_image_watcher);
        // 如果是透明状态栏，你需要给ImageWatcher标记 一个偏移值，以修正点击ImageView查看的启动动画的Y轴起点的不正确
        vImageWatcher.setTranslucentStatus( Utils.calcStatusBarHeight(this));
        // 配置error图标
        vImageWatcher.setErrorImageRes(R.mipmap.error_picture);
        // 长按图片的回调，你可以显示一个框继续提供一些复制，发送等功能
        vImageWatcher.setOnPictureLongPressListener(null);

        findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ImageView> imageGroupLis=new ArrayList<ImageView>();
                imageGroupLis.add((ImageView) findViewById(R.id.iv));
                ArrayList<String> strings=new ArrayList<String>();
                strings.add("");
                vImageWatcher.show((ImageView) findViewById(R.id.iv), imageGroupLis, strings);

            }
        });
    }
}
