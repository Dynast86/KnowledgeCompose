package com.dynast.kin_eduwill.ui.main.view.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

private val roundedCornerShape = RoundedCornerShape(8.dp)

@Composable
fun CheckBoxWidget(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {
    Box(
        modifier = Modifier
            .clip(shape = CircleShape)
            .size(48.dp)
            .toggleable(
                value = checked, role = Role.Checkbox
            ) {
                if (onCheckedChange != null) onCheckedChange(it)
            }
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(roundedCornerShape)
                .then(
                    if (checked) {
                        Modifier.background(Color(0xff2673F0))
                    } else {
                        Modifier.border(width = 2.dp, color = Color(0xffCCCCD6), shape = roundedCornerShape)
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_check), contentDescription = "check",
                colorFilter = ColorFilter.tint(if (checked) Color.White else Color(0xffCCCCD6))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxWidgetPreview() {
    Kin_eduwillTheme {
        val isChecked = remember { mutableStateOf(true) }
        CheckBoxWidget(checked = isChecked.value) {
            isChecked.value != it
        }
    }
}