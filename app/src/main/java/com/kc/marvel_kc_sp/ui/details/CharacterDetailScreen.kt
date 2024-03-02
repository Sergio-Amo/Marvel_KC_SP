package com.kc.marvel_kc_sp.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.domain.model.SeriesUI
import com.kc.marvel_kc_sp.ui.components.AnimatedImage
import com.kc.marvel_kc_sp.ui.components.LazyRowSeries
import com.kc.marvel_kc_sp.utils.Mocks

@Composable
fun CharacterDetailScreen(id: Int, viewModel: DetailViewModel = hiltViewModel()) {
    val details by viewModel.detailsFlow.collectAsState()
    val series by viewModel.seriesFlow.collectAsState()

    LaunchedEffect(id) {
        viewModel.getFlows(id)
    }

    DetailList(details, series){
        viewModel.loadMore(details.id, series.last().page + 1)
    }
}

@Composable
fun DetailList(
    details: ListCharacterUI,
    series: List<SeriesUI>,
    preview: Boolean = false,
    loadMoreSeries: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //16:9 as the images requested
                    .aspectRatio(1.77777777778f),
            ) {
                AnimatedImage(
                    details.thumbnail, preview, modifier = Modifier
                        .fillMaxWidth()
                        //16:9 as the images requested
                        .aspectRatio(1.77777777778f), imageShape = RectangleShape
                )
                Text(
                    text = details.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(
                            Brush.verticalGradient(
                                0F to Color.Transparent,
                                .42F to Color.Black.copy(alpha = 0.65F),
                                1F to Color.Black
                            )
                        )
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 32.dp)
                )

            }

            if (series.isNotEmpty()) {
                Text(
                    text = "Series",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 28.dp)
                )
                LazyRowSeries(series = series, preview = preview){
                    loadMoreSeries()
                }
            }

            Text(
                text = details.description,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailList_Preview() {
    DetailList(
        Mocks.generateCharactersUI(1).first(),
        series = Mocks.generateSeriesUI(12),
        preview = true
    ){}
}