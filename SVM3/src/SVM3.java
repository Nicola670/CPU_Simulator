
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author nicol
 */
public class SVM3
{

    public static int[] R = new int[11]; //array dei registri
    public static int[] L = new int[22]; //array dei label
    public static int C; //flag del confronto
    //------------------------------------------------------------------------------

    public static void visualizza(String[][] m)
    {
        int i, j;
        System.out.print("----------------------------------------");
        for (i = 0; i < m.length; i++)
        {
            System.out.println();
            for (j = 0; j < 5; j++)
            {
                if (m[i][j] != null)
                {
                    System.out.print(m[i][j] + " ");
                }
            }
        }
        System.out.println();
        System.out.println("----------------------------------------");

    }

    public static void visualizzaR()
    {
        int i;
        System.out.println("-----------------------------"
                           +"-----------------------------"
                           +"-----------------------------"
                           +"-----------------------------"); 
        for (i = 0; i < R.length; i++)
        {
            System.out.print("R"+ i + ": "+ R[i] + "  |  ");
        }
         System.out.println();
        System.out.println("-----------------------------"
                            +"-----------------------------"
                            +"-----------------------------"
                            +"-----------------------------"); 
    }
    public static void visualizzaRiga(String[]arr)
    {
        int i;
        for (i = 0; i < 5; i++)
        {
            if(arr[i] != null)
                System.out.print(arr[i]+" ");
        }
    }

    public static int esecuzione(String[][] Programma, boolean PassoPasso) throws IOException
    {
        int pc, i, val, posR1, posR2;
        int aux;
        int label;
        boolean cond = true;
        String[] LineEx = new String[5];
        Scanner s = new Scanner(System.in);
        String scelta;
        for (pc = 0; pc < Programma.length; pc++)
        {
            for (i = 0; i < 5; i++)
            {
                LineEx[i] = Programma[pc][i];
            }
            if (PassoPasso)
            {
                cond = true;
                System.out.println("Istruzioni Esecuzione Passo Passo:");
                System.out.println("c --> continua il programma");
                System.out.println("r --> visualizza i registri");
                System.out.println("f --> visualizza flag del confronto");
                
                do
                {
                System.out.println("--->");
                scelta = s.nextLine();
                switch(scelta)
                {
                    case "c":
                        System.out.println("Continuo Esecuzione Di Riga");
                        System.out.print("--->");
                        visualizzaRiga(LineEx);
                        System.out.println();
                        System.out.print("    ");
                        if(pc!=0)
                        {
                            visualizzaRiga(Programma[pc - 1]);
                            System.out.println();
                            System.out.print("    ");
                        }
                        visualizzaRiga(Programma[pc + 1]);
                        System.out.println();
                        System.out.println();
                        cond = false;
                        break;
                    case "r":
                        visualizzaR();
                        System.out.println();
                        cond = false;
                        break;
                    case "f":
                        System.out.println("C: "+C);
                        cond = false;
                        break;
                    default: System.out.println("Sintassi sbagliata!");
            }
                }while(cond);
            }
            switch (LineEx[0])
            {
                //Funzionalità della SVM1:
                case "ADD":
                    posR1 = 0;
                    posR2 = 0;
                    val = 0;

                    if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                    }
                    if ("R".equals(LineEx[3]))
                    {
                        posR2 = Integer.parseInt(LineEx[4]);
                    }

                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                    }
                    if ("I".equals(LineEx[3]))
                    {
                        val = Integer.parseInt(LineEx[4]);
                    }
                    if(posR2 != 0)
                        R[posR2] = R[posR2] + R[posR1] + val;
                    else
                        R[posR1] += val;
                    //System.out.println(R[posR1]);
                    break;
                case "SUB":
                    posR1 = 0;
                    posR2 = 0;
                    val = 0;

                    if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                    }
                    if ("R".equals(LineEx[3]))
                    {
                        posR2 = Integer.parseInt(LineEx[4]);
                    }

                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                    }
                    if ("I".equals(LineEx[3]))
                    {
                        val = Integer.parseInt(LineEx[4]);
                    }
                    
                    if(val == 0)
                    {
                        R[posR2] -= R[posR1];
                    }
                    else if(posR1 != 0)
                    {
                        R[posR1] -= val;
                    }
                    else
                    {
                        R[posR2] -= val;
                    }              

                    //System.out.println(R[posR1]);
                    break;
                case "MUL":
                    posR1 = 0;
                    posR2 = 0;
                    val = 0;

                    if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                    }
                    if ("R".equals(LineEx[3]))
                    {
                        posR2 = Integer.parseInt(LineEx[4]);
                    }

                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                    }
                    if ("I".equals(LineEx[3]))
                    {
                        val = Integer.parseInt(LineEx[4]);
                    }
                    
                    
                    if(val == 0)
                    {
                        R[posR2] *= R[posR1];
                    }
                    else if(posR1 != 0)
                    {
                        R[posR1] *= val;
                    }
                    else
                    {
                        R[posR2] *= val;
                    }              
                    //System.out.println(R[posR1]);
                    break;
                case "DIV":
                    posR1 = 0;
                    posR2 = 0;
                    val = 0;

                    if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                    }
                    if ("R".equals(LineEx[3]))
                    {
                        posR2 = Integer.parseInt(LineEx[4]);
                    }

                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                    }
                    if ("I".equals(LineEx[3]))
                    {
                        val = Integer.parseInt(LineEx[4]);
                    }
                    
                    
                    if(val == 0)
                    {
                        R[posR2] /= R[posR1];
                    }
                    else if(posR1 != 0)
                    {
                        R[posR1] /= val;
                    }
                    else
                    {
                        R[posR2] /= val;
                    }                    
                    //System.out.println(R[posR2]);
                    break;
                case "MOVE":
                    posR1 = 0;
                    posR2 = 0;
                    val = 0;
                    if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                    }
                    if ("R".equals(LineEx[3]))
                    {
                        posR2 = Integer.parseInt(LineEx[4]);
                    }

                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                    }
                    if ("I".equals(LineEx[3]))
                    {
                        val = Integer.parseInt(LineEx[4]);
                    }
                    if (posR1 == 0)
                    {
                        R[posR2] = val;
                    } else if(posR2 == 0)
                    {
                        R[posR1] = val;
                    }
                    else
                    {
                        aux = R[posR1];
                        R[posR1] = R[posR2];
                        R[posR2] = aux;
                    }
                    break;
                case "PRINT":
                    if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                        System.out.println(R[posR1]);
                    }
                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                        System.out.println(val);
                    }
                    break;

                //Funzionalità della SVM2: 
                case "JUMP":
                    label = Integer.parseInt(LineEx[2]);
                    i = 0;
                    while (i < L.length && L[i] != label)
                    {
                        i += 2;
                    }
                    pc = L[i + 1];
                    break;
                case "CMP":
                    cmp(LineEx);
                    break;
                case "JEQ":
                    if (C == 0)
                    {
                        label = Integer.parseInt(LineEx[2]);
                        i = 0;
                        while (i < L.length && L[i] != label)
                        {
                            i += 2;
                        }
                        pc = L[i + 1];
                    }
                    break;
                case "JGT":
                    if (C == 1)
                    {
                        label = Integer.parseInt(LineEx[2]);
                        i = 0;
                        while (i < L.length && L[i] != label)
                        {
                            i += 2;
                        }
                        pc = L[i + 1];
                    }
                    break;
                case "JLT":
                    if (C == -1)
                    {
                        label = Integer.parseInt(LineEx[2]);
                        i = 0;
                        while (i < L.length && L[i] != label)
                        {
                            i += 2;
                        }
                        pc = L[i + 1];
                    }
                    break;
                case "LABEL":
                    break;
                case "END":
                    break;
                default:
                    System.out.println("Errore in riga " + (pc + 1));
            }
        }
        return 0;
    }

    //------------------------------------------------------------------------------
    public static void cmp(String[] LineEx)
    {
        int posR1 = 0, posR2 = 0, val = 0;

        if ("R".equals(LineEx[1]))
                    {
                        posR1 = Integer.parseInt(LineEx[2]);
                    }
                    if ("R".equals(LineEx[3]))
                    {
                        posR2 = Integer.parseInt(LineEx[4]);
                    }

                    if ("I".equals(LineEx[1]))
                    {
                        val = Integer.parseInt(LineEx[2]);
                    }
                    if ("I".equals(LineEx[3]))
                    {
                        val = Integer.parseInt(LineEx[4]);
                    }
        if(posR1 != 0 && posR2 != 0)  
        {
        if (posR1 < posR2)
        {
            if (R[posR1] < R[posR2])
            {
                System.out.println("Minore");
                C = -1;
            } else if (R[posR1] > R[posR2])
            {
                System.out.println("Maggiore");
                C = 1;
            } else
            {
                System.out.println("Uguale");
                C = 0;
            }
        }
        
        if (posR1 > posR2)
        {
            if (R[posR2] < R[posR1])
            {
                C = -1;
            } else if (R[posR2] > R[posR1])
            {
                C = 1;
            } else
            {
                C = 0;
            }
        }
        }
        if (posR1 == 1)
        {
            if (R[posR1] < val)
            {
                C = -1;
            } else if (R[posR1] > val)
            {
                C = 1;
            } else
            {
                C = 0;
            }
        }
        if (posR1 != 1)
        {
            if (R[posR1] < val)
            {
                C = -1;
            } else if (R[posR1] > val)
            {
                C = 1;
            } else
            {
                C = 0;
            }
        }
    }

//------------------------------------------------------------------------------
    public static void getLabel() throws FileNotFoundException
    {
        FileReader fileIn = new FileReader("istruzioniSVM2.txt");
        Scanner s = new Scanner(fileIn);
        String Line;
        String[] SplittedLine = new String[5];
        int cont = 1;
        boolean end = true;
        int i;
        for (i = 0; i < L.length; i += 2)
        {
            L[i] = i / 2;
        }

        for (i = 0; s.hasNextLine() && end; i++)
        {
            Line = s.nextLine();
            if ("END".equals(Line))
            {
                end = false;
            }

            SplittedLine = Line.split("[\\p{IsPunctuation}\\p{IsWhiteSpace}]+");
            if ("LABEL".equals(SplittedLine[0]))
            {
                L[cont] = i;
                cont += 2;
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Scanner scan = new Scanner(System.in);
        int i, j;
        int N = 0;
        int scelta = -1;
        int PosR;
        String Line, NomeFile;
        String[] SplittedLine = new String[5];
        String[][] programma = null;

        getLabel(); //inserisco i label in L[]

        while (scelta != 0)
        {
            System.out.println("Premi 1 per caricare il programma");
            System.out.println("Premi 2 per visualizzare il programma");
            System.out.println("Premi 3 per visualizzare i registri");
            System.out.println("Premi 4 per modificare un registro");
            System.out.println("Premi 5 per salvare in memoria i registri");
            System.out.println("Premi 6 per salvare in memoria il programma");
            System.out.println("Premi 7 per eseguire il programma");
            System.out.println("Premi 8 per esecuzione passo passo");
            System.out.println("Premi 0 per terminare");
            scelta = scan.nextInt();
            switch (scelta)
            {
                case 1:
                {
                    /*
                    System.out.println("Inserisci nome del file");
                    scan.nextLine();
                    NomeFile = scan.nextLine();
                    FileReader fileIn = new FileReader(NomeFile);
                    */
                    FileReader fileIn = new FileReader("istruzioniSVM2.txt");
                    Scanner s = new Scanner(fileIn);

                    while (s.hasNextLine())
                    {
                        s.nextLine();
                        N++;
                    }
                    programma = new String[N][5];
                    s.close();
                    fileIn.close();
                    //fileIn = new FileReader(NomeFile);
                    fileIn = new FileReader("istruzioniSVM2.txt");
                    s = new Scanner(fileIn);
                    //carico il programma
                    for (i = 0; i < programma.length; i++)
                    {
                        Line = s.nextLine();
                        SplittedLine = Line.split("[\\p{IsPunctuation}\\p{IsWhiteSpace}]+");
                        for (j = 0; j < 5 && j < SplittedLine.length; j++)
                        {
                            programma[i][j] = SplittedLine[j];
                        }
                    }
                    s.close();
                    fileIn.close();
                    //fileIn = new FileReader(NomeFile);
                    fileIn = new FileReader("istruzioniSVM2.txt");
                    s = new Scanner(fileIn);
                    getLabel();
                    break;
                }
                case 2:
                {
                    visualizza(programma);
                }
                break;

                case 3:
                    visualizzaR();
                    break;
                case 4:
                    System.out.println("Inserisci il numero del registro da modificare");
                    PosR = scan.nextInt();
                    System.out.println("Inserisci il valore da inserire");
                    R[PosR] = scan.nextInt();
                    System.out.println("Operazione Riuscita");
                    break;
                case 5:
                    System.out.println("Inserisci nome del file");
                    scan.nextLine();
                    NomeFile = scan.nextLine();
                    PrintWriter fileOut = new PrintWriter(NomeFile + ".txt");
                    fileOut.print("Registri: ");
                    for (i = 0; i < R.length; i++)
                    {
                        fileOut.print("R"+ i + ": "+ R[i] + "  |  ");
                    }
                    fileOut.close();
                    break;
                case 6:
                    System.out.println("Inserisci nome del file");
                    scan.nextLine();
                    NomeFile = scan.nextLine();
                    PrintWriter FileOut = new PrintWriter(NomeFile + ".txt");
                    for (i = 0; i < programma.length; i++)
                    {
                        FileOut.println();
                        for (j = 0; j < 5; j++)
                        {
                            if (programma[i][j] != null)
                            {
                                FileOut.print(programma[i][j] + " ");
                            }
                        }
                    }
                    FileOut.close();

                    break;
                case 7:
                    esecuzione(programma, false);
                    break;
                case 8:
                    esecuzione(programma, true);
            }
        }
    }
}
