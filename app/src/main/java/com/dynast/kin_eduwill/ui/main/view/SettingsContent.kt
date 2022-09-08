package com.dynast.kin_eduwill.ui.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.main.view.settings.BenefitWidget
import com.dynast.kin_eduwill.ui.main.view.settings.LoginWidget
import com.dynast.kin_eduwill.ui.main.view.settings.NotificationWidget
import com.dynast.kin_eduwill.ui.main.view.settings.OneLineWidget

@Composable
fun SettingsContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item { LoginWidget(isLogin = false) }
        item { NotificationWidget(visible = true) }
        item { BenefitWidget(visible = true) }
        item {
            OneLineWidget(title = R.string.contact, trailing = { TrailingChevron() }) {
            }
        }
        item {
            OneLineWidget(title = R.string.app_version_info, trailing = {
                Text(text = "1.0.0", color = Color(0xff70707A))
            }) { }
        }
        item {
            OneLineWidget(title = R.string.terms, trailing = { TrailingChevron() }) {

            }
        }
        item {
            OneLineWidget(title = R.string.privacy, trailing = { TrailingChevron() }) {

            }
        }
    }
}

@Composable
fun TrailingChevron() = Image(
    painter = painterResource(id = R.drawable.ic_settings_chevron), contentDescription = stringResource(id = R.string.send),
    contentScale = ContentScale.Inside,
    colorFilter = ColorFilter.tint(Color(0xff70707A))
)

@Composable
fun switchColor() = SwitchDefaults.colors(
    checkedTrackColor = Color(0xff2673F0),
    uncheckedBorderColor = Color.Transparent,
    uncheckedTrackColor = Color(0xffAAAAB4),
    uncheckedThumbColor = Color.White
)