package com.heltonsilveira.jogodavelha.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameTest{

    private lateinit var game: Game
    private var player: Player? = null
    private var anotherPlayer: Player? = null

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Heider", "Android")
        player = game.player1
        anotherPlayer = game.player2
    }

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow1() {

        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }
    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow2() {

        val cell = Cell(player)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow3() {

        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun returnFalseIfHasThreeSameHorizontalCellsAtRow3() {

        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = null
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    fun endGameIfBoardIsFull() {
        val cell1 = Cell(player)
        val cell2 = Cell(player)
        val cell3 = Cell(anotherPlayer)
        val cell4 = Cell(anotherPlayer)
        val cell5 = Cell(player)
        val cell6 = Cell(player)
        val cell7 = Cell(player)
        val cell8 = Cell(anotherPlayer)
        val cell9 = Cell(anotherPlayer)
        game.cells[0][0] = cell1
        game.cells[0][1] = cell2
        game.cells[0][2] = cell3
        game.cells[1][0] = cell4
        game.cells[1][1] = cell5
        game.cells[1][2] = cell6
        game.cells[2][0] = cell7
        game.cells[2][1] = cell8
        game.cells[2][2] = cell9
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }



    @Test
    fun `return false if does not with other player `() {

        val cell = Cell(player)
        val another = Cell(anotherPlayer)

        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = another
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    fun `return true IfHasThree Same Vertical CellsAt collum one `() {

        val cell = Cell(player)
        val another = Cell(anotherPlayer)

        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameVerticallCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `return true IfHasThree Same Vertical CellsAt collum two `() {

        val cell = Cell(player)
        val another = Cell(anotherPlayer)

        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameVerticallCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `return true IfHasThree Same Vertical CellsAt collum three `() {

        val cell = Cell(player)
        val another = Cell(anotherPlayer)

        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameVerticallCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }

    @Test
    fun endGameIfHasThreeSameHorizontalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }


}