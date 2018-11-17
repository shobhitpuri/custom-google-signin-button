**Problem**
---
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Custom%20Google%20SignInButton-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7099)

You want to add a Google Sign-In button to your Android application. But you want to change the text on the Google Sign-In button or provide custom localization? You would think setting `android:text` on the `com.google.android.gms.common.SignInButton` in your layout file would do the trick. However it turns out that that attribute is not available for `SignInButton`. There are also issues like centering the text in the button. In the Google's `SignInButton`, the text is centered within the empty space next to the Google icon but not within the whole button.

**Solution**
---

This library helps you add text to Google Sign-In Button easily using standard `android:text` attribute. It also allows you to center the text in the button or set the button theme to dark or light using `app:isDarkTheme="true"` attribute. It does so following Google's guidelines to create sign-in button.

Light Theme (White)        |  Dark Theme (Blue)
:-------------------------:|:-------------------------:
![Google Sign-In Light](images/GoogleSignInLight.png)  |  ![Google Sign-In Dark](images/GoogleSignUpDark.png)


**Usage**
---

Add the following to your `app` module level `build.gradle` file:

    dependencies {
        // Please Note: If you are using Android Studio older than 3.0 or Gradle plugin older than 3.0, then use the `compile` keyword instead of `implementation`.
        implementation 'com.shobhitpuri.custombuttons:google-signin:1.1.0'
    }

In your XML Layout, have the following:

    <RelativeLayout
        ...
        xmlns:app="http://schemas.android.com/apk/res-auto">
        
        <com.shobhitpuri.custombuttons.GoogleSignInButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:text="@string/google_sign_up"
            app:centerTextInButton="false"
            app:isDarkTheme="true" />
    </RelativeLayout>


**Options**
---

- `android:text="{string}"`: As usual to set the text on the button.
- `app:isDarkTheme="{Boolean}"` : To switch between blue theme and gray white for the button. The library handles changing of text color and background color. It also handles the change of color on button press or button clicks.
- `app:centerTextInButton="{Boolean}"` : To center the text in the whole button. By default it is centered in within the emply space next to the Google icon.

**(dirty) Solutions**
---

On the Stackoverflow, there are obviously questions which have been asked for this issue. One of them is [Can I edit the text of sign in button on Google?](https://stackoverflow.com/questions/18040815/can-i-edit-the-text-of-sign-in-button-on-google) Many of them suggest using "hacks" like finding the first `TextView` in the button or finding any `TextView` in the button. The issue with them is they might stop working if Google updates the implementation. There are also questions like [How to center text in google sign in button android](https://stackoverflow.com/questions/41967615/how-to-center-text-in-google-sign-in-button-android), which are trying to deal with the issue of centering the text in whole button.

**Google's Suggestion**
---

From documentation, Google suggests creating a custom button as mentioned on [Customizing the Sign-In Button](https://developers.google.com/identity/sign-in/android/custom-button). Then it suggests using the branding guidelines as mentioned at [Sign-In Branding Guidelines](https://developers.google.com/identity/branding-guidelines#sign-in-button). It includes using custom icons and images int he button, setting text size to specifics, paddings and other do's and don'ts for the logo. 


Doing as per Google's suggestion involves some custom work. This small 3.93 KB library does that for you. Please feel free to make pull requests to improve the library. I wanted to create a re-usable solution when I came across this problem while implementing the Sign-In button. Just wanted to share with everyone.


**License**
---

    MIT License
    
    Copyright (c) 2018 Shobhit Puri

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
