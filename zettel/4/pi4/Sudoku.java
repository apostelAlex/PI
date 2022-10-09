public class Sudoku {
  /**
    * The 2-dimensional Sudoku-array.
  */
  static int[][] sudoku = {
      { 9, 8, 4, 2, 7, 6, 3, 1, 5 }, { 2, 5, 7, 1, 3, 8, 4, 9, 6 }, { 6, 1, 3, 9, 4, 5, 2, 7, 8 },
      { 4, 2, 9, 3, 6, 7, 8, 5, 1 }, { 5, 6, 1, 8, 2, 9, 7, 4, 3 }, { 3, 7, 8, 5, 1, 4, 6, 2, 9 },
      { 8, 3, 2, 7, 5, 1, 9, 6, 4 }, { 7, 4, 5, 6, 9, 3, 1, 8, 2 }, { 1, 9, 6, 4, 8, 2, 5, 3, 7 } };

  public static void printRow(int[] row){
    int count = 0;
    do {
      System.out.print(row[count]+ " ");
      if ((count+1) %3 == 0){
        System.out.print(" ");
      }
      count++;
    } while (count <9);
    System.out.println();
  }

  public static void printArray(){
    int count = 0;
    while(count < 9){
      printRow(sudoku[count]);
      if((count+1)%3 == 0){
        System.out.println();
      }
      count++;
    }
  }

  public static boolean check1To9(int[] toCheck){

    int temp;
    for(int i=0; i < 9; i++){
      for(int j=1; j < (9-i); j++){
        if(toCheck[j-1] > toCheck[j]){
          //swap elements
          temp = toCheck[j-1];
          toCheck[j-1] = toCheck[j];
          toCheck[j] = temp;
        }

      }}
      for(int i=1; i<=9; ++i){
      if(i != toCheck[i-1]){
        printRow(toCheck);
        return false;
      }
    }
    return true;
  }

  public static boolean testRows(){

    int[] row = new int[9];
    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++) {
        row[j] = sudoku[i][j];
      }
      if(!check1To9(row)){
        System.out.println("In Zeile "+(i+1)+" trat ein Fehler auf.");
        return false;

      }
    }
    return true;

  }

  public static boolean testCols(){

    int[] column = new int[9];
    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        column[j] = sudoku[j][i];

        }
      if(!check1To9(column)){
        System.out.println("In Zeile "+(i+1)+" trat ein Fehler auf."); // Gehört die Ausgabe zur Überprüfung dazu?
        // Denn laut 2e): Die Methode soll analog zur Methode aus Aufgabenteil d) die Spalten auf Korrektheit überprüfen.
        return false;
      }
    }
    return true;
  }


  public static boolean testSquares(){
    int[] square = new int[9];
    for(int zeile=0; zeile<3; zeile++){
      for(int spalte=0; spalte<3; spalte++){ // welche box

        for(int i=0; i<9; i++){
          int temp = i/3;
          square[i] = sudoku[zeile*3+temp][i%3+3*spalte];

        }
        if(!check1To9(square)){
          System.out.println("In Block "+zeile + ", " +spalte +" trat ein Fehler auf.");
          return false;
        }
      }
    }
    return true;
  }
  public static void testSolution(){
    boolean rows = testRows();
    boolean cols = testCols();
    boolean boxes = testSquares();
    System.out.println(rows&&cols ? cols&&boxes ? "Das Sudoku ist korrekt." : "Das Sudoku ist nicht korrekt." : "Das Sudoku ist nicht korrekt.");


  }
  public static void main(String[] args) {
    printArray();
    testSolution();
  }

}
