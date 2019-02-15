package com.example.codeforcesclient;

import android.net.Uri;
import android.text.TextUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String string = "";
        Uri uri = new Uri.Builder().build();
        Assert.assertTrue(TextUtils.isEmpty(string));
        string = "dsa";
        Assert.assertFalse(TextUtils.isEmpty(string));
        assertEquals(4, 2 + 2);
    }
}