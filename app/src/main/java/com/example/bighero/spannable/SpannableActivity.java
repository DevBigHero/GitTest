package com.example.bighero.spannable;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.widget.TextView;

import com.example.bighero.BaseActivity;
import com.example.bighero.util.SpannableUtil;

/**
 * Created by spf on 2017/7/28.
 */

public class SpannableActivity extends BaseActivity {
////////////////////////////////////////////////////////////
//    BackgroundColorSpan : 文本背景色
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        setContentView(textView);
        CharSequence text = SpannableUtil.getMaskFilterSpan("宋鹏飞是个好同志！");
        textView.setText(text);


    }
}
