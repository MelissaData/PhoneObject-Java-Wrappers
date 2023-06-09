package com.melissadata;

public class mdGlobalPhoneJNI {
	static {
		try {
			System.loadLibrary("mdPhoneJavaWrapper");
		} catch (UnsatisfiedLinkError ule) {
			System.out.println(ule);
			System.out.println("java.library.path="+System.getProperty("java.library.path"));
		}
	}

	public final static native long mdGlobalPhoneCreate();
	public final static native void mdGlobalPhoneDestroy(long I);
	public final static native int Initialize(long I,String p1);
	public final static native String GetInitializeErrorString(long I);
	public final static native boolean SetLicenseString(long I,String p1);
	public final static native String GetLicenseExpirationDate(long I);
	public final static native String GetBuildNumber(long I);
	public final static native String GetDatabaseDate(long I);
	public final static native boolean Lookup(long I,String phone,String country,String origcountry);
	public final static native boolean LookupNext(long I);
	public final static native String GetPhoneNumber(long I);
	public final static native String GetSubscriberNumber(long I);
	public final static native String GetCountry(long I);
	public final static native String GetCountryCode(long I);
	public final static native String GetInternationalPrefix(long I);
	public final static native String GetNationPrefix(long I);
	public final static native String GetNationalDestinationCode(long I);
	public final static native String GetLanguage(long I);
	public final static native String GetAdministrativeArea(long I);
	public final static native String GetLocality(long I);
	public final static native String GetUTC(long I);
	public final static native String GetDST(long I);
	public final static native String GetLatitude(long I);
	public final static native String GetLongitude(long I);
	public final static native String GetResults(long I);
	public final static native String GetResultCodeDescription(long I,String resultCode,int opt);
}
