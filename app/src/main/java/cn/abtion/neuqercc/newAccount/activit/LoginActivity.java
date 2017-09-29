package cn.abtion.neuqercc.newAccount.activit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.base.activities.NoBarActivity;
import cn.abtion.neuqercc.main.MainActivity;
import cn.abtion.neuqercc.network.APIResponse;
import cn.abtion.neuqercc.network.DataCallback;
import cn.abtion.neuqercc.network.RestClient;
import cn.abtion.neuqercc.newAccount.models.LoginRequest;
import cn.abtion.neuqercc.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lszr on 2017/9/29.
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
    @BindView(R.id.btn_login)
    Button btnLogin;


    private LoginRequest loginRequest;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repeat_login;
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



    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginRequest.setName(editRegisterName.getText().toString().trim());
        loginRequest.setEmail(editRegisterMail.getText().toString().trim());
        loginRequest.setMobile(editRegisterPhone.getText().toString().trim());
        loginRequest.setPassword(editRegisterPassword.getText().toString().trim());
        loginRequest.setSchool(editSchool.getText().toString().trim());
        loginRequest.setPassword_confirmation(editPasswordConfirmation.getText().toString().trim());
        loginRequest.setCaptcha(editCaptch.getText().toString().trim());

        if(isDataTrue()){
            login();

        }
    }

    private void login() {
        progressDialog.setMessage("正在注册，请稍等");
        progressDialog.show();

        RestClient.getService().login(loginRequest).enqueue(new DataCallback<APIResponse>() {
            @Override
            public void onDataResponse(Call<APIResponse> call, Response<APIResponse> response) {
                ToastUtil.showToast("注册成功");


                Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                finish();

            }

            @Override
            public void onDataFailure(Call<APIResponse> call, Throwable t) {
                ToastUtil.showToast("注册失败");
            }

            @Override
            public void dismissDialog() {
                if(progressDialog.isShowing()){
                    disMissProgressDialog();
                }
            }
        });

    }


    private void showError(TextInputEditText textInputEditText,String error){
        textInputEditText.setError(error);
        textInputEditText.setFocusable(true);
        textInputEditText.setFocusableInTouchMode(true);
        textInputEditText.requestFocus();

    }

    private boolean isDataTrue(){
        boolean flag=true;
        if(editRegisterName.getText().toString().trim().length()<4){
            showError(editRegisterName,"注册字符不得少于4个");
            flag=false;
        }
        else if(editRegisterPassword.getText().toString().trim().length()<6){
            showError(editRegisterPassword,"密码不得少于6个字符");
            flag=false;
        }
        else if(!editPasswordConfirmation.getText().toString().trim().equals
                (editRegisterPassword.getText().toString().trim())){
            showError(editPasswordConfirmation,"两次输入的密码须一致");
            flag=false;
        }
        else if(editRegisterMail.getText().toString().length()==0){
            showError(editRegisterMail,"邮箱不得为空");
            flag=false;
        }
        else if(editRegisterPhone.getText().toString().trim().length()<11){
            showError(editRegisterPhone,"手机号码不得少于11位");
            flag=false;
        }
        else if(editCaptch.getText().toString().trim().length()==0){
            showError(editCaptch,"验证码不得为空");
            flag=false;
        }

        return flag;
    }




}
