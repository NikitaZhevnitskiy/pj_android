package woact.android.zhenik.pj;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import woact.android.zhenik.pj.fragment.GroupFragment;
import woact.android.zhenik.pj.fragment.ProfileFragment;
import woact.android.zhenik.pj.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mContent;
    private FragmentManager fm;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    initProfileFragment();
                    return true;
                case R.id.navigation_dashboard:
                    initGroupFragment();
                    return true;
                case R.id.navigation_notifications:
                    initShopFragment();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mContent = (FrameLayout) findViewById(R.id.content);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm=getSupportFragmentManager();
        initProfileFragment();
    }

    private void initProfileFragment(){
        FragmentTransaction transaction = fm.beginTransaction();
        if (fm.findFragmentByTag(ProfileFragment.TAG)==null)
            transaction.replace(R.id.content, new ProfileFragment(), ProfileFragment.TAG);
        transaction.commit();
    }

    private void initGroupFragment(){
        FragmentTransaction transaction = fm.beginTransaction();
        if (fm.findFragmentByTag(GroupFragment.TAG)==null)
            transaction.replace(R.id.content, new GroupFragment(), GroupFragment.TAG);
        transaction.commit();
    }

    private void initShopFragment(){
        FragmentTransaction transaction = fm.beginTransaction();
        if (fm.findFragmentByTag(ShopFragment.TAG)==null)
            transaction.replace(R.id.content, new ShopFragment(), ShopFragment.TAG);
        transaction.commit();
    }

}
