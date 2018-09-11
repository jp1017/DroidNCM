package io.bunnyblue.droidncm.finder;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import io.bunnyblue.droidncm.R;
import io.bunnyblue.droidncm.finder.dummy.NCMFileContent;
import io.bunnyblue.droidncm.finder.task.AboutFragment;
import io.bunnyblue.droidncm.finder.task.FileConvertTask;
import io.bunnyblue.droidncm.finder.task.NCMFileFinder;

public class MainFinderActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public NCMFileContent ncmFileContent = null;
    public AboutFragment aboutFragment = null;
    LocalFileFragment localFileFragment = new LocalFileFragment(ncmFileContent);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_finder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NCMFileFinder ncmFileFinder = new NCMFileFinder(MainFinderActivity.this);
                ncmFileFinder.execute(new File(Environment.getExternalStorageDirectory(), "netease"));
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.container, localFileFragment).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //  requestPermissions(new String[]{Androi});
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_finder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (ncmFileContent == null || ncmFileContent.getITEMS().isEmpty()) {
                Toast.makeText(this, "请先点击信封按钮扫描NCM格式的音乐！", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                doBatchConvert();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void doBatchConvert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("批量转换");
        builder.setMessage(String.format("共有 ncm文件 %s 个，转换请耐心等待⌛️", ncmFileContent.getITEMS().size()));
        builder.setPositiveButton("转换⌛", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FileConvertTask convertTask = new FileConvertTask(MainFinderActivity.this);

                convertTask.execute(ncmFileContent.getFiles());
            }
        }).create().show();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.importFile) {
            //  if (getSupportFragmentManager().getPrimaryNavigationFragment() != localFileFragment) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, localFileFragment).commit();
            //  }

            // Handle the camera action
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about) {
            //  if (getSupportFragmentManager().getPrimaryNavigationFragment() != aboutFragment) {
            if (aboutFragment == null) {
                aboutFragment = new AboutFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();

            //   }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // drawer.set
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateNCMFileList() {
        localFileFragment.updateFileList(ncmFileContent);


    }
}
