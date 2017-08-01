package com.example.bighero.util;

import android.graphics.BlurMaskFilter;
import android.os.IInterface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RasterizerSpan;

/**
 * Created by spf on 2017/7/28.
 */

public class SpannableUtil {


////////////////////////////////////////////////////////////
//    BackgroundColorSpan : 文本背景色  EXCLUSIVE 不包括
//    ForegroundColorSpan : 文本颜色
//    MaskFilterSpan : 修饰效果，如模糊(BlurMaskFilter)浮雕
//    RasterizerSpan : 光栅效果
//    StrikethroughSpan : 删除线
//    SuggestionSpan : 相当于占位符
//    UnderlineSpan : 下划线
//    AbsoluteSizeSpan : 文本字体（绝对大小）
//    DynamicDrawableSpan : 设置图片，基于文本基线或底部对齐。
//    ImageSpan : 图片
//    RelativeSizeSpan : 相对大小（文本字体）
//    ScaleXSpan : 基于x轴缩放
//    StyleSpan : 字体样式：粗体、斜体等
//    SubscriptSpan : 下标（数学公式会用到）
//    SuperscriptSpan : 上标（数学公式会用到）
//    TextAppearanceSpan : 文本外貌（包括字体、大小、样式和颜色）
//    TypefaceSpan : 文本字体
//    URLSpan : 文本超链接
//    ClickableSpan : 点击事件
///////////////////////////////////////////////////////////////

    /**
     * 背景颜色
     *
     * @param str
     * @param color
     * @return
     */
    public static CharSequence getBackgroundColor(String str, int color) {
        SpannableString spannableString = new SpannableString(str);
        BackgroundColorSpan bgSpan = new BackgroundColorSpan(color);
        spannableString.setSpan(bgSpan, 1, str.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 文字颜色
     * @param str
     * @param color
     * @return
     */
    public static CharSequence getForegroundColorSpan(String str, int color) {
        SpannableString spannableString = new SpannableString(str);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
        spannableString.setSpan(colorSpan, 1, str.length() - 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 模糊
     * @param str
     * @return
     */
    public static CharSequence getMaskFilterSpan(String str){
        SpannableString spannableString = new SpannableString(str);
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL));
        spannableString.setSpan(maskFilterSpan, 1, str.length() - 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }




    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    ////


}
