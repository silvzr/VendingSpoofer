# ProGuard rules for an Xposed module

# Keep attributes for debugging and annotations
-keepattributes Signature,InnerClasses,EnclosingMethod,*Annotation*,SourceFile,LineNumberTable

# Keep Xposed framework classes and interfaces themselves, just in case.
-keep class de.robv.android.xposed.** { *; }
-keep interface de.robv.android.xposed.** { *; }

# Keep classes that implement Xposed interfaces
-keep public class * implements de.robv.android.xposed.IXposedMod
-keep public class * implements de.robv.android.xposed.IXposedHookLoadPackage
-keep public class * implements de.robv.android.xposed.IXposedHookZygoteInit
-keep public class * implements de.robv.android.xposed.IXposedHookCmdInit
-keep public class * implements de.robv.android.xposed.IXposedHookInitPackageResources

# Keep members of classes that implement Xposed interfaces (including constructors and methods)
-keepclassmembers public class * implements de.robv.android.xposed.IXposedMod { <init>(...); *; }
-keepclassmembers public class * implements de.robv.android.xposed.IXposedHookLoadPackage { <init>(...); *; }
-keepclassmembers public class * implements de.robv.android.xposed.IXposedHookZygoteInit { <init>(...); *; }
-keepclassmembers public class * implements de.robv.android.xposed.IXposedHookCmdInit { <init>(...); *; }
-keepclassmembers public class * implements de.robv.android.xposed.IXposedHookInitPackageResources { <init>(...); *; }

# The main hook class (com.risenid.caimanspoof.MainHook) and its members
# should be covered by the IXposedHookLoadPackage rules above.
# -keep public class com.risenid.caimanspoof.MainHook { <init>(...); *; } # Removed this explicit rule

# The xposed_init file is automatically included without ProGuard directives.
#-keepresourcefiles assets/xposed_init # removed due to R8 parsing issue

# Optional: Prevent warnings about Xposed classes if they occur.
-dontwarn de.robv.android.xposed.**

# Add any project specific ProGuard rules below if needed.
# For example, if you use reflection on other classes:
# -keep class com.example.MyClass { *; }