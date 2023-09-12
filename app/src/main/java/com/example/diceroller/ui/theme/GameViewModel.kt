package com.example.diceroller.ui.theme

import androidx.lifecycle.ViewModel
import com.example.diceroller.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun updateGameUiState() {
        _uiState.update { uiState ->
            uiState.copy(
                imageRecourse = updateDice()
            )
        }
    }

    private fun updateDice() : Int {
        return diceRoll(roll = pickRandomNumber())
    }

    private fun diceRoll(roll: Int) : Int {
        val imageResource = when(roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return imageResource
    }

    private fun pickRandomNumber(): Int {
        return (1..6).random()
    }
}