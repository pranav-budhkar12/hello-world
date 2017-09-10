#include "ArrayHelper.h"


JNIEXPORT jdouble JNICALL Java_ArrayHelper_sumOf
  (JNIEnv* env, jclass, jdoubleArray entries)
{
	jdouble sum = 0;
	jint n = env->GetArrayLength(entries);
	jdouble* values = env->GetDoubleArrayElements(entries, NULL);

	for(jint i = 0; i < n; ++i)
		sum += values[i];
	env->ReleaseDoubleArrayElements(entries, values, JNI_ABORT);

	return sum;
}

JNIEXPORT void JNICALL Java_ArrayHelper_squareAll
  (JNIEnv* env, jclass, jdoubleArray entries)
{
	jint n = env->GetArrayLength(entries);
	jdouble* values = new jdouble[n];

	env->GetDoubleArrayRegion(entries, 0, n, values);
	for(jint i = 0; i < n; ++i)
		values[i] *= values[i];
	env->SetDoubleArrayRegion(entries, 0, n, values);
	delete[] values;
}

















