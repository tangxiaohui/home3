﻿/* DO NOT EDIT THIS FILE - it is machine generated */
#include "SInclude.h"
#include "extern/ExternHead.h"
/* Header for class com_home_commonGame_extern_ExternMethodNative */

#ifndef _Included_com_home_commonGame_extern_ExternMethodNative
#define _Included_com_home_commonGame_extern_ExternMethodNative
#ifdef __cplusplus
extern "C" {
#endif

	//--tool--//


	/*
	 * Class:     com_home_commonTool_extern_ToolExternMethodNative
	 * Method:    exportNav
	 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
	 */
	JNIEXPORT void JNICALL Java_com_home_commonTool_extern_ToolExternMethodNative_exportNav
	(JNIEnv*, jclass, jstring, jstring, jstring);


	//--commonBase--//

	/*
	* Class:     com_home_commonBase_extern_ExternMethodNative
	* Method:    init
	* Signature: (Ljava/lang/String;)V
	*/
	JNIEXPORT void JNICALL Java_com_home_commonBase_extern_ExternMethodNative_init
	(JNIEnv*, jclass, jstring);

	/*
	* Class:     com_home_commonBase_extern_ExternMethodNative
	* Method:    registMap
	* Signature: (I[B)V
	*/
	JNIEXPORT void JNICALL Java_com_home_commonBase_extern_ExternMethodNative_registMap
	(JNIEnv*, jclass, jint, jbyteArray);

	/*
	 * Class:     com_home_commonBase_extern_ExternMethodNative
	 * Method:    createScene
	 * Signature: (I)J
	 */
	JNIEXPORT jlong JNICALL Java_com_home_commonBase_extern_ExternMethodNative_createScene
	(JNIEnv*, jclass, jint);

	/*
	 * Class:     com_home_commonBase_extern_ExternMethodNative
	 * Method:    removeScene
	 * Signature: (J)V
	 */
	JNIEXPORT void JNICALL Java_com_home_commonBase_extern_ExternMethodNative_removeScene
	(JNIEnv*, jclass, jlong);

	/*
	 * Class:     com_home_commonBase_extern_ExternMethodNative
	 * Method:    samplePosition
	 * Signature: (J[F[IFI)Z
	 */
	JNIEXPORT jboolean JNICALL Java_com_home_commonBase_extern_ExternMethodNative_samplePosition
	(JNIEnv*, jclass, jlong, jfloatArray, jintArray, jfloat, jint);

	JNIEXPORT jboolean JNICALL JavaCritical_com_home_commonBase_extern_ExternMethodNative_samplePosition
	(jlong, jint, jfloat*, jint, jint*, jfloat, jint);

	/*
	 * Class:     com_home_commonBase_extern_ExternMethodNative
	 * Method:    raycast
	 * Signature: (J[F[II)Z
	 */
	JNIEXPORT jboolean JNICALL Java_com_home_commonBase_extern_ExternMethodNative_raycast
	(JNIEnv*, jclass, jlong, jfloatArray, jintArray, jint);

	JNIEXPORT jboolean JNICALL JavaCritical_com_home_commonBase_extern_ExternMethodNative_raycast
	(jlong, jint, jfloat*, jint, jint*, jint);

	/*
	 * Class:     com_home_commonBase_extern_ExternMethodNative
	 * Method:    calculatePath
	 * Signature: (J[F[II)Z
	 */
	JNIEXPORT jboolean JNICALL Java_com_home_commonBase_extern_ExternMethodNative_calculatePath
	(JNIEnv*, jclass, jlong, jfloatArray, jintArray, jint);

	JNIEXPORT jboolean JNICALL JavaCritical_com_home_commonBase_extern_ExternMethodNative_calculatePath
	(jlong, jint, jfloat*, jint, jint*, jint);

#ifdef __cplusplus
}
#endif
#endif
