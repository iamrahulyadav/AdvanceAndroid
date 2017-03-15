package spinc.advandroideg.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by webwerks on 6/3/17.
 */

public class Utils {
    public static void showOrHideKeyBoard(Context mContext, View rootLayout  ) {
        InputMethodManager inputMethodManager =
                (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInputFromWindow(
                rootLayout.getApplicationWindowToken(),
                InputMethodManager.SHOW_FORCED, 0);
    }

    public static void showOrHideSoftKeyBoard(View editView, boolean show) {
        InputMethodManager imm = (InputMethodManager) editView.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (show) {
            imm.showSoftInput(editView, InputMethodManager.SHOW_FORCED);
        } else {
            imm.hideSoftInputFromWindow(editView.getWindowToken(), 0);

        }
        editView.setFocusable(true);
    }
}
