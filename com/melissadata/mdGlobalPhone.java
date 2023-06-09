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

public final static class AccessType {
	public final static mdGlobalPhone.AccessType Local=new mdGlobalPhone.AccessType("Local",0);
	public final static mdGlobalPhone.AccessType Remote=new mdGlobalPhone.AccessType("Remote",1);

	private final String enumName;
	private final int enumValue;
	private static AccessType[] enumValues={Local,Remote};

	private AccessType(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static AccessType toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+AccessType.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class DiacriticsMode {
	public final static mdGlobalPhone.DiacriticsMode Auto=new mdGlobalPhone.DiacriticsMode("Auto",0);
	public final static mdGlobalPhone.DiacriticsMode On=new mdGlobalPhone.DiacriticsMode("On",1);
	public final static mdGlobalPhone.DiacriticsMode Off=new mdGlobalPhone.DiacriticsMode("Off",2);

	private final String enumName;
	private final int enumValue;
	private static DiacriticsMode[] enumValues={Auto,On,Off};

	private DiacriticsMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static DiacriticsMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+DiacriticsMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class StandardizeMode {
	public final static mdGlobalPhone.StandardizeMode ShortFormat=new mdGlobalPhone.StandardizeMode("ShortFormat",0);
	public final static mdGlobalPhone.StandardizeMode LongFormat=new mdGlobalPhone.StandardizeMode("LongFormat",1);
	public final static mdGlobalPhone.StandardizeMode AutoFormat=new mdGlobalPhone.StandardizeMode("AutoFormat",2);

	private final String enumName;
	private final int enumValue;
	private static StandardizeMode[] enumValues={ShortFormat,LongFormat,AutoFormat};

	private StandardizeMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static StandardizeMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+StandardizeMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class SuiteParseMode {
	public final static mdGlobalPhone.SuiteParseMode ParseSuite=new mdGlobalPhone.SuiteParseMode("ParseSuite",0);
	public final static mdGlobalPhone.SuiteParseMode CombineSuite=new mdGlobalPhone.SuiteParseMode("CombineSuite",1);

	private final String enumName;
	private final int enumValue;
	private static SuiteParseMode[] enumValues={ParseSuite,CombineSuite};

	private SuiteParseMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static SuiteParseMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+SuiteParseMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class AliasPreserveMode {
	public final static mdGlobalPhone.AliasPreserveMode ConvertAlias=new mdGlobalPhone.AliasPreserveMode("ConvertAlias",0);
	public final static mdGlobalPhone.AliasPreserveMode PreserveAlias=new mdGlobalPhone.AliasPreserveMode("PreserveAlias",1);

	private final String enumName;
	private final int enumValue;
	private static AliasPreserveMode[] enumValues={ConvertAlias,PreserveAlias};

	private AliasPreserveMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static AliasPreserveMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+AliasPreserveMode.class+" with value "+val+".");
	}

	public String toString() {
		return enumName;
	}

	public int toValue() {
		return enumValue;
	}
}

public final static class AutoCompletionMode {
	public final static mdGlobalPhone.AutoCompletionMode AutoCompleteSingleSuite=new mdGlobalPhone.AutoCompletionMode("AutoCompleteSingleSuite",0);
	public final static mdGlobalPhone.AutoCompletionMode AutoCompleteRangedSuite=new mdGlobalPhone.AutoCompletionMode("AutoCompleteRangedSuite",1);
	public final static mdGlobalPhone.AutoCompletionMode AutoCompletePlaceHolderSuite=new mdGlobalPhone.AutoCompletionMode("AutoCompletePlaceHolderSuite",2);
	public final static mdGlobalPhone.AutoCompletionMode AutoCompleteNoSuite=new mdGlobalPhone.AutoCompletionMode("AutoCompleteNoSuite",3);

	private final String enumName;
	private final int enumValue;
	private static AutoCompletionMode[] enumValues={AutoCompleteSingleSuite,AutoCompleteRangedSuite,AutoCompletePlaceHolderSuite,AutoCompleteNoSuite};

	private AutoCompletionMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static AutoCompletionMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+AutoCompletionMode.class+" with value "+val+".");
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

public final static class MailboxLookupMode {
	public final static mdGlobalPhone.MailboxLookupMode MailboxNone=new mdGlobalPhone.MailboxLookupMode("MailboxNone",0);
	public final static mdGlobalPhone.MailboxLookupMode MailboxExpress=new mdGlobalPhone.MailboxLookupMode("MailboxExpress",1);
	public final static mdGlobalPhone.MailboxLookupMode MailboxPremium=new mdGlobalPhone.MailboxLookupMode("MailboxPremium",2);

	private final String enumName;
	private final int enumValue;
	private static MailboxLookupMode[] enumValues={MailboxNone,MailboxExpress,MailboxPremium};

	private MailboxLookupMode(String name,int val) {
		enumName=name;
		enumValue=val;
	}

	public static MailboxLookupMode toEnum(int val) {
		for (int i=0;i<enumValues.length;i++)
			if (enumValues[i].enumValue==val)
				return enumValues[i];
		throw new IllegalArgumentException("No enum "+MailboxLookupMode.class+" with value "+val+".");
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

	public String GetResultCodeDescription(String resultCode, mdGlobalPhone.ResultCdDescOpt opt) {
		return mdGlobalPhoneJNI.GetResultCodeDescription(I,resultCode,opt.toValue());
	}

}
