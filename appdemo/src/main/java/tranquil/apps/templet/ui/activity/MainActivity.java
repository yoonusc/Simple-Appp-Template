/*
 * Copyright 2015 Rudson Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tranquil.apps.templet.ui.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import tranquil.apps.model.HelpLiveo;
import tranquil.apps.interfaces.OnItemClickListener;
import tranquil.apps.interfaces.OnPrepareOptionsMenuLiveo;
import tranquil.apps.navigationliveo.NavigationLiveo;
import tranquil.apps.templet.R;
import tranquil.apps.templet.ui.fragment.MainFragment;
import tranquil.apps.templet.ui.fragment.Pro;
import tranquil.apps.templet.ui.fragment.ViewPagerFragment;
import tranquil.apps.templet.ui.fragment.contact;
import tranquil.apps.templet.ui.fragment.cul;
import tranquil.apps.templet.ui.fragment.spon;


public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {

        // User Information
        this.userName.setText("");
        this.userEmail.setText("");
        this.userPhoto.setImageResource(R.mipmap.jm);
        this.userBackground.setImageResource(R.drawable.dsd);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.abt), R.mipmap.ic_announcement_black_36dp);
        mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader
        mHelpLiveo.add(getString(R.string.Technical), R.mipmap.ic_build_black_36dp);
        mHelpLiveo.add(getString(R.string.Cultural), R.mipmap.soc);
        mHelpLiveo.add(getString(R.string.Proshow), R.mipmap.lf);
        mHelpLiveo.add(getString(R.string.News), R.mipmap.ic_assignment_black_36dp);
        mHelpLiveo.add(getString(R.string.Not), R.mipmap.ic_note_add_black_36dp);
        mHelpLiveo.add(getString(R.string.findus), R.mipmap.contact);
        mHelpLiveo.addSeparator();

        //{optional} - Header Customization - method customHeader
//        View mCustomHeader = getLayoutInflater().inflate(R.layout.custom_header_user, this.getListView(), false);
//        ImageView imageView = (ImageView) mCustomHeader.findViewById(R.id.imageView);

        with(this).startingPosition(1) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())

                //{optional} - List Customization "If you remove these methods and the list will take his white standard color"
                //.selectorCheck(R.drawable.selector_check) //Inform the background of the selected item color
                //.colorItemDefault(R.color.nliveo_blue_colorPrimary) //Inform the standard color name, icon and counter
                //.colorItemSelected(R.color.nliveo_purple_colorPrimary) //State the name of the color, icon and meter when it is selected
                //.backgroundList(R.color.nliveo_black_light) //Inform the list of background color
                //.colorLineSeparator(R.color.nliveo_transparent) //Inform the color of the subheader line

                //{optional} - SubHeader Customization
                .colorItemSelected(R.color.nliveo_blue_colorPrimary)
                .colorNameSubHeader(R.color.nliveo_blue_colorPrimary)
                //.colorLineSeparator(R.color.nliveo_blue_colorPrimary)

                .footerItem(R.string.settings, R.mipmap.ic_drafts_black_24dp)
                //.footerSecondItem(R.string.findus, R.mipmap.contact)

                //{optional} - Header Customization
                //.customHeader(mCustomHeader)

                //{optional} - Footer Customization
                //.footerNameColor(R.color.nliveo_blue_colorPrimary)
                //.footerIconColor(R.color.nliveo_blue_colorPrimary)
                //.footerBackground(R.color.nliveo_white)

                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
               // .setOnClickFooterSecond(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
        this.setElevationToolBar(position != 2 ? 15 : 0);
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment=null;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position) {
            case 2:
                mFragment = new ViewPagerFragment();
                break;
            case 3:
                mFragment = new cul();
                break;
            case 4:
                mFragment = new Pro();
                break;
            case 5:
                mFragment = new spon();
                break;
            case 6:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                closeDrawer();
                break;

            case 7:
                startActivity(new Intent(getApplicationContext(),location.class));
                closeDrawer();
                break;
            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                break;

        }
            if (mFragment != null) {
                mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            //Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
                Fragment mFragment;
                FragmentManager mFragmentManager = getSupportFragmentManager();
                mFragment = new contact();
                if (mFragment != null) {
                    mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
                }

            closeDrawer();

        }
    };
}

