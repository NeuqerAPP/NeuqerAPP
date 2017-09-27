package cn.abtion.neuqercc.main;

import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.base.activities.ToolBarActivity;
import cn.abtion.neuqercc.home.HomeFragment;
import cn.abtion.neuqercc.message.MessageFragment;
import cn.abtion.neuqercc.mine.MineFragment;
import cn.abtion.neuqercc.team.TeamFragment;
import cn.abtion.neuqercc.utils.ToastUtil;

public class MainActivity extends ToolBarActivity {


    @BindView(R.id.img_tab_menu_home)
    ImageView imgTabMenuHome;
    @BindView(R.id.txt_tab_menu_home)
    TextView txtTabMenuHome;
    @BindView(R.id.img_tab_menu_order)
    ImageView imgTabMenuOrder;
    @BindView(R.id.txt_tab_menu_order)
    TextView txtTabMenuTeam;
    @BindView(R.id.img_tab_menu_message)
    ImageView imgTabMenuMessage;
    @BindView(R.id.txt_tab_menu_message)
    TextView txtTabMenuMessage;
    @BindView(R.id.img_tab_menu_mine)
    ImageView imgTabMenuMine;
    @BindView(R.id.txt_tab_menu_mine)
    TextView txtTabMenuMine;

    private HomeFragment homeFragment;
    private TeamFragment teamFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariable() {
    }

    @Override
    protected void initView() {
        onLyTabMenuHomeClicked();
        getToolbar().setNavigationIcon(R.drawable.ic_nav);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ToastUtil.showToast("home");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void hideFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    private void showFragment(Fragment fragment) {
        hideAllFragment();
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.frame_main_container, fragment).commit();
    }

    private void hideAllFragment() {
        if (homeFragment != null) {
            hideFragment(homeFragment);
        }
        if (teamFragment != null) {
            hideFragment(teamFragment);
        }
        if (messageFragment != null) {
            hideFragment(messageFragment);
        }
        if (mineFragment != null) {
            hideFragment(mineFragment);
        }
    }

    /**
     * 清除选中状态
     */
    private void clearChoiceStatus() {
        txtTabMenuHome.setTextColor(getResources().getColor(R.color.subtitle));
        txtTabMenuTeam.setTextColor(getResources().getColor(R.color.subtitle));
        txtTabMenuMessage.setTextColor(getResources().getColor(R.color.subtitle));
        txtTabMenuMine.setTextColor(getResources().getColor(R.color.subtitle));

    }

    /**
     * 高亮Home
     */
    private void changeHomeMenuStatus() {
        clearChoiceStatus();
        txtTabMenuHome.setTextColor(getResources().getColor(R.color.white));
    }

    /**
     * 高亮Team
     */
    private void changeTeamMenuStatus() {
        clearChoiceStatus();
        txtTabMenuTeam.setTextColor(getResources().getColor(R.color.white));

    }

    /**
     * 高亮Message
     */
    private void changeMessageMenuStatus() {
        clearChoiceStatus();
        txtTabMenuMessage.setTextColor(getResources().getColor(R.color.white));

    }

    /**
     * 高亮Mine
     */
    private void changeMineMenuStatus() {
        clearChoiceStatus();
        txtTabMenuMine.setTextColor(getResources().getColor(R.color.white));
    }



    @OnClick(R.id.ly_tab_menu_home)
    public void onLyTabMenuHomeClicked() {
        changeHomeMenuStatus();
        hideAllFragment();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            addFragment(homeFragment);
        } else {
            showFragment(homeFragment);
        }
    }

    @OnClick(R.id.ly_tab_menu_order)
    public void onLyTabMenuOrderClicked() {
        changeTeamMenuStatus();
        hideAllFragment();
        if (teamFragment == null) {
            teamFragment = new TeamFragment();
            addFragment(teamFragment);
        } else {
            showFragment(teamFragment);
        }
    }

    @OnClick(R.id.ly_tab_menu_message)
    public void onLyTabMenuMessageClicked() {
        changeMessageMenuStatus();
        hideAllFragment();
        if (messageFragment == null) {
            messageFragment = new MessageFragment();
            addFragment(messageFragment);
        } else {
            showFragment(messageFragment);
        }
    }

    @OnClick(R.id.ly_tab_menu_mine)
    public void onLyTabMenuMineClicked() {
        changeMineMenuStatus();
        hideAllFragment();
        if (mineFragment == null) {
            mineFragment = new MineFragment();
            addFragment(mineFragment);
        } else {
            showFragment(mineFragment);
        }
    }
}
