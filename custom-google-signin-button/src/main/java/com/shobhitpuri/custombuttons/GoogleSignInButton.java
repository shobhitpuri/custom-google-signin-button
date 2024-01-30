/*
 * MIT License
 *
 * Copyright (c) [2017] [Shobhit Puri]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.shobhitpuri.custombuttons;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.TypedValue;

import static com.shobhitpuri.custombuttons.util.Constants.BUTTON_TEXT_SIZE;

/**
 * This is a customized Google Sign In button. Supports:
 * - android:text - set text on button (not supported by com.google.android.gms.common.SignInButton)
 * - app:mIsDarkTheme - get both dark and light theme using this attribute.
 * <p>
 * Based on:
 * - Google guidelines details https://developers.google.com/identity/sign-in/android/custom-button
 * - Branding guidelines https://developers.google.com/identity/branding-guidelines#sign-in-button
 * <p>
 * Created by shobhit on 2017-09-11.
 */

public class GoogleSignInButton extends AppCompatButton {

    /**
     * Text that user wants the button to have.
     * This overrides the default "Sign in with Google" text.
     */
    private String mText;

    /**
     * Flag to show the dark theme with Google's standard dark blue color.
     */
    private boolean mIsDarkTheme;

    /**
     * Constructor
     *
     * @param context Context
     */
    public GoogleSignInButton(Context context) {
        super(context);
    }

    /**
     * Constructor
     *
     * @param context      Context
     * @param attributeSet AttributeSet
     */
    public GoogleSignInButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    /**
     * Constructor
     *
     * @param context      Context
     * @param attributeSet AttributeSet
     * @param defStyleAttr int
     */
    public GoogleSignInButton(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init(context, attributeSet, defStyleAttr);
    }

    /**
     * Initialize the process to get custom attributes from xml and set button params.
     *
     * @param context      Context
     * @param attributeSet AttributeSet
     */
    private void init(Context context, AttributeSet attributeSet, int defStyleAttr) {
        parseAttributes(context, attributeSet, defStyleAttr);
        setButtonParams();
    }

    /**
     * Parses out the custom attributes.
     *
     * @param context      Context
     * @param attributeSet AttributeSet
     */
    private void parseAttributes(Context context, AttributeSet attributeSet, int defStyleAttr) {
        if (attributeSet == null) {
            return;
        }

        // Retrieve styled attribute information from the styleable.
        TypedArray typedArray = context.getTheme().
                obtainStyledAttributes(attributeSet, R.styleable.ButtonStyleable, defStyleAttr, 0);

        try {
            // Get text which user wants to set the button.
            mText = typedArray.getString(R.styleable.ButtonStyleable_android_text);
            // Get the attribute to check if user wants dark theme.
            mIsDarkTheme = typedArray.getBoolean(R.styleable.ButtonStyleable_isDarkTheme, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * Set button parameters.
     */
    private void setButtonParams() {
        // We need not have only upper case character.
        this.setTransformationMethod(null);
        // Set button text
        setButtonText();
        // Set button text size
        setButtonTextSize();
        // Set button text color
        setButtonTextColor();
        // Set background of button
        setButtonBackground();
    }

    /**
     * Set the text size to standard as mentioned in guidelines.
     */
    private void setButtonTextSize() {
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, BUTTON_TEXT_SIZE);
    }

    /**
     * Check the theme and set background based on theme which is a selector.
     * The selector handles the background color when button is clicked.
     */
    private void setButtonBackground() {
        int googleIconImageSelector = mIsDarkTheme ? R.drawable.dark_theme_google_icon_selector :
                R.drawable.light_theme_google_icon_selector;
        this.setBackgroundResource(googleIconImageSelector);
    }

    /**
     * Check the theme and set text color based on theme.
     */
    private void setButtonTextColor() {
        int textColor = mIsDarkTheme ? android.R.color.white : R.color.text_color_dark;
        this.setTextColor(ContextCompat.getColor(getContext(), textColor));
    }

    /**
     * If user has set text, that takes priority else use default button text.
     */
    private void setButtonText() {
        if (mText == null || mText.isEmpty()) {
            mText = getContext().getString(R.string.google_sign_in);
        }
        this.setText(mText);
    }
}
