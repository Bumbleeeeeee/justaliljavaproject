import java.util.*;

class ComputerPlayer{

  private final double[][] pawnPos = {
        {0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0},
        {5.0,  5.0,  5.0,  5.0,  5.0,  5.0,  5.0,  5.0},
        {1.0,  1.0,  2.0,  4.0,  4.0,  2.0,  1.0,  1.0},
        {0.5,  0.5,  1.0,  3.5,  3.5,  1.0,  0.5,  0.5},
        {0.5,  0.5,  1.0,  3.0,  3.0,  1.0,  0.5,  0.5},
        {0.5, -0.5, -1.0,  0.0,  0.0, -1.0, -0.5,  0.5},
        {0.5,  1.0, 1.0,  -2.0, -2.0,  1.0,  1.0,  0.5},
        {0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0}
      };
  private final double pawnValue = 10;

  private final double[][] rookPos = {   
      {0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0},
      {0.5,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5},
      {-0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
      {-0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
      {-0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
      {-0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
      {-0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
      {0.0,   0.0, 0.0,  0.5,  0.5,  0.0,  0.0,  0.0}
    };
  private final double rookValue = 50;
  
  private final double[][] knightPos = {
        {-5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0},
        {-4.0, -2.0,  0.0,  0.0,  0.0,  0.0, -2.0, -4.0},
        {-3.0,  0.0,  1.0,  1.5,  1.5,  1.0,  0.0, -3.0},
        {-3.0,  0.5,  1.5,  2.0,  2.0,  1.5,  0.5, -3.0},
        {-3.0,  0.0,  1.5,  2.0,  2.0,  1.5,  0.0, -3.0},
        {-3.0,  0.5,  1.0,  1.5,  1.5,  1.0,  0.5, -3.0},
        {-4.0, -2.0,  0.0,  0.5,  0.5,  0.0, -2.0, -4.0},
        {-5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0}
      };
  private final double knightValue = 30;

  private final double[][] bishopPos = {    
        {-2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0},
        {-1.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -1.0},
        {-1.0,  0.0,  0.5,  1.0,  1.0,  0.5,  0.0, -1.0},
        {-1.0,  0.5,  0.5,  1.0,  1.0,  0.5,  0.5, -1.0},
        {-1.0,  0.0,  1.0,  1.0,  1.0,  1.0,  0.0, -1.0},
        {-1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0, -1.0},
        {-1.0,  0.5,  0.0,  0.0,  0.0,  0.0,  0.5, -1.0},
        {-2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0}
      };
  private final double bishopValue = 35;

  private final double[][] queenPos = {
        {-2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0},
        {-1.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -1.0},
        {-1.0,  0.0,  0.5,  0.5,  0.5,  0.5,  0.0, -1.0},
        {-0.5,  0.0,  0.5,  0.5,  0.5,  0.5,  0.0, -0.5},
        {0.0,  0.0,  0.5,  0.5,  0.5,  0.5,  0.0, -0.5},
        {-1.0,  0.5,  0.5,  0.5,  0.5,  0.5,  0.0, -1.0},
        {-1.0,  0.0,  0.5,  0.0,  0.0,  0.0,  0.0, -1.0},
        {-2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0}
      };
  private final double queenValue = 90;
  
  private final double[][] kingPos = {
        {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
        {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
        {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
        {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
        {-2.0, -3.0, -3.0, -4.0, -4.0, -3.0, -3.0, -2.0},
        {-1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0},
        {2.0,  2.0,  0.0,  0.0,  0.0,  0.0,  2.0,  2.0 },
        {2.0,  3.0,  1.0,  0.0,  0.0,  1.0,  3.0,  2.0}};
  private final double kingValue = 1000;
  
  private Board board;
  private boolean wP;
  private int difficulty;

  public ComputerPlayer(Board hat, int difficulty, boolean wP) {
    board = hat;
    this.difficulty = difficulty;
    this.wP = wP;
  }

  public boolean getIsWhite(){
    return wP;
  }

  public void setIsWhite(boolean flag){
    this.wP = flag;
  }

 public void getMove() {
   //working levels: 0, 1, 2
   //planned levels:
      //0 - level baby, random chaos it'll be great >:D
      //1 - random move picker 
      //2 - evaluate based on best possible pos score, depth 1
   
      //3 - depth 3
      //4 - depth 5?
      //5+ - no plans for development- please just go play against professional chess engines for pete's sake
     if (wP == board.whiteT && difficulty != -1) {
        System.out.println("computer's turn");
        int[][] hat;
        if (difficulty == 0) hat = level0();
        else if (difficulty == 1) hat = level3();
        else if (difficulty == 2) hat = level4(2);
        else hat = level4(4);
        board.movePiece(hat[0], hat[1]);
     }
  }
  
  // baby
  public int[][] level0() {
    Verifier verify = new Verifier(Board.board, board.whiteT, board.lastMove);
    if (Math.random()*100 < 5 || checkStatus(board.getBoard(), board.whiteT, board.getLastMove()) != 0) {
      for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) {
        if (Math.random() * 3 < 1 || (Board.board[i][j] != null && Board.board[i][j].isWhite() != board.whiteT && verify.moveValid(new int[] {i, j}, verify.findKing(board.whiteT)))) {
          Board.board[i][j] = null;
        }
      }
    }
    ArrayList<int[]> pieces = getPieces(board.getBoard(), board.whiteT);
    int x = (int) (Math.random()*5) + 1;
    for (int a = 0; a < x; a++) {
      int[] frog = pieces.get((int)(Math.random()*pieces.size()));
      Board.board[(int)(Math.random()*8)][(int)(Math.random()*8)] = Board.board[frog[0]][frog[1]];
      Board.board[frog[0]][frog[1]] = null;
    }
    board.whiteT = !board.whiteT;
    return new int[][] {{0,0}, {0,0}};
  }

  
  //random moving
  public int[][] level1() {
    ArrayList<int[][]> moves = getPossibleMoves(board.getBoard(), board.whiteT, board.getLastMove());
    return moves.get((int)(Math.random()*moves.size()));
  }

  private ArrayList<int[]> getPieces(Piece[][] hat, boolean white) { 
    ArrayList<int[]> pieceLocations = new ArrayList<int[]>();
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (hat[i][j] != null && hat[i][j].isWhite() == white) pieceLocations.add(new int[] {i, j});
      }
    }
    return pieceLocations;
  }

  private ArrayList<int[][]> getPossibleMoves(Piece[][] b, boolean white, int[][] lastMove) {
    Verifier verify = new Verifier(b, white, lastMove);
    ArrayList<int[][]> moves = new ArrayList<int[][]>();
    ArrayList<int[]> pieces = getPieces(b, white);
    for (int i = 0; i < pieces.size(); i++) {
      for (int j = 0; j < 8; j++) {
        for (int k = 0; k < 8; k++) {
          int[] mto = {j, k};
          if (verify.moveValid(pieces.get(i), mto)) {
            moves.add(new int[][] {pieces.get(i), mto});
          }
        }
      }
    }
    return moves;
  }

  private Piece[][] copyBoard(Piece[][] hat) {
    Piece[][] b = new Piece[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        b[i][j] = hat[i][j] == null ? null : hat[i][j];
      }
    }
    return b;
  }

  private double calculatePosScore(Piece[][] hat, boolean isWhite, int[][] lastMove) {
    if (checkStatus(hat, isWhite, lastMove) == 2) {
        return -999999;
      } else if (checkStatus(hat, !isWhite, lastMove) == 2) {
      return 999999;
    }
      else if (checkStatus(hat, !isWhite, lastMove) == 3) return -1000;
    double score = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (hat[i][j] != null) {
          double val = 0;
          if (hat[i][j].getType().equals("P")) {
            if (hat[i][j].isWhite()) val += pawnPos[i][j];
            else val += pawnPos[7-i][7-j];
            val += pawnValue;
          } else if (hat[i][j].getType().equals("R")) {
            if (hat[i][j].isWhite()) val += rookPos[i][j];
            else val += rookPos[7-i][7-j];
            val += rookValue;
          } else if (hat[i][j].getType().equals("N")) {
            if (hat[i][j].isWhite()) val += knightPos[i][j];
            else val += knightPos[7-i][7-j];
            val += knightValue;
          } else if (hat[i][j].getType().equals("B")) {
            if (hat[i][j].isWhite()) val += bishopPos[i][j];
            else val += bishopPos[7-i][7-j];
            val += bishopValue;
          } else if (hat[i][j].getType().equals("Q")) {
            if (hat[i][j].isWhite()) val += queenPos[i][j];
            else val += queenPos[7-i][7-j];
            val += queenValue;
          } else {
            if (hat[i][j].isWhite()) val += kingPos[i][j];
            else val += kingPos[7-i][7-j];
            val += kingValue;
          }
          if (hat[i][j].isWhite() == isWhite) score += val;
          else score -= val;
        }
      }
    }
    return score;
  }

  
  public int[][] level2() {
    ArrayList<int[][]> moves = getPossibleMoves(board.getBoard(), board.whiteT, board.getLastMove());
    int indexBest = 0; double scoreBest = -99999;
    for (int i = 0; i < moves.size(); i++) {
      Piece[][] tree = copyBoard(board.getBoard());
      if (movePiece(tree, moves.get(i)[0], moves.get(i)[1], board.getLastMove(), board.whiteT, "Q")) {
        double x = calculatePosScore(tree, board.whiteT, moves.get(i));
        if (x >= scoreBest) {
          scoreBest = x; 
          indexBest = i;
        }
      }
    }
    //next line returns error occasionally, error is arraylist outofbounds, and it looks like the arraylist has size 0 :sob:
    return moves.get(indexBest);
  }

  public int[][] level3() {
    ArrayList<int[][]> moves = getPossibleMoves(board.getBoard(), board.whiteT, board.getLastMove());
    int indexBest = 0; double scoreBest = -99999;
    for (int i = 0; i < moves.size(); i++) {
      Piece[][] tree = copyBoard(board.getBoard());
      if (movePiece(tree, moves.get(i)[0], moves.get(i)[1], board.getLastMove(), board.whiteT, "Q")) {
        double x = evaluate(tree, board.whiteT, board.getLastMove(), 1, 4);//18 is okay at startgame, 4
        System.out.println(x);
        if (x >= scoreBest) {
          scoreBest = x; 
          indexBest = i;
        }
      }
    }
    
    return moves.get(indexBest);
  }

  public double evaluate(Piece[][] hat, boolean isWhite, int[][] lastMove, int iteration, int depth) {
    ArrayList<int[][]> moves = getPossibleMoves(hat, !isWhite, lastMove);
    int indexBest = 0; double scoreBest = -99999;
    for (int i = 0; i < moves.size(); i++) {
      Piece[][] tree = copyBoard(hat);
      if (movePiece(tree, moves.get(i)[0], moves.get(i)[1], lastMove, !isWhite, "Q")) {
        double x = calculatePosScore(tree, !isWhite, moves.get(i));
        if (x >= scoreBest) {
          scoreBest = x; 
          indexBest = i;
        }
      }
    }

    Piece[][] tree = copyBoard(hat);
    //check for endgame earlier
    if (moves.size() == 0) {
      if (checkStatus(tree, !isWhite, lastMove) == 2) {
        if (iteration % 2 == 1) return 9999*(100-iteration);
        else return -999999;
      } else if (checkStatus(tree, !isWhite, lastMove) == 3) return -1000;
    }
    movePiece(tree, moves.get(indexBest)[0], moves.get(indexBest)[1], lastMove, !isWhite, "Q");
    if (checkStatus(tree, !isWhite, lastMove) == 2) {
      System.out.println("endgame");
      if (iteration % 2 == 1) return 9999*(100-iteration);
      else return -999999;
    } else if (checkStatus(tree, !isWhite, lastMove) == 3) return -1000;
    if (iteration >= depth && iteration % 2 == 1) {
      return calculatePosScore(hat, isWhite, moves.get(indexBest));
    }
    return evaluate(tree, !isWhite, moves.get(indexBest), iteration + 1, depth);
  }

  
  public int checkStatus(Piece[][] bI, boolean wT, int[][] lastMove) {
    Verifier verify = new Verifier(bI, wT, lastMove);
    boolean inCheck = false;
    boolean canMove = false;
    inCheck = verify.checkforCheck(verify.findKing(wT), wT);

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (bI[i][j] != null && bI[i][j].isWhite() == wT) {
          Piece piece = bI[i][j];
          for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
              int[] start = {i, j}; int[] end = {a, b};
              if (verify.checkStage1(start, end, wT)) {
                bI[start[0]][start[1]] = null;
                Piece temp = bI[end[0]][end[1]];
                bI[end[0]][end[1]] = piece;
                if (verify.castling) {
                  if (end[1] == 2) {bI[end[0]][3] = bI[end[0]][0]; bI[end[0]][0] = null;}
                  else if (end[1] == 6) {bI[end[0]][5] = bI[end[0]][7]; bI[end[0]][7] = null;}}
                if (verify.enpassant) {
                  bI[start[0]][end[1]] = null;
                }
                if (!verify.checkforCheck(verify.findKing(wT), wT)) {
                  canMove = true;
                } 
                bI[start[0]][start[1]] = piece;
                bI[end[0]][end[1]] = temp;
                if (verify.castling) {
                  if (end[1] == 2) {bI[end[0]][0] = bI[end[0]][3]; bI[end[0]][3] = null;}
                  else if (end[1] == 6) {bI[end[0]][7] = bI[end[0]][5]; bI[end[0]][5] = null;}
    }
                if (verify.enpassant) {
      bI[start[0]][end[1]] = new Piece("P", !wT);
    }
              }
            }
          }
        }
      }
    }

    if (!inCheck && canMove) {
      return 0;
    } else if (inCheck && canMove) {
      return 1;
    } else if (inCheck && !canMove) {
      return 2;
    } else {
      return 3;
    }
  }

    public boolean movePiece(Piece[][] b, int[] start, int[] end, int[][] lastMove, boolean whiteT, String promote) {
    Verifier verify = new Verifier(b, whiteT, lastMove);
    Piece piece = b[start[0]][start[1]];
    if (!verify.moveValid(start, end)) {
      return false;
    }
    b[start[0]][start[1]] = null;
    b[end[0]][end[1]] = piece;
    if (verify.castling) {
      if (end[1] == 2) {b[end[0]][3] = b[end[0]][0]; b[end[0]][0] = null;}
      else if (end[1] == 6) {b[end[0]][5] = b[end[0]][7]; b[end[0]][7] = null;}
    }
    if (verify.enpassant) {
      b[start[0]][end[1]] = null;
    }
    
    if (piece.getType() == "P" && ((end[0] == 0 && piece.isWhite() == true) || (end[0] == 7 && piece.isWhite() == false))) {
      piece = new Piece(promote, whiteT);
    }
    return true;
  }



  public int[][] level4(int depth) {
    ArrayList<int[][]> moves = getPossibleMoves(board.getBoard(), board.whiteT, board.getLastMove());
    int indexBest = 0; double scoreBest = -99999;
    for (int i = 0; i < moves.size(); i++) {
      Piece[][] tree = copyBoard(board.getBoard());
      if (movePiece(tree, moves.get(i)[0], moves.get(i)[1], board.getLastMove(), board.whiteT, "Q")) {
        double x = minimax(tree, depth, -1000000, 1000000, moves.get(i), !board.whiteT, false);
        System.out.println(x);
        if (x >= scoreBest) {
          scoreBest = x; 
          indexBest = i;
        }
      }
    }
    return moves.get(indexBest);
  }
  
  private double minimax(Piece[][] game, int depth, double alpha, double beta, int[][] lastMove, boolean isWhite, boolean isMaximizingPlayer) {
  
    if (depth == 0) {
        return calculatePosScore1(game, !isWhite);
    }

    ArrayList<int[][]> moves = getPossibleMoves(game, isWhite, lastMove);

    if (isMaximizingPlayer) {
        double bestMove = -999999;
        for (int i = 0; i < moves.size(); i++) {
          Piece[][] tree = copyBoard(game);
          if (movePiece(tree, moves.get(i)[0], moves.get(i)[1], board.getLastMove(), isWhite, "Q")) {
            bestMove = Math.max(bestMove, minimax(tree, depth - 1, alpha, beta, moves.get(i), !isWhite, !isMaximizingPlayer));
            alpha = Math.max(alpha, bestMove);
            if (beta <= alpha) {
                return bestMove;
            }
          }
        }
        return bestMove;
    } else {
        double bestMove = 999999;
        for (var i = 0; i < moves.size(); i++) {

          Piece[][] tree = copyBoard(game);
          if (movePiece(tree, moves.get(i)[0], moves.get(i)[1], board.getLastMove(), isWhite, "Q")) {
            bestMove = Math.min(bestMove, minimax(tree, depth - 1, alpha, beta, moves.get(i), !isWhite, !isMaximizingPlayer));
            beta = Math.min(beta, bestMove);
            if (beta <= alpha) {
                return bestMove;
            }
          }
        }
        return bestMove;
    }
        
  }


  
  private double calculatePosScore1(Piece[][] hat, boolean isWhite) {
    double score = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (hat[i][j] != null) {
          double val = 0;
          if (hat[i][j].getType().equals("P")) {
            if (hat[i][j].isWhite()) val += pawnPos[i][j];
            else val += pawnPos[7-i][7-j];
            val += pawnValue;
          } else if (hat[i][j].getType().equals("R")) {
            if (hat[i][j].isWhite()) val += rookPos[i][j];
            else val += rookPos[7-i][7-j];
            val += rookValue;
          } else if (hat[i][j].getType().equals("N")) {
            if (hat[i][j].isWhite()) val += knightPos[i][j];
            else val += knightPos[7-i][7-j];
            val += knightValue;
          } else if (hat[i][j].getType().equals("B")) {
            if (hat[i][j].isWhite()) val += bishopPos[i][j];
            else val += bishopPos[7-i][7-j];
            val += bishopValue;
          } else if (hat[i][j].getType().equals("Q")) {
            if (hat[i][j].isWhite()) val += queenPos[i][j];
            else val += queenPos[7-i][7-j];
            val += queenValue;
          } else {
            if (hat[i][j].isWhite()) val += kingPos[i][j];
            else val += kingPos[7-i][7-j];
            val += kingValue;
          }
          if (hat[i][j].isWhite() == isWhite) score += val;
          else score -= val;
        }
      }
    }
    return score;
  }


  
}