package com.adtracker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.adtracker.R;
import com.adtracker.fragment.ListaLojasFragment;
import com.adtracker.fragment.PagamentosFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FloatingActionButton fabAdd;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configComponentes();
        this.configTela();

    }

    private void configComponentes() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void configTela() {
        setSupportActionBar(toolbar);
        setContent(new ListaLojasFragment(), "Lojas");

        this.configDrawer();
        this.configAcoes();

    }

    private void configDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        navView.getMenu().getItem(0).setChecked(true);
    }

    private void configAcoes() {
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroLojaActivity.class));
            }
        });
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
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lista_anuncios) {
            setContent(new ListaLojasFragment(), "Lojas");
        } else if (id == R.id.nav_pagamentos) {
            setContent(new PagamentosFragment(), "Pagamentos");
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setContent(Fragment content, CharSequence title) {
        final FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.conteudo_activity, content);
        fragTransaction.commit();
        setTitle(title);
    }
}
