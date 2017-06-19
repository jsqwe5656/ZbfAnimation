package zbf.zbfanimation.evalutor;

import android.animation.TypeEvaluator;

/**
 * 自定义简单的求值
 * Created by zbf on 2017/6/19.
 */
public class MyEvalutor implements TypeEvaluator<Integer>
{
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue)
    {
        int startInt = startValue;
        return (int) (200 + startInt + fraction * (endValue - startInt));
    }

}
