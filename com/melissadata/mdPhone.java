package com.melissadata;

public class mdPhone {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdPhone obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

	public final static class ProgramStatus {
		public final static mdPhone.ProgramStatus ErrorNone=new mdPhone.ProgramStatus("ErrorNone",0);
		public final static mdPhone.ProgramStatus ErrorOther=new mdPhone.ProgramStatus("ErrorOther",1);
		public final static mdPhone.ProgramStatus ErrorOutOfMemory=new mdPhone.ProgramStatus("ErrorOutOfMemory",2);
		public final static mdPhone.ProgramStatus ErrorRequiredFileNotFound=new mdPhone.ProgramStatus("ErrorRequiredFileNotFound",3);
		public final static mdPhone.ProgramStatus ErrorFoundOldFile=new mdPhone.ProgramStatus("ErrorFoundOldFile",4);
		public final static mdPhone.ProgramStatus ErrorDatabaseExpired=new mdPhone.ProgramStatus("ErrorDatabaseExpired",5);
		public final static mdPhone.ProgramStatus ErrorLicenseExpired=new mdPhone.ProgramStatus("ErrorLicenseExpired",6);

		private final String enumName;
		private final int enumValue;
		private static ProgramStatus[] enumValues={ErrorNone,ErrorOther,ErrorOutOfMemory,ErrorRequiredFileNotFound,ErrorFoundOldFile,ErrorDatabaseExpired,ErrorLicenseExpired};

		private ProgramStatus(String name,int val) {
			enumName=name;
			enumValue=val;
		}

		public static ProgramStatus toEnum(int val) {
			for (int i=0;i<enumValues.length;i++)
				if (enumValues[i].enumValue==val)
					return enumValues[i];
			throw new IllegalArgumentException("No enum "+ProgramStatus.class+" with value "+val+".");
		}

		public String toString() {
			return enumName;
		}

		public int toValue() {
			return enumValue;
		}
	}

	public final static class ResultCdDescOpt {
		public final static mdPhone.ResultCdDescOpt ResultCodeDescriptionLong=new mdPhone.ResultCdDescOpt("ResultCodeDescriptionLong",0);
		public final static mdPhone.ResultCdDescOpt ResultCodeDescriptionShort=new mdPhone.ResultCdDescOpt("ResultCodeDescriptionShort",1);

		private final String enumName;
		private final int enumValue;
		private static ResultCdDescOpt[] enumValues={ResultCodeDescriptionLong,ResultCodeDescriptionShort};

		private ResultCdDescOpt(String name,int val) {
			enumName=name;
			enumValue=val;
		}

		public static ResultCdDescOpt toEnum(int val) {
			for (int i=0;i<enumValues.length;i++)
				if (enumValues[i].enumValue==val)
					return enumValues[i];
			throw new IllegalArgumentException("No enum "+ResultCdDescOpt.class+" with value "+val+".");
		}

		public String toString() {
			return enumName;
		}

		public int toValue() {
			return enumValue;
		}
	}

	protected mdPhone(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdPhone() {
		this(mdPhoneJNI.mdPhoneCreate(),true);
	}

	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdPhoneJNI.mdPhoneDestroy(I);
			}
			I=0;
		}
	}

	public ProgramStatus Initialize(String p1) {
		return ProgramStatus.toEnum(mdPhoneJNI.Initialize(I,p1));
	}

	public String GetInitializeErrorString() {
		return mdPhoneJNI.GetInitializeErrorString(I);
	}

	public boolean SetLicenseString(String p1) {
		return mdPhoneJNI.SetLicenseString(I,p1);
	}

	public String GetLicenseExpirationDate() {
		return mdPhoneJNI.GetLicenseExpirationDate(I);
	}

	public String GetBuildNumber() {
		return mdPhoneJNI.GetBuildNumber(I);
	}

	public String GetDatabaseDate() {
		return mdPhoneJNI.GetDatabaseDate(I);
	}

	public boolean Lookup(String phone) {
		return mdPhoneJNI.Lookup(I,phone,"");
	}
	public boolean Lookup(String phone, String zip) {
		return mdPhoneJNI.Lookup(I,phone,zip);
	}

	public boolean CorrectAreaCode(String phone, String zip) {
		return mdPhoneJNI.CorrectAreaCode(I,phone,zip);
	}

	public double ComputeDistance(double p1, double p2, double p3, double p4) {
		return mdPhoneJNI.ComputeDistance(I,p1,p2,p3,p4);
	}

	public double ComputeBearing(double p1, double p2, double p3, double p4) {
		return mdPhoneJNI.ComputeBearing(I,p1,p2,p3,p4);
	}

	public String GetAreaCode() {
		return mdPhoneJNI.GetAreaCode(I);
	}

	public String GetNewAreaCode() {
		return mdPhoneJNI.GetNewAreaCode(I);
	}

	public String GetPrefix() {
		return mdPhoneJNI.GetPrefix(I);
	}

	public String GetSuffix() {
		return mdPhoneJNI.GetSuffix(I);
	}

	public String GetExtension() {
		return mdPhoneJNI.GetExtension(I);
	}

	public String GetCity() {
		return mdPhoneJNI.GetCity(I);
	}

	public String GetState() {
		return mdPhoneJNI.GetState(I);
	}

	public String GetCountyFips() {
		return mdPhoneJNI.GetCountyFips(I);
	}

	public String GetCountyName() {
		return mdPhoneJNI.GetCountyName(I);
	}

	public String GetMsa() {
		return mdPhoneJNI.GetMsa(I);
	}

	public String GetPmsa() {
		return mdPhoneJNI.GetPmsa(I);
	}

	public String GetTimeZone() {
		return mdPhoneJNI.GetTimeZone(I);
	}

	public String GetTimeZoneCode() {
		return mdPhoneJNI.GetTimeZoneCode(I);
	}

	public String GetCountryCode() {
		return mdPhoneJNI.GetCountryCode(I);
	}

	public String GetLatitude() {
		return mdPhoneJNI.GetLatitude(I);
	}

	public String GetLongitude() {
		return mdPhoneJNI.GetLongitude(I);
	}

	public String GetDistance() {
		return mdPhoneJNI.GetDistance(I);
	}

	public String GetResults() {
		return mdPhoneJNI.GetResults(I);
	}

	public String GetResultCodeDescription(String resultCode) {
		return mdPhoneJNI.GetResultCodeDescription(I,resultCode,0);
	}
	public String GetResultCodeDescription(String resultCode, mdPhone.ResultCdDescOpt opt) {
		return mdPhoneJNI.GetResultCodeDescription(I,resultCode,opt.toValue());
	}

	public String GetStatusCode() {
		return mdPhoneJNI.GetStatusCode(I);
	}

	public String GetErrorCode() {
		return mdPhoneJNI.GetErrorCode(I);
	}

}
