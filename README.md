# Greedy2

## 1.그리디 알고리즘
- 욕심쟁이 방법, 탐욕적 방법
- 최적화 문제(가능한 해들 중에 최대 또는 최소 해를 찾는 문제)를 해결
- 데이터간 관계 고려 X, 최대 또는 최소만을 선택(근시안적 선택)
- 선택을 절대로 번복 X
- 매우 단순한 편
![image](https://user-images.githubusercontent.com/80511265/114722898-27d5f580-9d75-11eb-9dea-3fa50bf6fec3.png)

### 대표적인  그리디 알고리즘 유형
* __동전 거스름돈__</br>
가장 큰 동전부터 맞춰나간다. 남은 액수를 초과하지 않는다는 조건 하에 '욕심내어' 가장 큰 액수의 동전들을 취한다.

* __최소 신장 트리__</br>
사이클 없이 모든 점을 연결하는 트리 중 가중치가 최소인 것을 찾는다. 가중치가 가장 작은 선분이 사이클을 만들지 않을 때만 '욕심내어' 그 선분을 추가한다.

* __Dijkstra(다익스트라) 최단 경로__</br>
주어진 점에서 시작한다. 최단거리가 아니라 출발점에서 가장 가까운 점을 '욕심내어' 선택하고 그 점의 최단거리를 확정한다.

* __부분 배낭 문제__</br>
무게와 가치를 가진 n개의 물건을 한정된 용량의 배낭에 최대의 가치를 가지도록 정한다. 물건을 분말처럼 부분적으로 담는 것이 허용된다. 무게 대비 가장 가치가 높은 물건을 '욕심내어' 담는다.

* __집합 커버 문제__</br>
집합U의 부분 집합들을 원소로 하는 집합F가 주어질 때,  F의 원소를 골라 합집합하여 집합U가 되게 한다. 이때, F의 원소들의 갯수를 최소화 하여 선택한다. 최적해를 찾는 문제이지만, 근사해를 찾는 근사 알고리즘이 더 유리하다.

* *__작업 스케줄링__*</br>
최소한의 기계 수로 주어진 작업을 처리하는 문제. 작업의 수행 시간이 중복되지 않도록 모든 작업을 가장 적은 수의 기계에 배정한다. 빠른 시작시간 작업을 우선(Earliest start time first)배정 알고리즘은 최적해를 구할 수 있다. 

* __허프만 압축__</br>
빈도가 잦은 문자에는 짧은 이진 코드를, 드물게 나타나는 문자에는 긴 이진코드를 할당한다. 트리를 생성하고, 각 노드에 코드를 부여하는 과정.

### 작업 스케줄링 알고리즘 수행과정
![img](https://user-images.githubusercontent.com/80511265/114723064-4f2cc280-9d75-11eb-9ff8-474ac1e6f4e1.png)
![img (1)](https://user-images.githubusercontent.com/80511265/114723092-55bb3a00-9d75-11eb-9802-26291aacd270.png)
![img (3)](https://user-images.githubusercontent.com/80511265/114723118-5ce24800-9d75-11eb-97de-6ca70279351f.png)

### 작업 스케줄링 알고리즘의 응용 분야
비즈니스 프로세싱, 공장 생산 공정, 강의실/세미나룸 배정, 컴퓨터 태스크 스케줄링 등등


## 2.작업스케줄링
**'작업스케줄링(Job Scheduling)** 문제' 는 n개의 작업, 각 작업의 수행 시간 ti(i=1,2,3,4,5,...n) 그리고 m개의 동일한 기계가 주어질 때,</br>
모든 작업이 가장 빨리 종료되도록 작업을 기계(machine)에 배정하는 문제이다.</br>
단, 한 작업은 배정된 기계에서 연속적으로 수행, 기계는 1번에 하나의 작업만을 수행한다.</br> 
작업 스케줄링 문제를 해결하기 위한 가장 간단한 방법은 그리디 알고리즘을 이용해 푸는 것이다.</br>
즉, 배정된 작업이 가장 빨리 끝나는 기계에 새 작업을 배정해주는 것이다. 


## 3.작업스케줄링 설계과정
작업의 수 n과 각 작업들의 시작 시간과 종료 시간이 기본적으로 입력값으로 들어온다.</br>
또한, 어떠한 경우에도 배치된 기계가 작업의 수보다 많을 수는 없다. 최대 기계 개수는 n값 만큼이 되는 것이다.</br>
우리에게 주어진 정보를 바탕으로 최적해를 구할 수 있는데, 시작시간, 종료시간, 작업의 길이를 바탕으로 알고리즘을 구현해주면 된다.</br>
네 가지 정도의 경우가 존재하는데, 빠른 시작시간 작업 우선, 빠른 종료시간 작업 우선, 짧은 작업 우선, 긴 작업 우선 이렇게가 있다.</br>
이 중에서도 빠른 시작시간 작업을 우선한 알고리즘으로 작업스케줄링을 설계하려 했다. 

```java
입력: n개의 작업
출력: 기계에 배정된 작업의 순서

작업 시작 전, 빠른 시작 시간으로 오름차순 정렬하여 배열에 삽입
배열[0] ~ 배열[n-1], i=0 초기화

while(i<n){
if(배열[i] 수행할 수 있는 기계 존재)
 존재시 배열[i]를 해당 기계에 배정
 존재를 안할시 새로운 기계를 찾아 배열[i]를 배정
 i++
}

기계에 배정된 결과 return
```
위와 같은 코드로 작업을 해줄 때, 시간복잡도는 n개 입력받은 작업을 정렬하는 데 O(nlogn) 시간이 걸리고,</br>
입력받은 n을 맞는 기계에 배정해주는 O(m)의 시간 while 루프가 입력만큼 수행되는 시간O(n)을 곱해줘 O(mn)의 시간이 걸린다.</br>
결국, 작업스케줄링에 시간 복잡도는 O(nlogn)+O(mn)이 걸리게 된다.


## 4.자바코드
```java
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
```

## 5.코드결과
![작업스케줄러](https://user-images.githubusercontent.com/80510945/114746478-c6b91c80-9d8a-11eb-90d8-3a07f40ca338.jpg)

