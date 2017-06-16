package zbf.zbfanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Android 动画Demo
 */
public class MainActivity extends AppCompatActivity
{
    TextView text;
    Animation anim_alpha, anim_scale, anim_translate, anim_rotate,anim_set;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        animInit();
    }

    /**
     * 初始化动画
     * 加载anim文件夹中的动画
     */
    private void animInit()
    {
//        anim_scale = AnimationUtils.loadAnimation(this,R.anim.demo_scale);
        anim_scale     = AnimationUtils.loadAnimation(this, R.anim.demo_scale2);
        anim_alpha     = AnimationUtils.loadAnimation(this, R.anim.demo_alpha);
        anim_rotate    = AnimationUtils.loadAnimation(this, R.anim.demo_rotate);
        anim_translate = AnimationUtils.loadAnimation(this, R.anim.demo_translate);
        anim_set       = AnimationUtils.loadAnimation(this,R.anim.demo_set);
    }

    /**
     * 点击事件
     * Android的animation由四种类型组成：
     * alpha（渐变透明度）
     * scale（渐变尺寸伸缩）
     * translate（画面转换位置移动）
     * rotate（画面转移旋转）
     * set  （动画合集）
     */
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_alpha:
                text.startAnimation(anim_alpha);
                break;

            case R.id.btn_scale:
                text.startAnimation(anim_scale);
                break;

            case R.id.btn_translate:
                text.startAnimation(anim_translate);
                break;

            case R.id.btn_rotate:
                text.startAnimation(anim_rotate);
                break;

            case R.id.btn_set:
                text.startAnimation(anim_set);
                break;

        }
    }


}
