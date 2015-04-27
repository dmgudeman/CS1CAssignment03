import java.text.NumberFormat;
import java.util.Locale;

//------------------------------------------------------
public class Foothill
{
   final static int MAT_SIZE = 3;
   
   public static void main(String[] args) throws Exception
   {
      int r, randRow, randCol;
      long startTime, stopTime;
      double randFrac;
      double smallPercent;
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);

      // non-sparse matrices
      double[][] mat, matAns;

//      mat = new double[MAT_SIZE][MAT_SIZE];
      double mat1[][] ={{1.0,2.0,},{2.0,3.0}};
            
    
      
      // generate small% of non-default values bet 0 and 1
//      smallPercent = MAT_SIZE/10. * MAT_SIZE;
////      for (r = 0; r < smallPercent; r++)
//      {
//         for(int k = 0; k <MAT_SIZE; k++ )
//            for (int j = 0; j <MAT_SIZE; j++)
//            {
//               double d = Math.random();
//               if (d < 01.0)
//                  mat[k][j] = Math.random();
//               else
//                  mat[k][j] = 0.00; 
//            }
//      }
//      
      
      matAns = new double[MAT_SIZE][MAT_SIZE];
      // 10x10 submatrix in lower right
//      matShow(mat, MAT_SIZE - 4, 10);
      matShow(mat1, 0 , MAT_SIZE);
      startTime = System.nanoTime();
      matMult(mat1, mat1, matAns);
      stopTime = System.nanoTime();

//      matShow(matAns, MAT_SIZE - 2, 10);
      matShow(matAns, 0 , MAT_SIZE);
      
      System.out.println("\nSize = " + MAT_SIZE + " Mat. Mult. Elapsed Time: "
         + tidy.format( (stopTime - startTime) / 1e9)
         + " seconds.");
   }
 // _______________________________________ 
   
   
   
   
   private static double[][] matMult(double[][] mat1, double[][] mat2, double [][] matAns)
   {
      for(int r = 0; r < mat1.length; r++)
      {   
         for(int c = 0; c < mat1.length; c++)
         {  double sum = 0.00, temp = 0.00;
            for(int x = 0; x < mat2.length; x++)
            {
              temp = mat1[r][x] * mat2[x][c];
               sum += temp;
            }
            matAns[r][c] = sum;
         }
        
      }
      
      
      
      
      return matAns;
   }
   
   
   private static void matShow(double [][] matAns, int matRow, int matCol)
   {   NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      for(int k = 0; k <matAns.length; k++ )
      {
         System.out.println("\n");
         for (int j = 0; j < matAns.length; j++)
         {
            
           // System.out.print(k +" " + j + "\t");
            System.out.print(tidy.format(matAns[k][j]) + "\t");
         }
      }
      System.out.println("\n\n");
   }
}

