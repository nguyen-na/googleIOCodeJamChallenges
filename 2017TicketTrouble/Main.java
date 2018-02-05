import java.util.*;
import java.io.*;


public class Main
{

  public static void main(String[] args)
  {
    String filename = "C:\\Users\\natal\\Documents\\GitHub\\googleIOCodeJamChallenges\\2017TicketTrouble\\A-large-practice.in";
    String outputFile = "ticketTroubleOutput.txt";
    File file = new File(filename);
    PrintWriter writer = createPrintWriter(outputFile);
    Scanner in = createInputScannerForFile(file, filename);
    int t = in.nextInt();

    //Loop through each test case
    for(int i=1; i <= t; ++i)
    {
      int friends = in.nextInt();
      int sideLength = in.nextInt();
      int[][] ticketNumbers = new int[friends][2];
      int[] friendsPerRowPossible = new int [sideLength];

      //Initializes array of ticket numbers for group of friends in current case
      for (int j=0; j<friends;++j)
      {
        ticketNumbers[j][0] = in.nextInt();
        ticketNumbers[j][1] = in.nextInt();
      }

      //Counts how many friends could potentially be in each row
      for (int r=0; r<friends; ++r)
      {
        int posRowNum = 0;
            if(ticketNumbers[r][0]==ticketNumbers[r][1]) //prevents duplicates where a ticket has the same row and column
            {
              posRowNum = ticketNumbers[r][0];
              friendsPerRowPossible[posRowNum-1] += 1;
            }
            else
            {
              posRowNum = ticketNumbers[r][0];
              friendsPerRowPossible[posRowNum-1] += 1;
              posRowNum = ticketNumbers[r][1];
              friendsPerRowPossible[posRowNum-1] += 1;
            }
      }

      eliminateDuplicates(); //eliminates duplicates where two friends have tickets that are definitely the reverse of each other, i.e. (1,2) and (2,1) (see line 95)
      Arrays.sort(friendsPerRowPossible);,

      int maxSameRow = friendsPerRowPossible[sideLength-1]; //finds the row number that appeared the most frequently as a possibility for each friend
      writer.println("Case #" + i + ": " + maxSameRow);

    }
    writer.close();

  }

    //catches the exception for reading the input file
    private static Scanner createInputScannerForFile(File file, String filename)
    {
      Scanner scanner = null;

      try
      {
        scanner = new Scanner(new BufferedReader(new FileReader(file)));
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", filename);
        e.printStackTrace();
      }
      return scanner;
    }

    //catches the exception for creating a PrintWriter
    private static PrintWriter createPrintWriter(String name)
    {
      PrintWriter pw = null;
      try
      {
        pw = new PrintWriter(name, "UTF-8");
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to create PrintWriter");
        e.printStackTrace();
      }
      return pw;
    }

    //eliminates duplicates where two friends have tickets that are definitely the reverse of each other, i.e. (1,2) and (2,1) (see line 50)
    private static eliminateDuplicates();
    {
      for (int r=0; r<friends-1; ++r)
      {
        for (int a=1; a<(friends-r); ++a)
        {
          int duplicate = 0;
          if ((ticketNumbers[r][0] == ticketNumbers[r+a][0] && ticketNumbers[r][1] == ticketNumbers[r+a][1]) || (ticketNumbers[r][0] == ticketNumbers[r+a][1] && ticketNumbers[r][1] == ticketNumbers[r+a][0]))
          {
            duplicate = ticketNumbers[r][0];
            friendsPerRowPossible[duplicate-1] -= 1;
            duplicate = ticketNumbers[r][1];
            friendsPerRowPossible[duplicate-1] -= 1;
          }

        }
      }
    }

  }
