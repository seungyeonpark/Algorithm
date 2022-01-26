### [9184 신나는 함수 실행](https://www.acmicpc.net/status?user_id=seungyeonpark&problem_id=9184&from_mine=1)

메모이제이션을 사용해 재귀함수의 결과를 출력하는 문제

> 입력
* 입력 범위는 -50 ≤ a, b, c ≤ 50

> 문제 해결
* 변수가 3개이므로 3차원 배열 이용
* 처음엔 입력값의 범위가 -50부터 50까지여서 배열의 용량을 101개로 선언함 (...)
    * 하지만 0이하와 20초과는 값이 결정되기 때문에 실질적으로 필요한 용량은 20개!!
    * 입력값을 그대로 인덱스로 쓸 것이기 때문에 21개의 용량으로 선언함
* 캐싱되는 범위를 초과한 입력값들은 early return!