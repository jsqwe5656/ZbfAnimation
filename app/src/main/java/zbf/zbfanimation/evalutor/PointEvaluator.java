package zbf.zbfanimation.evalutor;

import android.animation.TypeEvaluator;

import zbf.zbfanimation.view.Point;

/**
 * 半径的插值器
 * Created by zbf on 2017/6/19.
 */
public class PointEvaluator implements TypeEvaluator<Point>
{
    @Override
    public Point evaluate(float v, Point point, Point t1)
    {
        int start = point.getValue();
        int end = t1.getValue();
        int curValue = (int) (start + v * (end-start));
        return new Point(curValue);
    }
}
