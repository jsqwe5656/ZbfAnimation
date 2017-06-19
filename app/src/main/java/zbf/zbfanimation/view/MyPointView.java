package zbf.zbfanimation.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import zbf.zbfanimation.evalutor.PointEvaluator;

/**
 *
 * Created by zbf on 2017/6/19.
 */
public class MyPointView extends View
{
    //半径
    private Point mCurPoint;

    public MyPointView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mCurPoint!=null)
        {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mCurPoint.getValue(),paint);
        }
    }

    /**
     * 执行动画
     */
    public void doPointAnim()
    {
        final ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(180));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator)
            {
                mCurPoint = (Point) animator.getAnimatedValue();
                //强制刷新
                invalidate();
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();

    }






}
