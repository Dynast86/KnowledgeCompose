package com.dynast.kin_eduwill.ui.components

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldWidget(
    modifier: Modifier = Modifier,
    @StringRes hint: Int,
    onBackPress: () -> Unit
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var textState by remember { mutableStateOf(TextFieldValue()) }
    val actions = KeyboardActions(
        onSearch = {
            keyboardController?.hide()
            Toast.makeText(context, "검색중!!!!", Toast.LENGTH_SHORT).show()
        }
    )

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    IconButton(modifier = Modifier.padding(start = 4.dp),
        onClick = { onBackPress() }) {
        Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Back")
    }
    BasicTextField(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp)
            .focusRequester(focusRequester = focusRequester),
        value = textState,
        onValueChange = {
            textState = it
        },
        cursorBrush = SolidColor(Color(0xff2673F0)),
        decorationBox = { innerTextField ->
            if (textState.text.isEmpty()) {
                Text(text = stringResource(id = hint), color = Color(0xffAAAAB4))
            }
            innerTextField()
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = actions
    )
    if (textState.text.isNotEmpty()) {
        IconButton(onClick = { textState = TextFieldValue() }) {
            Icon(painter = painterResource(id = R.drawable.ic_close), contentDescription = "Close")
        }
    }

}