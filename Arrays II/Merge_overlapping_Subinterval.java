package ArraysII;

public class Merge_overlapping_Subinterval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list = new ArrayList();
        int i=0;
        int n=intervals.length,s=-1,e=-1;
        while(i<n){
            if(s==-1){
                s=intervals[i][0];
                e=intervals[i][1];
                i++;
            }
            else{
                if(intervals[i][0]<=e){
                    e=Math.max(e,intervals[i][1]);
                    i++;
                }
                else{
                    list.add(new int[]{s, e});
                    s=intervals[i][0];
                    e=intervals[i][1];
                    i++;
                }
            }
        }
        if(s!=-1){
            list.add(new int[]{s, e});
        }
        int[][] arr = new int[list.size()][2];
        return list.toArray(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[][] ans = merge(arr);
        System.out.println("Intervals after merge operation are:");
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i][0]+" "+ans[i][1]);
        }
    }
}
