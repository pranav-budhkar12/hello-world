#include <jni.h>
#include <fcntl.h>
#include <sys/mman.h>

jint Java_NativeMethodTest_readShared(JNIEnv* env, jclass cls, jint index)
{
	static char* shared;

	if(shared == NULL)
	{
		int fdsm = shm_open("testshm", O_RDONLY, 0);
		if(fdsm == -1) return -1;
		shared = mmap(NULL, 4096, PROT_READ, MAP_SHARED, fdsm, 0);
	}

	return shared[index];
}













