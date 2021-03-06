package com.jstarcraft.recommendation.evaluator.rating;

import java.util.Iterator;
import java.util.List;

import com.jstarcraft.ai.utility.Int2FloatKeyValue;
import com.jstarcraft.recommendation.evaluator.RatingEvaluator;

import it.unimi.dsi.fastutil.floats.FloatCollection;

/**
 * 平均绝对误差评估器
 * 
 * <pre>
 * MAE = Mean Absolute Error
 * </pre>
 *
 * @author Birdy
 */
public class MAEEvaluator extends RatingEvaluator {

	@Override
	protected float measure(FloatCollection checkCollection, List<Int2FloatKeyValue> recommendList) {
		float value = 0F;
		Iterator<Float> iterator = checkCollection.iterator();
		for (Int2FloatKeyValue keyValue : recommendList) {
			float score = iterator.next();
			float estimate = keyValue.getValue();
			value += Math.abs(score - estimate);
		}
		return value;
	}

}
