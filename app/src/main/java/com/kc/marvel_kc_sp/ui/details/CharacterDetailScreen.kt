package com.kc.marvel_kc_sp.ui.details

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.kc.marvel_kc_sp.domain.model.ListCharacterUI
import com.kc.marvel_kc_sp.ui.components.AnimatedImage
import com.kc.marvel_kc_sp.utils.CharacterMocks

@Composable
fun CharacterDetailScreen(viewModel: DetailViewModel = hiltViewModel()) {
    val details by viewModel.detailsFlow.collectAsState()
    //val series by viewModel.seriesFlow.collectAsState()
    val scope = rememberCoroutineScope()

    DetailList(details)

}

@Composable
fun DetailList(
    details: ListCharacterUI,
    //series: TODO
    preview: Boolean = false,
) {
    AnimatedImage(
        details.thumbnail,
        preview,
        modifier = Modifier
            .fillMaxWidth()
            //16:9 as the images requested
            .aspectRatio(1.77777777778f)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetailList_Preview() {
    DetailList(
        CharacterMocks.generateCharactersUI(1).first(),
        preview = true
    )
}