#include <jni.h>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char* argv[])
{
	if(argc < 2)
		return cout << "USAGE: " << argv[0] << " java-class-name"
					<< endl, 0;

	JavaVMInitArgs vmargs = {JNI_VERSION_1_6};
	JavaVM* jvm;
	JNIEnv* env;
	int err = JNI_CreateJavaVM(&jvm, reinterpret_cast<void**>(&env),
		&vmargs);
	if(err)
		return cout << "ERROR: Cannot create Java 1.6 VM" << endl, 1;

	jclass cls = env->FindClass(argv[1]);
	if(cls)
	{
		jmethodID idInvoke = env->GetStaticMethodID(cls, 
			"invoke", "(SLjava/lang/String;)I");
		if(idInvoke)
		{
			string input;
			cout << "INPUT : ";
			getline(cin, input);
			jstring text = env->NewStringUTF(input.c_str());
			jint result = env->CallStaticIntMethod(cls, idInvoke, 
				1, text);
			cout << "RESULT: " << result << endl;
		}
		else
			cout << "ERROR: No invoke method in java-class" << endl;
	}
	else
		cout << "ERROR: Cannot find java-class" << endl;

	jvm->DestroyJavaVM();
}















