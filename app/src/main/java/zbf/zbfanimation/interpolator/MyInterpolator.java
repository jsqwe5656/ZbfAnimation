package zbf.zbfanimation.interpolator;

import android.animation.TimeInterpolator;

/**
 * 自定义的插值器
 * Created by zbf on 2017/6/19.
 */
public class MyInterpolator implements TimeInterpolator
{
    /**
     *
     * @param input 代表了当前动画的进度
     * @return      表示动画的当前数值进度
     */
    @Override
    public float getInterpolation(float input)
    {
        return 1-input;
    }
}
