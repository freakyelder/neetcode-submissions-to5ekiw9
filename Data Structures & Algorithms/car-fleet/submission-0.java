class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] car=new int[n][2];

        for(int i=0;i<n;i++){
            car[i][0]=position[i];
            car[i][1]=speed[i];
        }

        Arrays.sort(car,(a,b)->b[0]-a[0]);

        int fleets=0;
        double maxtime=0;

        for(int i=0;i<n;i++){
            int pos=car[i][0];
            int spd=car[i][1];

            double time=(double)(target-pos)/spd;

            if(time>maxtime){
                fleets++;
                maxtime=time;
            }
        }

        return fleets;
    }
}
