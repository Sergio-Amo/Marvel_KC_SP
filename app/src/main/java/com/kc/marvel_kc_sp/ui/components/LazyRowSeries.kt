package com.kc.marvel_kc_sp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.marvel_kc_sp.domain.model.SeriesUI
import com.kc.marvel_kc_sp.utils.Mocks


@Composable
fun LazyRowSeries(
    series: List<SeriesUI>,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
    loadMoreSeries: () -> Unit,
) {
    val state = rememberLazyListState()
    LazyRow(
        state = state,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val size = series.size
        items(size) { idx ->
            SeriesPortraitItem(series[idx], preview = preview)
            if (idx == size - 5)
                loadMoreSeries()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LazyRowSeries_Preview() {
    LazyRowSeries(Mocks.generateSeriesUI(8), true){}
}

@Composable
fun SeriesPortraitItem(
    series: SeriesUI,
    preview: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            //As the images requested
            .width(96.dp)
            .height(200.dp)
    ) {

        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.666666666667f)
        ) {
            val image = series.thumbnail.replace("landscape_incredible", "portrait_incredible")
            AnimatedImage(
                image, preview,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(CardDefaults.shape)
                    .aspectRatio(0.666666666667f)
                    .height(200.dp)
                    .weight(0.1f)
            )
        }
        Text(
            text = series.title,
            color = Color.White,
            fontSize = 13.sp,
            minLines = 2,
            maxLines = 2,
            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 8.dp)
        )
    }
}

@Preview
@Composable
private fun SeriesPortraitItem_Preview() {
    SeriesPortraitItem(Mocks.generateSeriesUI(1).first(), preview = true)
}