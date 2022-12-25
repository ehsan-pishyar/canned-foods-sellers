package ir.androad.cannedfoods.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.androad.cannedfoods.components.StandardProductItem
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.ui.theme.BackgroundColor

@Composable
fun FoodsScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
        ) {
            JetText(
                text = "محصولات فروشنده:",
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(PaddingValues(top = 10.dp))
                    .height(800.dp),
                columns = GridCells.Fixed(2),
                content = {
                    items(10) { item ->
                        StandardProductItem(navController = NavController(LocalContext.current))
                    }
                },
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            )
        }

    }
}

@Preview
@Composable
fun PreviewFoodsScreen(){
    FoodsScreen()
}