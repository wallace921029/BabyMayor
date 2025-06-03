package com.example.babymayor.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun SwipeableItem() {
    val density = LocalDensity.current

    val state = rememberSwipeableState(initialValue = 0)
    val anchors = mapOf(
        0f to 0,
        with(density) { -(200.dp).toPx() } to 1
    )

    Box {
        Box(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 0.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(with(density) {
                            189.toDp()
                        })
                        .background(Color.Blue)
                ) {
                    Text("Edit")
                }
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(with(density) {
                            189.toDp()
                        })
                        .background(Color.Red),

                    ) {
                    Text("Delete")
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(2f)
                .swipeable(
                    state = state,
                    anchors = anchors,
                    orientation = Orientation.Horizontal
                )
                .offset {
                    IntOffset(state.offset.value.toInt(), 0)
                },
        ) {
            ListItem(

                headlineContent = {
                    Text("购物")
                },
                supportingContent = {
                    Text("买东西")
                },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSwipeableItem() {
    SwipeableItem()
}