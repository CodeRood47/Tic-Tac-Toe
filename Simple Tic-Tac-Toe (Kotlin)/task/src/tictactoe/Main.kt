package tictactoe

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    var xCounter = 0
    var oCounter = 0
    var endMessage = ""
    var gameState = mutableListOf(false, false, false, false, false, false, false, false, false)
    var dubWinCounter = 0
    var i = 0
    var j = 0
    var inputIndex = 0

    var playOn = true
    var player = 'X'

    val board: MutableList<MutableList<Char>> = MutableList(3) { MutableList(3) { ' ' } }
    println("---------")
    print("| ${board[0][0]} ${board[0][1]} ${board[0][2]} |")
    println()
    print("| ${board[1][0]} ${board[1][1]} ${board[1][2]} |")
    println()
    print("| ${board[2][0]} ${board[2][1]} ${board[2][2]} |")
    println()
    println("---------")
    var turns = 0
    do {
        var takeTurn = false



        print("> ")
        var placeX = readln().split(" ")


//        val inputList = input.toList()

//        board[0][0] = 'X'
//        board[0][1] = 'X'
//        board[0][2] = 'X'





//        while (i < 3) {
//            while (j < 3) {
//                board[i][j] = input[inputIndex]
//                j++
//                inputIndex++
//            }
//            i++
//            j = 0
//        }



        while (!takeTurn) {
             //placeX = readln().split(" ")
            if (placeX[0].toIntOrNull() == null || placeX[1].toIntOrNull() == null) {
                println("You should enter numbers!")
                placeX = readln().split(" ")

            } else if (placeX[0].toInt() !in 1..3 || placeX[1].toInt() !in 1..3) {
                println("Coordinates should be from 1 to 3!")
                placeX = readln().split(" ")

            } else if (board[placeX[0].toInt() - 1][placeX[1].toInt() - 1] == 'X' || board[placeX[0].toInt() - 1][placeX[1].toInt() - 1] == 'O') {
                println("This cell is occupied! Choose another one!")
                placeX = readln().split(" ")

            } else {
                board[placeX[0].toInt() - 1][placeX[1].toInt() - 1] = player
                takeTurn = true
                turns++
            }
        }

        println("---------")
        print("| ${board[0][0]} ${board[0][1]} ${board[0][2]} |")
        println()
        print("| ${board[1][0]} ${board[1][1]} ${board[1][2]} |")
        println()
        print("| ${board[2][0]} ${board[2][1]} ${board[2][2]} |")
        println()
        println("---------")


//        for (input in inputList) {
//            when (input) {
//                'X' -> xCounter++
//                'O' -> oCounter++
//            }
//        }

        gameState[0] = board[0][0] == player && board[0][1] == player && board[0][2] == player
        gameState[1] = board[1][0] == player && board[1][1] == player && board[1][2] == player
        gameState[2] = board[2][0] == player && board[2][1] == player && board[2][2] == player
        gameState[3] = board[0][0] == player && board[1][0] == player && board[2][0] == player
        gameState[4] = board[0][1] == player && board[1][1] == player && board[2][1] == player
        gameState[5] = board[0][2] == player && board[1][2] == player && board[2][2] == player
        gameState[6] = board[0][0] == player && board[1][1] == player && board[2][2] == player
        gameState[7] = board[0][2] == player && board[1][1] == player && board[2][0] == player
        for (win in gameState) {
            if (win) dubWinCounter++
        }



        if (gameState.any { it }) {
            endMessage = "$player wins"
            playOn = false
        } else if (turns == 9) {
            endMessage = "Draw"
            playOn = false
        }
        player = if(player == 'X'){
            'O'
        } else 'X'

    }while (playOn)

    println(endMessage)
}







