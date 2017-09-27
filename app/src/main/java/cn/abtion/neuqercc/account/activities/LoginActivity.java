package cn.abtion.neuqercc.account.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.account.models.LoginRequest;
import cn.abtion.neuqercc.base.activities.NoBarActivity;
import cn.abtion.neuqercc.main.MainActivity;
import cn.abtion.neuqercc.network.APIResponse;
import cn.abtion.neuqercc.network.DataCallback;
import cn.abtion.neuqercc.network.RestClient;
import cn.abtion.neuqercc.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author abtion.
 * @since 17/9/22 17:59.
 * email caiheng@hrsoft.net
 */

public class LoginActivity extends NoBarActivity {

    @BindView(R.id.edit_register_name)
    TextInputEditText editRegisterName;
    @BindView(R.id.edit_register_password)
    TextInputEditText editRegisterPassword;
    @BindView(R.id.edit_password_confirmation)
    TextInputEditText editPasswordConfirmation;
    @BindView(R.id.edit_register_mail)
    TextInputEditText editRegisterMail;
    @BindView(R.id.edit_register_phone)
    TextInputEditText editRegisterPhone;
    @BindView(R.id.edit_school)
    TextInputEditText editSchool;
    @BindView(R.id.edit_captch)
    TextInputEditText editCaptch;



    private LoginRequest loginRequest;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariable() {
        loginRequest = new LoginRequest();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }


    /**
     * 登录按钮点击事件
     */
    @OnClick(R.id.btn_login)
    public void onBtnLoginClicked() {
        loginRequest.setRegisteName(editRegisterName.getText().toString().trim());
        loginRequest.setPasswordConfirm(editPasswordConfirmation.getText().toString().trim());
        loginRequest.setRegisteMail(editRegisterMail.getText().toString().trim());
        loginRequest.getRegistePhone(editRegisterPhone.getText().toString().trim());
        loginRequest.getRegisteSchool(editSchool.getText().toString().trim());
        loginRequest.getRegisteCaptch(editCaptch.getText().toString().trim());


        if (isDataTrue()) {
            login();
        }
    }

    /**
     * 进行登录的相关操作的方法
     */
    private void login() {
        //弹出progressDialog
        progressDialog.setMessage("请稍候");
        progressDialog.show();

        //网络请求
        RestClient.getService().login(loginRequest).enqueue(new DataCallback<APIResponse>() {

            //请求成功时回调
            @Override
            public void onDataResponse(Call<APIResponse> call, Response<APIResponse> response) {
                ToastUtil.showToast("登录成功");

                //跳转至MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }

            //请求失败时回调
            @Override
            public void onDataFailure(Call<APIResponse> call, Throwable t) {
            }

            //无论成功或者失败时都回调，用于dismissDialog或隐藏其他控件
            @Override
            public void dismissDialog() {
                if (progressDialog.isShowing()) {
                    disMissProgressDialog();
                }
            }
        });

    }

    /**
     * 用于TextInputEditText控件显示错误信息
     *
     * @param textInputEditText 控件对象
     * @param error             错误信息
     */
    private void showError(TextInputEditText textInputEditText, String error) {
        textInputEditText.setError(error);
        textInputEditText.setFocusable(true);
        textInputEditText.setFocusableInTouchMode(true);
        textInputEditText.requestFocus();
    }

    /**
     * 验证用户输入是否正确
     *
     * @return 正确为true
     */
    private boolean isDataTrue() {
        boolean flag = true;
        if(editRegisterName.getText().toString().trim().length()<6){
            showError(editRegisterName,"昵称不得少于6个字符");
            flag=false;
        }
        else if(editRegisterPassword.getText().toString().trim().length()<6){
            showError(editRegisterPassword,"密码不得少于六个字符");
            flag=false;
        }
        else if(editPasswordConfirmation.getText().toString().trim().length()!=editRegisterPassword.getText().toString().trim().length()){
            showError(editPasswordConfirmation,"两次输入的密码须一致");
            flag=false;
        }
        else if(editRegisterPhone.getText().toString().trim().length()<11){
            showError(editRegisterPhone,"手机号不得小于11位");
            flag=false;
        }
        else if(editCaptch.getText().toString().trim().length()==0){
            showError(editCaptch,"验证码不可为空");
            flag=false;
        }
        else if (editRegisterMail.getText().toString().trim().length()==0){
            showError(editRegisterMail,"邮箱不可为空");
            flag=false;
        }
        return flag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
