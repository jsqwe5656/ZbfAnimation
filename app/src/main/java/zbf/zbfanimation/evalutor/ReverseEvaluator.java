package zbf.zbfanimation.evalutor;

import android.animation.TypeEvaluator;

/**
 * 另一个计算函数
 * Created by zbf on 2017/6/19.
 */
public class ReverseEvaluator implements TypeEvaluator<Integer>
{
    /**
     * 从终点出发 运动到起点
     */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue)
    {
        int startInt = startValue;
        return (int) (endValue - fraction * (endValue - startInt))*2;
    }
}
