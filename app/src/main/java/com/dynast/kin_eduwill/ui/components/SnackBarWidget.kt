package com.dynast.kin_eduwill.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SnackBarWidget(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(18.dp))
            .padding(8.dp)
    ) {
        Surface(
            elevation = 8.dp,
            modifier = modifier.wrapContentSize(),
            shape = RoundedCornerShape(18.dp),
            color = Color.White
        ) {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = modifier
                        .clip(shape = CircleShape)
                        .background(Color(0xff2673F0))
                        .clickable { expanded = true }
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_snack_bar), contentDescription = null)
                }

//                        enter = fadeIn() + expandHorizontally(),
//                        exit = fadeOut() + shrinkHorizontally()

                AnimatedContent(
                    targetState = expanded,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(150, 150)) with
                                fadeOut(animationSpec = tween(150)) using
                                SizeTransform { initialSize, targetSize ->
                                    if (targetState) {
                                        keyframes {
                                            // Expand horizontally first.
                                            IntSize(targetSize.width, initialSize.height) at 150
                                            durationMillis = 300
                                        }
                                    } else {
                                        keyframes {
                                            // Shrink vertically first.
                                            IntSize(initialSize.width, targetSize.height) at 150
                                            durationMillis = 300
                                        }
                                    }
                                }

                    }
                ) { targetExpanded ->
                    Column(
                        Modifier.clickable { expanded = false }) {
                        if (targetExpanded) content()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SnackBarWidgetPreview() {
    Kin_eduwillTheme {
        SnackBarWidget {
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = "광고성 정보 수신에 동의하셨습니다.", fontSize = 13.sp)
                Text(text = "2022.08.24", fontSize = 13.sp)
            }
        }
    }
}

