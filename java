public class JobSchedule {
        public static void main(String[] args)
        {

            int n=7,machine=0; // n개의 입력을 받으므로 machine의 개수는 최대 7개까지 가능하다.
            int [] mc=new int[7]; //실행될 기계
            int [][] job= { {2, 5 ,0}, {1, 4, 0}, {6, 9, 0}, {1, 3, 0}, {0, 2, 0}, {7, 8, 0}, {4, 6, 0} };

            for(int i=0;i<n;i++) //시작시간 별로 정렬
            {
                for(int j=0;j<n;j++)
                {
                    if(job[i][0]<job[j][0])
                    {
                        int index=job[i][0];
                        job[i][0]=job[j][0];
                        job[j][0]=index;
                        index=job[i][1];
                        job[i][1]=job[j][1];
                        job[j][1]=index;
                    }
                }
            }
            //정렬된 시간 순서로 작업을 기계에 배치
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(mc[j]<=job[i][0])
                    {
                        mc[j]=job[i][1];
                        job[i][2]=j;
                        break;
                    }
                }
            }
            //기계 사용 개수 확인해주는 반복문
            for(int i=0;i<n;i++)
            {
                if(mc[i]==0)
                {
                    machine=i;
                    break;
                }
            }

            System.out.println("사용된 기계의 수 : "+machine);

            //기계별로 배정된 작업 출력
            for(int i=0;i<machine;i++)
            {
                System.out.print("기계" + (i+1) + " : ");
                for(int j=0;j<n;j++)
                {
                    if(job[j][2]==i)System.out.print(job[j][0]+","+job[j][1]+" ");
                }
                System.out.println();
            }
        }

}
