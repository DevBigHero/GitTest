package com.example.bighero;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by spf on 2017/6/6.
 */

public class PhoneTextWatcher implements TextWatcher {

    private EditText edt;
    StringBuilder sb;

    public PhoneTextWatcher(EditText edt) {
        this.edt = edt;
        sb = new StringBuilder();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s == null || s.length() == 0) return;

        if (sb.toString().equals(s.toString())) {
            return;
        }
        sb.delete(0, sb.length());
        String text = s.toString().replace(" ", "");
        for (int i = 0; i < text.length(); i++) {
            if (i == 3 || (i + 1) % 4 == 0) {
                sb.append(" ");
            }
            sb.append(text.charAt(i));
        }
        edt.setText(sb.toString());
        int index = 0;
        if (count > 0) {
            index = start + count;
            if (sb.charAt(start) == ' ') {
                index++;
            }
        } else if (before > 0) {
            index = start;
            if (start > 0 && s.charAt(start - 1) == ' ') {
                index--;
            }
        }
        if (index > 0 && index <= sb.length() + 1) {
            edt.setSelection(index);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
