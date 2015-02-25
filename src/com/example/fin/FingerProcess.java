package com.example.fin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * 闪烁着的指纹，用以表示录取进度
 * @author wangxianpeng
 * @since 2015-2-25
 */
public class FingerProcess extends FrameLayout {

	public static final int fp_imgs[] = new int[] {
			R.drawable.finger_mark_config_00, R.drawable.finger_mark_config_01,
			R.drawable.finger_mark_config_02, R.drawable.finger_mark_config_03,
			R.drawable.finger_mark_config_04, R.drawable.finger_mark_config_05 };

	public int mCurrentStep = 0;
	private View view;

	public FingerProcess(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public FingerProcess(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public FingerProcess(Context context) {
		super(context);
		init(context);
	}

	public void init(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.fingerprocess, this);
		twikcleImg(context,0);
	}

	public void twikcleImg(Context context,int step) {
		ImageView imageViewAbove = (ImageView) view.findViewById(R.id.id_img_above);
		ImageView imageViewBelow = (ImageView) view.findViewById(R.id.id_img_below);
		int imgAboveId;
		int imgBelowId;
		if (step < 5) {
			imgAboveId = fp_imgs[step + 1];
		    imgBelowId = fp_imgs[step];
			imageViewAbove.setImageResource(imgAboveId);
			imageViewBelow.setImageResource(imgBelowId);

			ObjectAnimator oa = ObjectAnimator.ofFloat(imageViewAbove, "alpha",1.0f, 0.0f);
			oa.setInterpolator(new DecelerateInterpolator());
			oa.setDuration(1200);
			oa.setRepeatMode(ObjectAnimator.INFINITE);
			oa.setRepeatCount(-1);

			oa.start();
		} else {
			imgAboveId = fp_imgs[5];
		    imgBelowId = fp_imgs[5];
			imageViewAbove.setImageResource(imgAboveId);
			imageViewBelow.setImageResource(imgBelowId);
		}
		

	}
}
