package ir.androad.cannedfoods.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun CBOutlinedTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    error: String = "",
    style: TextStyle = TextStyle(
        color = MaterialTheme.colors.onBackground,
        fontSize = 14.sp,
        fontFamily = Yekanbakh,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Dp = 12.dp,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            shape = RoundedCornerShape(shape),
            maxLines = maxLines,
            textStyle = style,
            placeholder = {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = hint,
                    fontSize = 13.sp,
                    fontFamily = Yekanbakh,
                    fontWeight = FontWeight.Normal
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = BlackColor,
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = DisableColor,
                focusedLabelColor = PrimaryColor,
                unfocusedLabelColor = DisableColor
            ),
            leadingIcon = if (leadingIcon != null) {
                val icon: @Composable () -> Unit = {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_sms),
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier.size(25.dp)
                    )
                }
                icon
            } else null,
            trailingIcon = if(isPasswordToggleDisplayed) {
                val icon: @Composable () -> Unit = {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!isPasswordVisible)
                        },
                        modifier = Modifier
                            .semantics {
                                testTag = "Password Toggle"
                            }
                    ) {
                        Icon(
                            imageVector = if (isPasswordVisible) {
                                Icons.Outlined.Lock
                            } else {
                                Icons.Outlined.Lock
                            },
                            tint = Color.White,
                            contentDescription = if (isPasswordVisible) {
                                "Hide Password"
                            } else {
                                "Show Password"
                            }
                        )
                    }
                }
                icon
            } else null,
            modifier = modifier
                .fillMaxWidth()
                .semantics {
                    testTag = "Textfield with icon"
                }
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = style,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview
fun CBOutlinedTextFieldPreview() {
    CBOutlinedTextField(
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.icon_sms), contentDescription = "")
        },
        hint = "ایمیل خود را وارد نمائید...",
        singleLine = true,
        maxLines = 1,
        onValueChange = {}
    )
}

@Composable
fun CBFilledTextField() {
    val maxChar = 5
    Column {
        var textState by remember { mutableStateOf("") }
        val maxLength = 110
        val lightBlue = Color(0xffd8e6ff)
        val blue = Color(0xff76a9ff)
        Text(
            text = "Caption",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            color = blue
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) textState = it
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (textState.isNotEmpty()) {
                    IconButton(onClick = { textState = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )
        Text(
            text = "${textState.length} / $maxLength",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = blue
        )
    }
}

@Composable
@Preview
fun CBFilledTextFieldPreview() {
    CBFilledTextField()
}

@Composable
fun CBStandardTextField(
    modifier: Modifier = Modifier,
    title: String = "",
    height: Dp = 55.dp,
    value: String = "",
    placeholder: String = "",
    maxLength: Int? = 100,
    error: String = "",
    style: TextStyle = TextStyle(
        color = MaterialTheme.colors.onBackground,
        fontSize = 14.sp,
        fontFamily = Yekanbakh,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Dp = 12.dp,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        if (title.isNotEmpty()) {
            Text(
                text = title,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = BlackColor
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .semantics {
                    testTag = "Text field"
                },
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            shape = RoundedCornerShape(12.dp),
            maxLines = maxLines,
            textStyle = style,
            readOnly = readOnly,
            placeholder = {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = placeholder,
                    style = style
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = BlackColor,
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = style,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview
fun CBStandardTextFieldPreview() {
    CBStandardTextField(
        onValueChange = {},
        title = "عنوان"
    )
}