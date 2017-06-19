package zbf.zbfanimation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import zbf.zbfanimation.evalutor.CharEvaluator;
import zbf.zbfanimation.view.MyPointView;

/**
 * Android 动画Demo
 */
public class MainActivity extends AppCompatActivity
{
    TextView text;
    Animation anim_alpha, anim_scale, anim_translate, anim_rotate,anim_set;
    ValueAnimator animator;
    //自定义的圆
    MyPointView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        pointView = (MyPointView) findViewById(R.id.ponitview);
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
        valueAnimInit();
    }

    /**
     * 属性动画初始化
     */
    private void valueAnimInit()
    {
        //移动距离
//        animator = ValueAnimator.ofInt(0,600);
        //渐变颜色
//        animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        //插入自己写的可变换字母的动画。
        animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {

            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
//                int carValue = (int) animation.getAnimatedValue();
                char value = (char) animation.getAnimatedValue();
                Log.e("zbf",value + "");
//                Log.e("zbf",carValue + "");
//                text.layout(text.getLeft(),carValue,text.getRight(),carValue+text.getHeight());
//                text.setBackgroundColor(carValue);
                text.setText(String.valueOf(value));
            }
        });
        animator.setDuration(3000);
        //越来越快的插值器
        animator.setInterpolator(new AccelerateInterpolator());
/*        //使用默认的插值器
        animator.setInterpolator(new BounceInterpolator());*/
        //使用我自己的插值器
//        animator.setInterpolator(new MyInterpolator());
/*        //使用默认的求值函数 如果不设置默认加载这个
        animator.setEvaluator(new IntEvaluator());*/
        //从终点到起点
//        animator.setEvaluator(new MyEvalutor());
        //从起点到终点
//        animator.setEvaluator(new ReverseEvaluator());
        //设置渐变
//        animator.setEvaluator(new ArgbEvaluator());
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

            case R.id.btn_start:                            //开始包含插值器的动画
                animator.start();
                pointView.doPointAnim();
                break;

            case R.id.btn_cancle:
                animator.cancel();
                break;

        }
    }


}
