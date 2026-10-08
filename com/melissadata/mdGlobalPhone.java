package com.melissadata;

public class mdGlobalPhone {
	private long I;
	protected boolean ownMemory;

	protected static long getI(mdGlobalPhone obj) {
		return (obj==null ? 0 : obj.I);
	}

	protected void finalize() {
		delete();
	}

	public final static class ProgramStatus {
		public final static mdGlobalPhone.ProgramStatus ErrorNone=new mdGlobalPhone.ProgramStatus("ErrorNone",0);
		public final static mdGlobalPhone.ProgramStatus ErrorOther=new mdGlobalPhone.ProgramStatus("ErrorOther",1);
		public final static mdGlobalPhone.ProgramStatus ErrorOutOfMemory=new mdGlobalPhone.ProgramStatus("ErrorOutOfMemory",2);
		public final static mdGlobalPhone.ProgramStatus ErrorRequiredFileNotFound=new mdGlobalPhone.ProgramStatus("ErrorRequiredFileNotFound",3);
		public final static mdGlobalPhone.ProgramStatus ErrorFoundOldFile=new mdGlobalPhone.ProgramStatus("ErrorFoundOldFile",4);
		public final static mdGlobalPhone.ProgramStatus ErrorDatabaseExpired=new mdGlobalPhone.ProgramStatus("ErrorDatabaseExpired",5);
		public final static mdGlobalPhone.ProgramStatus ErrorLicenseExpired=new mdGlobalPhone.ProgramStatus("ErrorLicenseExpired",6);

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
		public final static mdGlobalPhone.ResultCdDescOpt ResultCodeDescriptionLong=new mdGlobalPhone.ResultCdDescOpt("ResultCodeDescriptionLong",0);
		public final static mdGlobalPhone.ResultCdDescOpt ResultCodeDescriptionShort=new mdGlobalPhone.ResultCdDescOpt("ResultCodeDescriptionShort",1);

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

	protected mdGlobalPhone(long i,boolean own) {
		ownMemory=own;
		I=i;
	}

	public mdGlobalPhone() {
		this(mdGlobalPhoneJNI.mdGlobalPhoneCreate(),true);
	}

	public synchronized void delete() {
		if (I!=0) {
			if (ownMemory) {
				ownMemory=false;
				mdGlobalPhoneJNI.mdGlobalPhoneDestroy(I);
			}
			I=0;
		}
	}

	public ProgramStatus Initialize(String p1) {
		return ProgramStatus.toEnum(mdGlobalPhoneJNI.Initialize(I,p1));
	}

	public String GetInitializeErrorString() {
		return mdGlobalPhoneJNI.GetInitializeErrorString(I);
	}

	public boolean SetLicenseString(String p1) {
		return mdGlobalPhoneJNI.SetLicenseString(I,p1);
	}

	public String GetLicenseExpirationDate() {
		return mdGlobalPhoneJNI.GetLicenseExpirationDate(I);
	}

	public String GetBuildNumber() {
		return mdGlobalPhoneJNI.GetBuildNumber(I);
	}

	public String GetDatabaseDate() {
		return mdGlobalPhoneJNI.GetDatabaseDate(I);
	}

	public boolean Lookup(String phone) {
		return mdGlobalPhoneJNI.Lookup(I,phone,"","");
	}
	public boolean Lookup(String phone, String country) {
		return mdGlobalPhoneJNI.Lookup(I,phone,country,"");
	}
	public boolean Lookup(String phone, String country, String origcountry) {
		return mdGlobalPhoneJNI.Lookup(I,phone,country,origcountry);
	}

	public boolean LookupNext() {
		return mdGlobalPhoneJNI.LookupNext(I);
	}

	public String GetPhoneNumber() {
		return mdGlobalPhoneJNI.GetPhoneNumber(I);
	}

	public String GetSubscriberNumber() {
		return mdGlobalPhoneJNI.GetSubscriberNumber(I);
	}

	public String GetCountry() {
		return mdGlobalPhoneJNI.GetCountry(I);
	}

	public String GetCountryCode() {
		return mdGlobalPhoneJNI.GetCountryCode(I);
	}

	public String GetInternationalPrefix() {
		return mdGlobalPhoneJNI.GetInternationalPrefix(I);
	}

	public String GetNationPrefix() {
		return mdGlobalPhoneJNI.GetNationPrefix(I);
	}

	public String GetNationalDestinationCode() {
		return mdGlobalPhoneJNI.GetNationalDestinationCode(I);
	}

	public String GetLanguage() {
		return mdGlobalPhoneJNI.GetLanguage(I);
	}

	public String GetAdministrativeArea() {
		return mdGlobalPhoneJNI.GetAdministrativeArea(I);
	}

	public String GetLocality() {
		return mdGlobalPhoneJNI.GetLocality(I);
	}

	public String GetUTC() {
		return mdGlobalPhoneJNI.GetUTC(I);
	}

	public String GetDST() {
		return mdGlobalPhoneJNI.GetDST(I);
	}

	public String GetLatitude() {
		return mdGlobalPhoneJNI.GetLatitude(I);
	}

	public String GetLongitude() {
		return mdGlobalPhoneJNI.GetLongitude(I);
	}

	public String GetResults() {
		return mdGlobalPhoneJNI.GetResults(I);
	}

	public String GetResultCodeDescription(String resultCode) {
		return mdGlobalPhoneJNI.GetResultCodeDescription(I,resultCode,0);
	}
	public String GetResultCodeDescription(String resultCode, mdGlobalPhone.ResultCdDescOpt opt) {
		return mdGlobalPhoneJNI.GetResultCodeDescription(I,resultCode,opt.toValue());
	}

	public String GetPhoneType() {
		return mdGlobalPhoneJNI.GetPhoneType(I);
	}

}
