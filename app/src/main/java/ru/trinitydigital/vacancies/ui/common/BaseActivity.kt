package ru.trinitydigital.vacancies.ui.common

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import ru.trinitydigital.vacancies.R

abstract class BaseActivity : AppCompatActivity() {

    protected fun createDrawer(toolbar: Toolbar) {
        val header = createAccountHeader()
        val search = PrimaryDrawerItem().withName(R.string.search_ru).withIdentifier(1)
            .withIcon(R.drawable.ic_search_grey)
        val vacancies = PrimaryDrawerItem().withName(R.string.favorite_vacancies).withIdentifier(2)
            .withIcon(R.drawable.icon_favorite_drawable)
        val exit = PrimaryDrawerItem().withName(R.string.exit).withIdentifier(3)
            .withIcon(R.drawable.icon_exit)

        val drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withSelectedItem(-1)
            .withOnDrawerNavigationListener {
                onBackPressed()
                return@withOnDrawerNavigationListener true
            }
            .withAccountHeader(header)
            .addDrawerItems(
                search,
                vacancies,
                DividerDrawerItem(),
                exit
            )
            .build()


    }

    private fun createAccountHeader(): AccountHeader {
        return AccountHeaderBuilder()
            .withActivity(this)
            .addProfiles(
                ProfileDrawerItem()
                    .withName(R.string.name_header)
                    .withIcon(R.drawable.logo)
                    .withEmail("0.1")
            )
            .withHeaderBackground(R.drawable.background_drawer)
            .withAlternativeProfileHeaderSwitching(false)
            .withTranslucentStatusBar(true)
            .withAlternativeProfileHeaderSwitching(false)
            .build()

    }
}