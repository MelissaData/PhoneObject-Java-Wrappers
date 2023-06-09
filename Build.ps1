# Set Java Includes and Phone Object Library Path
$JavaIncludeDirectory1 = "C:\Program Files\Java\jdk-20\include"
$JavaIncludeDirectory2 = "C:\Program Files\Java\jdk-20\include\win32"
$PhoneLibraryPath = $PSScriptRoot

# Run cl command
& 'cl' -I"$PhoneLibraryPath" -I"$JavaIncludeDirectory1" -I"$JavaIncludeDirectory2" -Fe'mdPhoneJavaWrapper.dll' 'mdPhoneJavaWrapper.cpp' -link -DLL -LIBPATH:"$PhoneLibraryPath" -DEFAULTLIB:'mdPhone.lib'

# Remove files
Remove-Item 'mdPhoneJavaWrapper.exp' -ErrorAction SilentlyContinue
Remove-Item 'mdPhoneJavaWrapper.obj' -ErrorAction SilentlyContinue
Remove-Item 'mdPhoneJavaWrapper.lib' -ErrorAction SilentlyContinue

