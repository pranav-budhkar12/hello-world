#include "StringHelper.h"


JNIEXPORT jint JNICALL Java_StringHelper_hashOf
  (JNIEnv* env, jclass, jstring text)
{
	jint hash = 0;
	jint n = env->GetStringLength(text);
	jboolean iscopy;
	const jchar* buffer = env->GetStringChars(text, &iscopy);

	for(jint i = 0; i < n; ++i)
		hash = buffer[i] + (hash << 6) + (hash << 16) - hash;
	env->ReleaseStringChars(text, buffer);

	return hash;
}

JNIEXPORT jstring JNICALL Java_StringHelper_reverseOf
  (JNIEnv* env, jclass, jstring text)
{
	jstring reversed;
	jint n = env->GetStringLength(text);
	jchar* buffer = new jchar[n];
	
	env->GetStringRegion(text, 0, n, buffer);
	for(jint i = 0, j = n - 1; i < j; ++i, j--)
	{
		char ic = buffer[i];
		char jc = buffer[j];
		buffer[i] = jc;
		buffer[j] = ic;
	}
	reversed = env->NewString(buffer, n);
	delete[] buffer;

	return reversed;
}































