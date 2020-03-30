package com.example.sciencehub.components.smallInfoCard

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.gesture.PressGestureDetector
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.font
import androidx.ui.unit.dp

@Composable
fun SmallInfoCard(model: SmallInfoCardModel,
    onClick: ((SmallInfoCardModel) -> Unit)? = null
) {
    val layoutParams = SmallInfoCardLayoutParams()

    Card(
        modifier = LayoutWidth(width = SmallInfoCardLayoutParams.cardWidth)
                + LayoutHeight(height = SmallInfoCardLayoutParams.cardHeight) + LayoutPadding(all = 16.dp),
        elevation = layoutParams.elevation
    ) {
        PressGestureDetector(onRelease = {
            layoutParams.elevation = 8.dp
            onClick?.invoke(model)
        }, onPress = {
            layoutParams.elevation = 4.dp
        }) {
            Column {
                Text(
                    modifier = LayoutPadding(start = 16.dp, end = 16.dp) + LayoutWeight(weight = 1f),
                    text = model.title,
                    style = TextStyle(
                        fontWeight = FontWeight.W700,
                        color = Color.DarkGray
                    )
                )
                Text(
                    modifier = LayoutPadding(top = 2.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                    text = model.subtitle,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                )
            }
        }
    }
}