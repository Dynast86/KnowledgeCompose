package com.dynast.kin_eduwill.ui.main.view.home.event

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R

@Composable
fun EventWidget(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = stringResource(id = R.string.event),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            EventCardWidget(title = R.string.kar, image = R.drawable.img_house) {

            }
            EventCardWidget(title = R.string.official, image = R.drawable.img_rule) {

            }
            EventCardWidget(title = R.string.engineer, image = R.drawable.img_helmet) {

            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            EventCardWidget(type = EventType.Flat, title = R.string.random_vending_machine, image = R.drawable.img_random) {

            }
            EventCardWidget(type = EventType.Flat, title = R.string.free_charge, image = R.drawable.img_present) {

            }
        }
    }
}