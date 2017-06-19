package zbf.zbfanimation.evalutor;

import android.animation.TypeEvaluator;

/**
 * 返回字符串的插值器
 * Created by zbf on 2017/6/19.
 */
public class CharEvaluator implements TypeEvaluator<Character>
{

    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue)
    {
        int startInt = (int) startValue;
        int endInt = (int) endValue;
        int curInt = (int) (startInt + fraction * (endInt - startInt));
        char result = (char) curInt;
        return result;
    }
}
