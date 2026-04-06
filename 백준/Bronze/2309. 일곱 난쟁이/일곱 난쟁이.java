import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dwarf_h = new int[9];
        int sum = 0;

        for(int i=0;i<dwarf_h.length;i++){
            dwarf_h[i] = sc.nextInt();
            sum += dwarf_h[i];
        }
        
        Arrays.sort(dwarf_h);

        for(int i=0;i<dwarf_h.length; i++){
            for(int j=i+1;j<dwarf_h.length;j++){
                if(sum - (dwarf_h[i] + dwarf_h[j]) == 100){
                    for(int h=0;h<dwarf_h.length;h++){
                        if(h==i || h==j)
                            continue;
                        System.out.println(dwarf_h[h]);
                    }
                    return;
                }
            }
        }
    }
}