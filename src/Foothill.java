import java.text.NumberFormat;
import java.util.Locale;

//------------------------------------------------------
public class Foothill
{
   final static int MAT_SIZE = 3200;

   public static void main(String[] args) throws Exception
   {
      long startTime, stopTime;
      double smallPercent;
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);

      // non-sparse matrices
      double[][] mat, matAns;

      mat = new double[MAT_SIZE][MAT_SIZE];

      // generate small% of non-default values bet 0 and 1
      smallPercent = 0.01;
      {
         for (int k = 0; k < MAT_SIZE; k++)
            for (int j = 0; j < MAT_SIZE; j++)
            {
               double d = Math.random();
               if (d < smallPercent)
                  mat[k][j] = Math.random();
               else
                  mat[k][j] = 0.00;
            }
      }

      matAns = new double[MAT_SIZE][MAT_SIZE];

      matShow(mat, 0, 10);
      startTime = System.nanoTime();
      matMult(mat, mat, matAns);
      stopTime = System.nanoTime();

      matShow(matAns, 0, 10);

      System.out.println("\nSize = " + MAT_SIZE + " Mat. Mult. Elapsed Time: "
            + tidy.format((stopTime - startTime) / 1e9) + " seconds.");
   }

   // _______________________________________ 
   
   
   
   
   private static double[][] matMult(double[][] mat1, double[][] mat2, 
         double [][] matAns)
   {
      if( mat1.length != mat2.length || mat2.length != matAns.length || 
            mat1.length != matAns.length )
      {
         throw new IndexOutOfBoundsException();
      }
      for(int r = 0; r < mat1.length; r++)
      {   
         for(int c = 0; c < mat1.length; c++)
         { 
            double sum = 0.00, temp = 0.00;
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
    
   private static void matShow(double[][] matAns, int start, int size)
   {
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      if (size < matAns.length)
      {
         for (int k = 0; k < size - start; k++)
         {
            System.out.println("\n");
            for (int j = 0; j < size - start; j++)
            {
               System.out.print(tidy.format(matAns[k][j]) + "\t");
            }
         }
         System.out.println("\n\n");
      }
   }
 
 }

