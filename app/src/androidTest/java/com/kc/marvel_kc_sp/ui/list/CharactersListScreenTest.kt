package com.kc.marvel_kc_sp.ui.list

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.kc.marvel_kc_sp.utils.Mocks
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class CharactersListTest {

    @get:Rule
    val composeRule = createComposeRule()


    // Sorry for not making more UI tests, but as you see this composable is easy to test as all
    // the functions are exposed here and can test its values, so testing others like favorites
    // should be easy enough, even the loadNextPage should be easy enough using performScrollTo
    @Test
    fun WHENnavigationClickedTHENnavigateTrue() {
        // Given
        var navigate = false
        composeRule.setContent {
            CharacterList(
                characters = Mocks.generateCharactersUI(8),
                favorites = Mocks.generateCharactersUI(12).filter { it.favorite },
                preview = true,
                totalItems = 8,
                clearDB = {},
                favoriteIt = {},
                navigateToDetail = { navigate = true },
                loadNextPage = {}
            )
        }
        // WHEN
        composeRule.onAllNodesWithTag("clickableCharacter").onFirst().performClick()
        // THEN
        Assert.assertTrue(navigate)
    }

    @Test
    fun WHENmenuClickedTHENmenuOpens() {
        // Given
        var clearClicked = false
        composeRule.setContent {
            CharacterList(
                characters = Mocks.generateCharactersUI(8),
                favorites = Mocks.generateCharactersUI(12).filter { it.favorite },
                preview = true,
                totalItems = 8,
                clearDB = { clearClicked = true },
                favoriteIt = {},
                navigateToDetail = {},
                loadNextPage = {}
            )
        }
        // THEN
        // ** for some reason it doesn't find it using contentDescription **
        composeRule.onNodeWithTag("clearDbEntry").assertDoesNotExist()
        // WHEN
        composeRule.onNodeWithContentDescription("Open menu").performClick()
        // THEN
        composeRule.onNodeWithTag("clearDbEntry").assertExists()
        // Maybe I should test this last two in a separate test, but...
        composeRule.onNodeWithTag("clearDbEntry").performClick()
        Assert.assertTrue(clearClicked)
    }
}