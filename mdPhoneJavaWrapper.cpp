#include <jni.h>

#include "mdPhone.h"

class Utf8String {
	private:
		JNIEnv* env;
		const char* utf8Ptr;
		jstring jString;
	public:
		Utf8String(JNIEnv* jEnv,jstring str);
		~Utf8String();
		const char* GetUtf8Ptr();
};

Utf8String::Utf8String(JNIEnv* jEnv,jstring str) {
	env=jEnv;
	jString=str;
	if (jString!=0)
		utf8Ptr=env->GetStringUTFChars(jString,0);
	else
		utf8Ptr=0;
}

Utf8String::~Utf8String() {
	if (utf8Ptr!=0)
		env->ReleaseStringUTFChars(jString,utf8Ptr);
}

const char* Utf8String::GetUtf8Ptr() {
	if (utf8Ptr!=0)
		return utf8Ptr;
	return "";
}

jstring UnicodeString(JNIEnv* jEnv,const char* str) {
	if (str!=0)
		return jEnv->NewStringUTF(str);
	return jEnv->NewStringUTF("");
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdPhoneJNI_mdPhoneCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdPhone();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdPhoneJNI_mdPhoneDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdPhone*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdPhoneJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jint) ((mdPhone*) I)->Initialize(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetInitializeErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetInitializeErrorString());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdPhoneJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdPhone*) I)->SetLicenseString(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetDatabaseDate());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdPhoneJNI_Lookup(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring phone,jstring zip) {
	Utf8String _phone(jEnv,phone);
	Utf8String _zip(jEnv,zip);
	return (jboolean) ((mdPhone*) I)->Lookup(_phone.GetUtf8Ptr(),_zip.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdPhoneJNI_CorrectAreaCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring phone,jstring zip) {
	Utf8String _phone(jEnv,phone);
	Utf8String _zip(jEnv,zip);
	return (jboolean) ((mdPhone*) I)->CorrectAreaCode(_phone.GetUtf8Ptr(),_zip.GetUtf8Ptr());
}

extern "C" JNIEXPORT jdouble JNICALL Java_com_melissadata_mdPhoneJNI_ComputeDistance(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jdouble p1,jdouble p2,jdouble p3,jdouble p4) {
	return (jdouble) ((mdPhone*) I)->ComputeDistance((double) p1,(double) p2,(double) p3,(double) p4);
}

extern "C" JNIEXPORT jdouble JNICALL Java_com_melissadata_mdPhoneJNI_ComputeBearing(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I,jdouble p1,jdouble p2,jdouble p3,jdouble p4) {
	return (jdouble) ((mdPhone*) I)->ComputeBearing((double) p1,(double) p2,(double) p3,(double) p4);
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetAreaCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetAreaCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetNewAreaCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetNewAreaCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetPrefix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetPrefix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetSuffix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetSuffix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetExtension(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetExtension());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetCity(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetCity());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetState(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetState());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetCountyFips(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetCountyFips());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetCountyName(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetCountyName());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetMsa(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetMsa());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetPmsa(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetPmsa());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetTimeZone(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetTimeZone());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetTimeZoneCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetTimeZoneCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetCountryCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetCountryCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetLatitude(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetLatitude());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetLongitude(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetLongitude());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetDistance(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetDistance());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetResults(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetResults());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetResultCodeDescription(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring resultCode,jint opt) {
	Utf8String _resultCode(jEnv,resultCode);
	return UnicodeString(jEnv,((mdPhone*) I)->GetResultCodeDescription(_resultCode.GetUtf8Ptr(),(mdPhone::ResultCdDescOpt) opt));
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetStatusCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetStatusCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdPhoneJNI_GetErrorCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdPhone*) I)->GetErrorCode());
}

extern "C" JNIEXPORT jlong JNICALL Java_com_melissadata_mdGlobalPhoneJNI_mdGlobalPhoneCreate(JNIEnv* /*jEnv*/,jclass /*jCls*/) {
	return (jlong) new mdGlobalPhone();
}

extern "C" JNIEXPORT void JNICALL Java_com_melissadata_mdGlobalPhoneJNI_mdGlobalPhoneDestroy(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	delete (mdGlobalPhone*) I;
}

extern "C" JNIEXPORT jint JNICALL Java_com_melissadata_mdGlobalPhoneJNI_Initialize(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jint) ((mdGlobalPhone*) I)->Initialize(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetInitializeErrorString(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetInitializeErrorString());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdGlobalPhoneJNI_SetLicenseString(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring p1) {
	Utf8String _p1(jEnv,p1);
	return (jboolean) ((mdGlobalPhone*) I)->SetLicenseString(_p1.GetUtf8Ptr());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetLicenseExpirationDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetLicenseExpirationDate());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetBuildNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetBuildNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetDatabaseDate(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetDatabaseDate());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdGlobalPhoneJNI_Lookup(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring phone,jstring country,jstring origcountry) {
	Utf8String _phone(jEnv,phone);
	Utf8String _country(jEnv,country);
	Utf8String _origcountry(jEnv,origcountry);
	return (jboolean) ((mdGlobalPhone*) I)->Lookup(_phone.GetUtf8Ptr(),_country.GetUtf8Ptr(),_origcountry.GetUtf8Ptr());
}

extern "C" JNIEXPORT jboolean JNICALL Java_com_melissadata_mdGlobalPhoneJNI_LookupNext(JNIEnv* /*jEnv*/,jclass /*jCls*/,jlong I) {
	return (jboolean) ((mdGlobalPhone*) I)->LookupNext();
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetPhoneNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetPhoneNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetSubscriberNumber(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetSubscriberNumber());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetCountry(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetCountry());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetCountryCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetCountryCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetInternationalPrefix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetInternationalPrefix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetNationPrefix(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetNationPrefix());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetNationalDestinationCode(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetNationalDestinationCode());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetLanguage(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetLanguage());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetAdministrativeArea(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetAdministrativeArea());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetLocality(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetLocality());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetUTC(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetUTC());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetDST(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetDST());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetLatitude(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetLatitude());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetLongitude(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetLongitude());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetResults(JNIEnv* jEnv,jclass /*jCls*/,jlong I) {
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetResults());
}

extern "C" JNIEXPORT jstring JNICALL Java_com_melissadata_mdGlobalPhoneJNI_GetResultCodeDescription(JNIEnv* jEnv,jclass /*jCls*/,jlong I,jstring resultCode,jint opt) {
	Utf8String _resultCode(jEnv,resultCode);
	return UnicodeString(jEnv,((mdGlobalPhone*) I)->GetResultCodeDescription(_resultCode.GetUtf8Ptr(),(mdGlobalPhone::ResultCdDescOpt) opt));
}

