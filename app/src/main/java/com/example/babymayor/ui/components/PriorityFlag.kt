package com.example.babymayor.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PriorityFlag(priority: Int) {
    // color scheme
    val flagColor = when (priority) {
        1 -> Color(0xFFEF9A9A) // Light Red
        2 -> Color(0xFFFFE082) // Soft Yellow
        3 -> Color(0xFFA5D6A7) // Light Green
        else -> Color(0xFFB0BEC5) // Light Gray
    }

    Box(
        modifier = Modifier
            .width(width = 25.dp)
            .height(height = 25.dp)
            .border(width = 1.dp, color = flagColor, shape = CircleShape),
        contentAlignment = Alignment.Center

    ) {

        Icon(
            modifier = Modifier.padding(all = 2.5.dp),
            imageVector = Icons.Filled.Flag,
            contentDescription = "Priority",
            tint = flagColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPriorityFlag() {
    PriorityFlag(priority = 1)
}