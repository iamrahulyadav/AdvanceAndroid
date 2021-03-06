package spinc.advandroideg.mvp_pattern;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import spinc.advandroideg.R;
import spinc.advandroideg.mvp_pattern.base.BaseFragment;
import spinc.advandroideg.mvp_pattern.Login.LoginInterface;
import spinc.advandroideg.mvp_pattern.Login.LoginPresenter;
import spinc.advandroideg.utils.Utils;

/**
 * Created by webwerks on 15/2/17.
 */

public class LoginFragment extends BaseFragment implements LoginInterface, View.OnClickListener {

    public static final String TAG = "LoginFragment";

    public static final int EMAIL_FIELD = 2;
    public static final int PASSWORD_FIELD = 3;
    LinearLayout linearLayoutRootLogin;
    AppCompatEditText edittextEmail;
    TextInputLayout tilEmail;
    AppCompatEditText edittextPassword;
    TextInputLayout tilPassword;
    AppCompatButton buttonLogin;
    AppCompatButton buttonRegister;
    AppCompatTextView tvLoginHeader;
    private LoginPresenter loginPresenter;
    private View rootView;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenter(getActivity(), this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, rootView);

        initView(rootView);

        return rootView;
    }

    @Override
    protected void initView(View rootview) {
        linearLayoutRootLogin = (LinearLayout) rootView.findViewById(R.id.linearLayoutRootLogin);
        edittextEmail = (AppCompatEditText) rootView.findViewById(R.id.edittextEmail);
        tilEmail = (TextInputLayout) rootView.findViewById(R.id.tilEmail);
        edittextPassword = (AppCompatEditText) rootView.findViewById(R.id.edittextPassword);
        tilPassword = (TextInputLayout) rootView.findViewById(R.id.tilPassword);
        buttonLogin = (AppCompatButton) rootView.findViewById(R.id.buttonLogin);
        buttonRegister = (AppCompatButton) rootView.findViewById(R.id.buttonRegister);
        tvLoginHeader = (AppCompatTextView) rootview.findViewById(R.id.tvLoginHeader);
        setClicklistener();

    }

    @Override
    protected void setClicklistener() {
        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        tvLoginHeader.setOnClickListener(this);
    }


    @Override
    public void showProgress() {
        showProgressMain("Loading...");
    }

    @Override
    public void hideProgress() {
        hideProgressMain();
    }

    @Override
    public void showSnackbarMessage(String message, boolean isAction, String actionName) {
        showSnackBar(message);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void setLoginData(String loginData) {
        showSnackBar(loginData);
    }

    @Override
    public void setRegisterData(String registerData) {
        showSnackBar(registerData);
        ((MvpMainActivity) getActivity()).loadRegisterScreen();
    }

    @Override
    public void setEdittextError(int position, String message) {
        switch (position) {
            case EMAIL_FIELD:
                tilEmail.setEnabled(true);
                tilEmail.setError(message);
                break;
            case PASSWORD_FIELD:
                tilPassword.setEnabled(true);
                tilPassword.setError(message);
                break;
        }
    }

    void showSnackBar(String message) {
        Snackbar snackbar = Snackbar
                .make(linearLayoutRootLogin, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                loginPresenter.doLogin(edittextEmail.getText().toString().trim(), edittextPassword.getText().toString().trim());
                break;
            case R.id.buttonRegister:
                ((MvpMainActivity) getActivity()).loadRegisterScreen();
                break;
            case R.id.tvLoginHeader:
                Utils.showOrHideKeyBoard(getActivity(), linearLayoutRootLogin);
                break;
        }
    }
}
