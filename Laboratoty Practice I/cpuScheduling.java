import java.util.Scanner;

public class cpuScheduling {

    public static void FCFS(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of process: ");
        int n = sc.nextInt();
        int process[] = new int[n];
        int bst[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];

        System.out.println();

        System.out.println("Enter Burst time");
        for(int i = 0; i < n; i++){
            System.out.print("Process["+(i+1)+"]: ");
            bst[i] = sc.nextInt();
            process[i] = i+1;
        }  

        System.out.println();
        System.out.println("**************** FCFS Scheduling **********************");
        wt[0] = 0;
        int total = 0;
        for(int i = 1; i < n; i++){
            wt[i] = 0;
            for(int j = 0; j < i; j++){
                wt[i] += bst[j];
            }
            total += wt[i];
        }
        float wt_avg = (float)total/n;

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Process\t\t| Wait Time\t\t| Burst Time\t\t| Turnaround Time");
        System.out.println("----------------------------------------------------------------------------------");

        total = 0;
        for(int i = 0; i < n; i++){
            tat[i] = wt[i] + bst[i];
            System.out.println("\np"+process[i]+"\t\t|\t"+wt[i]+"\t\t|\t"+bst[i]+"\t\t|\t"+tat[i]);
            total += tat[i];
        }
        float tat_avg = total/n;

        System.out.println("Average waiting time: "+ wt_avg);
        System.out.println("Turnaround Time: " + tat_avg);

    }




    public static void SJF(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of process: ");
        int n = sc.nextInt();
        int process[] = new int[n];
        int bst[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];

        System.out.println();

        System.out.println("Enter burst time");
        for (int i = 0; i < n; i++) {
            System.out.print("Process["+(i+1)+"]: ");
            bst[i] = sc.nextInt();
            process[i] = i+1;
        }

        System.out.println();

        System.out.println("******************* SJF Scheduling *******************************");
        for(int i = 0; i < n; i++){
            int k = i;
            for(int j = i+1; j < n; j++){
                if(bst[j] < bst[k]){
                    k = j;
                }
                int temp = bst[i];
                bst[i] = bst[j];
                bst[j] = temp;
                temp = process[i];
                process[i] = process[k];
                process[k] = temp;
            }
        }

        int total = 0;
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = 0;
            for (int j = 0; j < i; j++) {
                wt[i] += bst[j];
            }
            total += wt[i];
        }
        float wt_avg = (float)total/n;

        total = 0;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Process\t\t| Wait Time\t\t| Burst Time\t\t| Turnaround Time");
        System.out.println("----------------------------------------------------------------------------------");
        for(int i = 0; i < n; i++){
            tat[i] = wt[i] + bst[i];
            total += tat[i];
            System.out.println("\np"+process[i]+"\t\t|\t"+wt[i]+"\t\t|\t"+bst[i]+"\t\t|\t"+tat[i]);
        }
        float tat_avg = (float)total/n;        

        System.out.println("Average waiting time: " + wt_avg);
        System.out.println("Average waiting time: " + tat_avg);
    }



    public static void RR(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of process(MAX 10): ");
        int n = sc.nextInt();
        int wt[] = new int[10];
        int rt[] = new int[10];
        int bst[] = new int[10];

        System.out.println("Enter burst time");
        for (int i = 0; i < n; i++) {
            System.out.print("p["+(i+1)+"]: ");
            bst[i] = sc.nextInt();
            rt[i] = bst[i];
            wt[i] = 0;
        }

        System.out.println();
        System.out.print("Enter quantum: ");
        int q = sc.nextInt();

        int rp = n;
        int i = 0;
        int time = 0;
        System.out.print("0");
        wt[0] = 0;

        while(rp != 0){
            if(rt[i] > q){
                rt[i] -= q;
                System.out.print(" | p["+(i+1)+"] | ");
                time += q;
                System.out.print(time);
            }
            else if(rt[i] <= q && rt[i] > 0){
                time += rt[i];
                rt[i] -= rt[i];
                System.out.print(" | p["+(i+1)+"] ");
                rp--;
                System.out.print(time);
            }
            i++;
            if(i == n){
                i = 0;
            }
        }
    }

    public static void Priority(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of process: ");
        int n = sc.nextInt();
        int bst[] = new int[10];
        int p[] = new int[10];
        int pp[] = new int[10];
        int wt[] = new int[10];
        int tat[] = new int[10];

        System.out.println("Enter burst time and priority of each process");
        for (int i = 0; i < n; i++) {
            System.out.print("p["+(i+1)+"]: ");
            bst[i] = sc.nextInt();
            pp[i] = sc.nextInt();
            p[i] = i+1;
        }

        for(int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++) {
                if(pp[i] < pp[j]){
                    int temp = pp[i];
                    pp[i] = pp[j];
                    pp[j] = temp;

                    temp = bst[i];
                    bst[i] = bst[j];
                    bst[j] = bst[i];

                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }

        wt[0] = 0;
        int avg_wt = 0;
        tat[0] = bst[0];
        int avg_tat = tat[0];

        for(int i = 1; i < n; i++){
            wt[i] = tat[i-1];
            avg_wt += wt[i];
            tat[i] = wt[i] + bst[i];
            avg_tat += tat[i];
        }

        System.out.println("******************** Priority **********************");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------");
        System.out.println("\tProcess \t| Priority \t\t| Burst time \t\t| wait time \t\t| Turnaround time");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------");

        for(int i = 0; i < n; i++){
            System.out.println("\t" + p[i] +"\t\t|\t"+ pp[i] +"\t\t|\t" + bst[i] +"\t\t|\t" + wt[i] +"\t\t|\t" + tat[i]);
        }


        System.out.println("Average waiting time : " + avg_wt/n);
        System.out.println("Average turnaround time : " + avg_tat/n);
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        do{
            System.out.println("\n\n***** MENU *****\n1. Fcfs \n2. SJF \n3. RR \n4. Priority \n5. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            
            switch(ch){
                case 1:
                    FCFS();
                    break;

                case 2:
                    SJF();
                    break;

                case 3:
                    RR();
                    break;

                case 4:
                    Priority();
                    break;

                case 5:
                    System.out.println("Program terminated successfully.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again between(1 to 5).");
            }
        }while(ch != 5);

        sc.close();
    }
}






           


