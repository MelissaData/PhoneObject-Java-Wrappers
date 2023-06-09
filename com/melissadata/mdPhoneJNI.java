package com.melissadata;

public class mdPhoneJNI {
	static {
		try {
			System.loadLibrary("mdPhoneJavaWrapper");
		} catch (UnsatisfiedLinkError ule) {
			System.out.println(ule);
			System.out.println("java.library.path="+System.getProperty("java.library.path"));
		}
	}

	public final static native long mdPhoneCreate();
	public final static native void mdPhoneDestroy(long I);
	public final static native int Initialize(long I,String p1);
	public final static native String GetInitializeErrorString(long I);
	public final static native boolean SetLicenseString(long I,String p1);
	public final static native String GetLicenseExpirationDate(long I);
	public final static native String GetBuildNumber(long I);
	public final static native String GetDatabaseDate(long I);
	public final static native boolean Lookup(long I,String phone,String zip);
	public final static native boolean CorrectAreaCode(long I,String phone,String zip);
	public final static native double ComputeDistance(long I,double p1,double p2,double p3,double p4);
	public final static native double ComputeBearing(long I,double p1,double p2,double p3,double p4);
	public final static native String GetAreaCode(long I);
	public final static native String GetNewAreaCode(long I);
	public final static native String GetPrefix(long I);
	public final static native String GetSuffix(long I);
	public final static native String GetExtension(long I);
	public final static native String GetCity(long I);
	public final static native String GetState(long I);
	public final static native String GetCountyFips(long I);
	public final static native String GetCountyName(long I);
	public final static native String GetMsa(long I);
	public final static native String GetPmsa(long I);
	public final static native String GetTimeZone(long I);
	public final static native String GetTimeZoneCode(long I);
	public final static native String GetCountryCode(long I);
	public final static native String GetLatitude(long I);
	public final static native String GetLongitude(long I);
	public final static native String GetDistance(long I);
	public final static native String GetResults(long I);
	public final static native String GetResultCodeDescription(long I,String resultCode,int opt);
	public final static native String GetStatusCode(long I);
	public final static native String GetErrorCode(long I);
}
